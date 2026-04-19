package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {   // ← Important: Extend BasePage

    public HomePage(WebDriver driver) {
        super(driver);   // This calls BasePage constructor (ad blocking + maximize)
    }

    // ---------- FORMS ----------
    public FormPage goToForm() {
        click(By.xpath("//h5[text()='Forms']"));           // Use strong click
        click(By.xpath("//span[text()='Practice Form']")); // This was failing
        return new FormPage(driver);
    }

    // ---------- WEB TABLE ----------
    public WebTablePage clickWebTable() {
        click(By.xpath("//h5[text()='Elements']"));
        click(By.xpath("//span[text()='Web Tables']"));
        return new WebTablePage(driver);
    }

    // ---------- ALERTS ----------
    public AlertsPage goToAlerts() {
        click(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        click(By.xpath("//span[text()='Alerts']"));
        return new AlertsPage(driver);
    }

    // ---------- FRAMES ----------
    public FramesPage goToFrames() {
        click(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        click(By.xpath("//span[text()='Frames']"));
        return new FramesPage(driver);
    }

    // ---------- WINDOWS ----------
    public WindowPage goToWindows() {
        click(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        click(By.xpath("//span[text()='Browser Windows']"));
        return new WindowPage(driver);
    }

    // ---------- WIDGETS ----------
    public WidgetsPage clickDatePicker() {
        click(By.xpath("//h5[text()='Widgets']"));
        click(By.xpath("//span[text()='Date Picker']"));
        return new WidgetsPage(driver);
    }

    public WidgetsPage clickSlider() {
        click(By.xpath("//h5[text()='Widgets']"));
        click(By.xpath("//span[text()='Slider']"));
        return new WidgetsPage(driver);
    }

    public WidgetsPage clickAccordian() {
        click(By.xpath("//h5[text()='Widgets']"));
        click(By.xpath("//span[text()='Accordian']"));
        return new WidgetsPage(driver);
    }
}