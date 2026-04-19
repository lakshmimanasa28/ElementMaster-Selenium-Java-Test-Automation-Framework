package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class WebTablePage extends BasePage {

    
    String studentName = "Manasa";

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    By addButton = By.id("addNewRecordButton");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By age = By.id("age");
    By salary = By.id("salary");
    By department = By.id("department");
    By submitBtn = By.id("submit");
    By searchBox = By.id("searchBox");

    public void clickAdd() {
        click(addButton);
    }

    // 👇 Using your name inside page logic
    public void fillFormWithMyName() {
        type(firstName, studentName);
        type(lastName, "Lak");
        type(email, "lakshmimanasak@test.com");
        type(age, "22");
        type(salary, "70000");
        type(department, "IT");
    }

    public void submitForm() {
        click(submitBtn);
    }

    public void searchMyRecord() {
        type(searchBox, studentName);
    }
}