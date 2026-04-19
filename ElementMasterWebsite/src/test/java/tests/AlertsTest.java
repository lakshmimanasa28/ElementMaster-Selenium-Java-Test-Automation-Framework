package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AlertsPage;
import pages.HomePage;

public class AlertsTest extends BaseTest {

    HomePage home;
    AlertsPage alertPage;

    @Test
    public void testAlerts() {

        resetBrowser();

        home = new HomePage(driver);
        alertPage = home.goToAlerts();

        alertPage.clickSimpleAlert();
    }
}