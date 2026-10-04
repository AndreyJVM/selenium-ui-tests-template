package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.time.Duration;

public class WebDriverFactory {

    public static WebDriver createDriver() {
        boolean runOnGrid = Boolean.parseBoolean(System.getProperty("RUN_ON_GRID", "false"));

        WebDriver driver;
        if (runOnGrid) {
            String gridUser = System.getenv().getOrDefault("GRID_USER", "admin");
            String gridPass = System.getenv().getOrDefault("GRID_PASS", "password");
            String gridDomain = System.getenv().getOrDefault("GRID_DOMAIN", "localhost");
            
            String gridUrl = String.format("https://%s:%s@%s/wd/hub", gridUser, gridPass, gridDomain);
            
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            try {
                driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), options);
            } catch (Exception e) {
                throw new RuntimeException("Failed to connect to Remote Grid: " + gridUrl, e);
            }
        } else {
            driver = new ChromeDriver();
        }
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
}
