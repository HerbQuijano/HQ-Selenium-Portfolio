package org.hquijano.Tests;

import org.hquijano.listeners.ScreenshotListener;
import org.hquijano.pages.JSDelaysPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class JSDelaysPageTest extends BaseTest {

    @Test
    public void testCountdownEnds() {
        landingPage.navigateTo().clickOnJSDelaysLink();
        jsDelaysPage.clickStartButton();
        String liftoffMessage = jsDelaysPage.waitForLiftoff();
        Assert.assertEquals(liftoffMessage, "Liftoff!");
    }

    @Test
    public void testRocketIsNotLaunchedAtPageLoad(){
        landingPage.navigateTo().clickOnJSDelaysLink();
        Assert.assertTrue(jsDelaysPage.isRocketNotLaunched());
    }

    @Test
    public void testRocketLaunchedAfterClick(){
        landingPage.navigateTo().clickOnJSDelaysLink();
        jsDelaysPage.clickStartButton();
        String liftoffMessage = jsDelaysPage.waitForLiftoff();
        Assert.assertTrue(jsDelaysPage.isRocketLaunched());
    }

}
