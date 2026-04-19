package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {

    ConfigReader config = new ConfigReader();
    protected static WebDriver driver;
    protected BasePage basePage;   // ← Important: Add this

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void setup() {
        String browser = config.getBrowser();
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException("Only Chrome is supported");
        }
        // Do NOT maximize here - we'll do it in BasePage
    }

    @BeforeMethod
    public void beforeMethod() {
        resetBrowser();                    // Clean state before each test
        basePage = new BasePage(driver);   // This triggers ad blocking, maximize, etc.
    }

    @AfterMethod
    public void afterMethod() {
        // Optional: You can add screenshot on failure logic here later
    }

    // FINAL RESET METHOD
    public void resetBrowser() {
        try {
            // 1. Handle alert if present
            try {
                driver.switchTo().alert().accept();
            } catch (Exception e) {}

            // 2. Get main window
            String mainWindow = driver.getWindowHandle();

            // 3. Close extra tabs
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(mainWindow)) {
                    driver.switchTo().window(handle);
                    driver.close();
                }
            }

            // 4. Switch back to main window
            driver.switchTo().window(mainWindow);

            // 5. Exit any frame
            driver.switchTo().defaultContent();

            // 6. Clear cookies
            driver.manage().deleteAllCookies();

            // 7. Go to homepage
            driver.navigate().to(config.getBaseUrl());
        } catch (Exception e) {
            System.out.println("Reset issue: " + e.getMessage());
        }
    }

    @AfterSuite
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}