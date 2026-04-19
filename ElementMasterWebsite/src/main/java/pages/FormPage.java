package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormPage extends BasePage {

    // Correct locators for DemoQA Practice Form
    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");

    // You can add more locators later (mobile, gender, etc.)

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(String fName, String lName, String emailId) {
        // Wait for the form to be visible before interacting
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        type(firstName, fName);
        type(lastName, lName);
        type(email, emailId);

        // TODO: Add more fields later (gender, mobile, date, subjects, etc.)
    }

    public void submitForm() {
        // Strong click for Submit button (it often gets blocked by footer)
        click(By.id("submit"));
    }

    // Optional: Check success message after submit
    public boolean isSubmissionSuccessful() {
        try {
            By successModal = By.id("example-modal-sizes-title-lg"); // or By.cssSelector(".modal-content")
            return isDisplayed(successModal);
        } catch (Exception e) {
            return false;
        }
    }
}