package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        maximizeWindow();
        blockAdsAggressively();
        hideAnyVisibleAds();
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }

    private void blockAdsAggressively() {
        if (driver instanceof ChromeDriver chromeDriver) {
            try {
                Map<String, Object> params = new HashMap<>();
                params.put("urls", Arrays.asList(
                    "*googlesyndication.com*",
                    "*doubleclick.net*",
                    "*pagead2.googlesyndication.com*",
                    "*googleads.g.doubleclick.net*",
                    "*safeframe.googlesyndication.com*"
                ));
                chromeDriver.executeCdpCommand("Network.setBlockedURLs", params);
            } catch (Exception ignored) {}
        }
    }

    private void hideAnyVisibleAds() {
        try {
            ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('iframe[src*=\"safeframe\"], " +
                "iframe[src*=\"googlesyndication\"], iframe[src*=\"doubleclick\"]').forEach(el => {" +
                "   el.style.setProperty('display', 'none', 'important');" +
                "   el.style.setProperty('visibility', 'hidden', 'important');" +
                "   el.style.setProperty('height', '0', 'important');" +
                "});"
            );
        } catch (Exception ignored) {}
    }

    /*** STRONG CLICK METHOD - This is the main fix ***/
    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to center
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        // Re-wait
        wait.until(ExpectedConditions.elementToBeClickable(locator));

        try {
            element.click();
            return;
        } catch (ElementClickInterceptedException e) {
            System.out.println("Ad intercepted click → trying JS click");
        } catch (Exception e) {
            System.out.println("Normal click failed → trying JS click");
        }

        // JS Click fallback
        try {
            js.executeScript("arguments[0].click();", element);
        } catch (Exception ex) {
            hideAnyVisibleAds();
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            js.executeScript("arguments[0].click();", element);
        }
    }

    // Other methods (keep as they are)
    public WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void type(By locator, String text) {
        WebElement element = waitForElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return waitForElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        try {
            return waitForElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public Alert switchToAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void switchToFrame(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}