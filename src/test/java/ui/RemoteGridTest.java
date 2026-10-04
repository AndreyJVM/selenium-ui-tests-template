package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoteGridTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createDriver();
    }

    @Test
    public void testSeleniumGridConnection() {
        driver.get("https://www.selenium.dev/");
        String title = driver.getTitle();
        
        System.out.println("Page Title is: " + title);
        assertTrue(title.contains("Selenium"), "Title should contain 'Selenium'");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
