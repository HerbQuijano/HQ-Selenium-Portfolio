/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hquijano.pages;

import org.hquijano.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class JSDelaysPage extends BasePage {
    private final String messageToBeDisplayed = "Liftoff!";

    public JSDelaysPage(WebDriver driver) {
        super(driver);
    }

    // Locators

    @FindBy(css = "h1[itemprop='headline']")
    private WebElement JSTitle;

    @FindBy(css = "#start")
    private WebElement startButton;

    @FindBy(css = "#delay")
    private WebElement countdownLocatorFindBy;

    By countDownLocatorBy = By.cssSelector("#delay");

    By rocketLocatorNotLaunchedBy = By.cssSelector(".wp-image-22714.sp-no-webp");

    By rocketLocatorLaunchedBy = By.cssSelector(".wp-image-22714.sp-no-webp.liftoff");

    // Action methods

    public JSDelaysPage clickStartButton() {
        startButton.click(); // Click on the start button
        return this;
    }

    public String getLoadingMessage() {
        return countdownLocatorFindBy.getText(); // Return the loading message text
    }

    public String waitForLiftoff() {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // Max wait time
                .pollingEvery(Duration.ofMillis(500)) // Poll every 500ms
                .ignoring(NoSuchElementException.class); // Ignore element not found errors

        // Use FluentWait to wait until the countdown element's text matches the expected message
        return fluentWait.until(driver -> {
            // Locate the countdown element using the specified locator
            WebElement countdownElement = driver.findElement(countDownLocatorBy);
            // Retrieve the text from the countdown element
            String value = countdownElement.getText();
            // Check if the retrieved text matches the expected message
            // If it matches, return the text; otherwise, return null to keep waiting
            return messageToBeDisplayed.equals(value) ? value : null;
        });
    }

    public boolean isRocketLaunched() {
        // Wait until the rocket image is visible and then check if it contains the "liftoff" class
        return driver.findElement(rocketLocatorLaunchedBy).isDisplayed();
    }

    public boolean isRocketNotLaunched() {
        // Wait until the rocket image is visible and then check if it contains the "liftoff" class
        return driver.findElement(rocketLocatorNotLaunchedBy).isDisplayed();
    }

}