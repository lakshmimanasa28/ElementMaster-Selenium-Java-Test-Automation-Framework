package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class WidgetsPage extends BasePage {
    By dateInput=By.id("datePickerMonthYearInput");
    
    By slider=By.xpath("//input[@type='range']");
    By sliderValue=By.id("sliderValue");
    
    By section2=By.xpath("//button[normalize-space()='Where does it come from?']");
    
    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    public void selectDate(String date) {
        click(dateInput);

        WebElement element = driver.findElement(dateInput);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);         

        element.sendKeys(date);
        element.sendKeys(Keys.ENTER);
    }

    public String getSelectedDate() {
        return driver.findElement(dateInput).getAttribute("value");
    }


    public void moveSlider(int times) {
        WebElement slide = driver.findElement(slider);
        for (int i = 0; i < times; i++) {
            slide.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue() {
        return driver.findElement(By.id("sliderValue")).getAttribute("value");
    }


    public void clickSection2() {
        wait.until(ExpectedConditions.presenceOfElementLocated(section2));
        WebElement element = driver.findElement(section2);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300)");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isSection2Expanded() {
        try {
            wait.until(ExpectedConditions.attributeToBe(section2, "aria-expanded", "true"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}