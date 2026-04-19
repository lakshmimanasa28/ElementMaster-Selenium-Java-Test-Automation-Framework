package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

import java.util.Set;

public class WindowPage extends BasePage {

    public WindowPage(WebDriver driver) {
        super(driver);
    }

    By newTabButton = By.id("tabButton");
    By newWindowButton = By.id("windowButton");

    String parentWindow;

    public void openNewTab() {
        parentWindow = driver.getWindowHandle();
        click(newTabButton);
        switchToNewWindow();
    }

    public void openNewWindow() {
        
        driver.switchTo().window(parentWindow);

        click(newWindowButton);
        switchToNewWindow();
    }

    public void switchToNewWindow() {
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void switchToParent() {
        driver.switchTo().window(parentWindow);
    }
}