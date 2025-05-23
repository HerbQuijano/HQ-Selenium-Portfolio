package org.hquijano.pages;

import org.hquijano.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SlidersPage extends BasePage {

    public SlidersPage(WebDriver driver) {
        super(driver);
    }

    // Web elements for sliders
    @FindBy(css = "#slideMe")
    WebElement sliderElement;

    @FindBy(id = "value")
    WebElement sliderValueElement;

    // Action methods for sliders
    public int getSliderWidth() {
        return sliderElement.getSize().getWidth();
    }

    public int calculateSliderMiddlePoint(){
        int width = getSliderWidth();
        return width / 2;
    }

    public String getSliderValue(){
        return sliderValueElement.getText();
    }

    public SlidersPage setSliderToPercentage(int percentage){
        int width = getSliderWidth();

        // Calculate the percentage to move the slider using the calculated pixel offset
        int xOffset = (percentage * width) / 100;

        //System.out.println("Slider width: " + width);
        //System.out.println("Slider halfwidth: " + -width / 2);

        // Click and hold the slider at the center, then move to the left edge, then move to the desired percentage
        actions.clickAndHold(sliderElement)
                .moveByOffset(-width / 2, 0)
                //.moveByOffset(xOffset - 1, 0) // Cucumber adds an extra pixel to avoid a glitch when releasing the mouse button
                .moveByOffset(xOffset, 0)
                .perform();

        return this;
    }

    public void setSliderToPercentageJS(int percentage){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));", sliderElement, percentage);
    }

    public SlidersPage resetToDefaultValue(){
        setSliderToPercentage(0); // Reset to 50%
        return this;
    }

}
