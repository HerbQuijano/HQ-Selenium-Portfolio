package org.hquijano.Tests;

import org.hquijano.pages.JSDelaysPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSDelaysPageTest extends BaseTest {
    private JSDelaysPage jsDelaysPage;

    @BeforeMethod
    public void navigateToJSDelaysPage() {
        landingPage.clickOnJSDelaysLink();
        jsDelaysPage = new JSDelaysPage(driver);
    }

    @Test
    public void testCountdownEnds() {
        jsDelaysPage.clickStartButton();
        String liftoffMessage = jsDelaysPage.waitForLiftoff();
        Assert.assertEquals(liftoffMessage, "Liftoff!");
    }

    @Test
    public void testRocketIsNotLaunchedAtPageLoad(){
        Assert.assertTrue(jsDelaysPage.isRocketNotLaunched());
    }

    @Test
    public void testRocketLaunchedAfterClick(){
        jsDelaysPage.clickStartButton();
        String liftoffMessage = jsDelaysPage.waitForLiftoff();
        Assert.assertTrue(jsDelaysPage.isRocketLaunched());
    }

}
