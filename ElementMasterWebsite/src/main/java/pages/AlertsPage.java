package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    By alertButton = By.id("alertButton");

    public void clickSimpleAlert() {
        click(alertButton);
        Alert alert = switchToAlert();
        alert.accept();
    }
}