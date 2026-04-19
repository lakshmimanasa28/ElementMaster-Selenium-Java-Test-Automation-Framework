package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.WindowPage;

public class WindowTest extends BaseTest {

    HomePage home;
    WindowPage windowPage;

    @Test
    public void testWindows() {

        resetBrowser();

        home = new HomePage(driver);
        windowPage = home.goToWindows();

        windowPage.openNewTab();
//        System.out.println("New Tab opened");

        windowPage.switchToParent();

        windowPage.openNewWindow();
//        System.out.println("New Window opened");
    }
}