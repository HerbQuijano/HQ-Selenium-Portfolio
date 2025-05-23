package org.hquijano.tests;

import org.hquijano.listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//@Listeners(TestListener.class)
public class SlidersPageTest extends BaseTest {
    private final int target = 72;
    private SoftAssert softAsserts;

    @Test(groups = {"smoke"})
    public void testSetByOffset() {
        landingPage.navigateTo().clickOnSlidersLink();
        System.out.println("Initial: " + slidersPage.getSliderValue());
        //slidersPage.setSliderToPercentage(target);
        slidersPage.setSliderToPercentageJS(target);
        System.out.println("Final: " + slidersPage.getSliderValue());
        Assert.assertEquals(slidersPage.getSliderValue(), String.valueOf(target));
    }

    @Test
    public void navigateToSlidersPage(){
        landingPage.navigateTo().clickOnSlidersLink();
    }

    @Test
    public void testResetToDefaultValue() {
        landingPage.navigateTo().clickOnSlidersLink();
        System.out.println("Initial: " + slidersPage.getSliderValue());
        slidersPage.resetToDefaultValue();
        System.out.println("Final: " + slidersPage.getSliderValue());
        Assert.assertEquals(slidersPage.getSliderValue(), "0");
    }

}
