package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FormPage;
import pages.HomePage;

public class FormTest extends BaseTest {

    @Test
    public void testPracticeForm() {
        HomePage homePage = new HomePage(driver);
        FormPage formPage = homePage.goToForm();

        formPage.fillForm("Manasa", "Lakshmi", "lakshmimanasak@gmail.com");
        formPage.submitForm();

        // Optional assertion
        // Assert.assertTrue(formPage.isSubmissionSuccessful(), "Form submission failed!");
    }
}