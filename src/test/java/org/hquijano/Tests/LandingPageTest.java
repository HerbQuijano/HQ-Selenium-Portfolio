package org.hquijano.Tests;

import org.hquijano.core.DriverFactory;
import org.hquijano.listeners.ScreenshotListener;
import org.hquijano.pages.LandingPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(ScreenshotListener.class)
public class LandingPageTest extends BaseTest {
    private int numberOfButtons = 19;

    @Test
    public void testTitle() {
        String title = landingPage.navigateTo().getTitle();
        Assert.assertEquals(title, "Learn and Practice Automation | automateNow");
    }

    @Test
    public void testNumberOfButtons(){
        List<WebElement> buttonElements = landingPage.navigateTo().getButtonElements();
        Assert.assertEquals(buttonElements.size(), numberOfButtons, "The number of buttons on the landing page is incorrect");
    }

    @Test
    public void testHeadingText(){
        String headingText = landingPage.navigateTo().getHeadingTitle();
        Assert.assertEquals(headingText, "Welcome to your software automation practice website!");
    }

}
