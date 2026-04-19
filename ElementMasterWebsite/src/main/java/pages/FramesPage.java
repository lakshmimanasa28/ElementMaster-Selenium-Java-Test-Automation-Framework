package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    By frame1 = By.id("frame1");
    By frame2 = By.id("frame2");

    By frameText = By.id("sampleHeading");

    // Switch to Frame 1 and get text
    public String getFrame1Text() {
        switchToFrame(frame1);
        String text = getText(frameText);
        switchToDefaultContent();
        return text;
    }

    // Switch to Frame 2 and get text
    public String getFrame2Text() {
        switchToFrame(frame2);
        String text = getText(frameText);
        switchToDefaultContent();
        return text;
    }
}