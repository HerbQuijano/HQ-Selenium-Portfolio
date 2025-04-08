package org.hquijano.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LandingPageTest extends BaseTest {
    private int numberOfButtons = 19;

    @Test
    public void testTitle() {
        String title = landingPage.getTitle();
        Assert.assertEquals(title, "Learn and Practice Automation | automateNow");
    }

    @Test
    public void testNumberOfButtons(){
        List<WebElement> buttonElements = landingPage.getButtonElements();
        Assert.assertEquals(buttonElements.size(), numberOfButtons, "The number of buttons on the landing page is incorrect");
    }

    @Test
    public void testHeadingText(){
        String headingText = landingPage.getHeadingTitle();
        Assert.assertEquals(headingText, "Welcome to your software automation practice website!");
    }

}
