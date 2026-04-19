package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.FramesPage;
import pages.HomePage;

public class FramesTest extends BaseTest {

    HomePage home;
    FramesPage framesPage;

    @Test
    public void testFrames() {

        resetBrowser();

        home = new HomePage(driver);
        framesPage = home.goToFrames();

//        System.out.println("Frame 1 Text: " + framesPage.getFrame1Text());
//        System.out.println("Frame 2 Text: " + framesPage.getFrame2Text());
    }
}