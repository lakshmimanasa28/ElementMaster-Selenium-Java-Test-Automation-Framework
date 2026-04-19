package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.WebTablePage;

public class WebTableTest extends BaseTest {

    HomePage home;
    WebTablePage webTable;

    @Test
    public void testWebTableFlow() {

        resetBrowser();

        home = new HomePage(driver);
        webTable = home.clickWebTable();

        webTable.clickAdd();
        webTable.fillFormWithMyName();
        webTable.submitForm();
        webTable.searchMyRecord();
    }
}