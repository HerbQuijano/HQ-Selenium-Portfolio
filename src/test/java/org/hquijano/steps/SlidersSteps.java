package org.hquijano.steps;

import io.cucumber.java.en.*;
import org.hquijano.pages.LandingPage;
import org.hquijano.pages.SlidersPage;
import org.hquijano.core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SlidersSteps {

    WebDriver driver = DriverFactory.getDriver();
    LandingPage landingPage = new LandingPage(driver);
    SlidersPage slidersPage;

    @Given("I am on the sliders page")
    public void i_am_on_the_sliders_page() {
        slidersPage = landingPage.navigateTo().clickOnSlidersLink();
        System.out.println("Initial: " + slidersPage.getSliderValue());
    }

    @When("I set the slider to {int} percent")
    public void i_set_the_slider_to_percent(int target) {
        slidersPage.setSliderToPercentage(0);
        slidersPage.setSliderToPercentage(target);
        System.out.println("Final: " + slidersPage.getSliderValue());
    }

    @Then("the slider value should be {string}")
    public void the_slider_value_should_be(String expected) {
        Assert.assertEquals(slidersPage.getSliderValue(), expected);
    }
}
