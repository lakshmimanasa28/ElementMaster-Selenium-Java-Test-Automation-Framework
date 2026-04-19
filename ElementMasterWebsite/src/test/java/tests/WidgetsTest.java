package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.WidgetsPage;

public class WidgetsTest extends BaseTest {

    @Test
    public void testDatePicker() {

        resetBrowser();

        HomePage hp = new HomePage(driver);
        WidgetsPage widget = hp.clickDatePicker();

        widget.selectDate("10/11/2004");
        Assert.assertEquals(widget.getSelectedDate(), "10/11/2004");
    }

    @Test
    public void testSlider() {

        resetBrowser();

        HomePage hp = new HomePage(driver);
        WidgetsPage widget = hp.clickSlider();

        widget.moveSlider(5);
        Assert.assertTrue(Integer.parseInt(widget.getSliderValue()) > 0);
    }

    @Test
    public void testAccordian() {

        resetBrowser();

        HomePage hp = new HomePage(driver);
        WidgetsPage widget = hp.clickAccordian();

        widget.clickSection2();
        Assert.assertTrue(widget.isSection2Expanded());
    }
}