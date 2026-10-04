# Selenium UI Tests Template

This is a starter template for writing Java UI tests and running them on your own Remote Selenium Grid infrastructure.

## Setup

1. **Clone the repository.**
2. **Install dependencies** using Maven:
   ```bash
   mvn clean install -DskipTests
   ```

## Running Tests Locally

To run the tests on your local machine (requires Google Chrome to be installed):
```bash
mvn test
```

## Running Tests on Remote Selenium Grid

To run the tests on your remote Selenium Grid (deployed via Ansible), you need to provide the credentials and domain of your grid via environment variables, and pass the `-DRUN_ON_GRID=true` flag.

**Linux / macOS:**
```bash
export GRID_USER="admin"
export GRID_PASS="your-secure-password"
export GRID_DOMAIN="selenium.your-domain.com"
mvn test -DRUN_ON_GRID=true
```

**Windows (PowerShell):**
```powershell
$env:GRID_USER="admin"
$env:GRID_PASS="your-secure-password"
$env:GRID_DOMAIN="selenium.your-domain.com"
mvn test -DRUN_ON_GRID=true
```

## GitHub Actions CI/CD

This project includes a ready-to-use GitHub Actions workflow (`.github/workflows/run-tests.yml`). 
To enable it in your GitHub repository, add the following **Repository Secrets** in `Settings -> Secrets and variables -> Actions`:
- `GRID_USER`
- `GRID_PASS`
- `GRID_DOMAIN`

The workflow will automatically run your tests against the remote Selenium Grid on every push to the `main` branch.
