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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FormFieldsPage extends BasePage {
    private int numberOfRequiredElements = 1;
    private final List<String> favoriteDrinks = List.of("Coke", "Pepsi", "Sprite", "Water", "Fanta");
    private final List<String> favoriteColors = List.of("Red", "Blue", "Yellow", "Green", "Purple");
    private final List<String> automationTools = List.of("Selenium", "Playwright", "Cypress", "Appium", "Katalon Studio");


    public FormFieldsPage(WebDriver driver){
        super(driver);
    }

    // Element Locators
    @FindBy(css = "h1[itemprop='headline']")
    private WebElement formTitle;

    @FindBy(id = "name-input")
    private WebElement nameInput;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "input[type='checkbox']")
    private List<WebElement> drinksCheckboxes;

    @FindBy(xpath = "//form//label[contains(@for,'drink')]")
    private List<WebElement> drinkLabels;

    @FindBy(css = "input[type='radio']")
    private List<WebElement> colorsRadios;

    @FindBy(id = "automation")
    private WebElement automationDropdown;

    @FindBy(css = "#feedbackForm ul li")
    private List<WebElement> automationToolsList;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "message")
    private WebElement messageInput;

    @FindBy(css = "#submit-btn")
    private WebElement submitButton;

    @FindBy(css = ".red_txt")
    private List<WebElement> requiredElements;

    // Action Methods

    public String getFormTitleText(){
        System.out.println(formTitle.getText());
        return formTitle.getText();
    }

    public boolean isCountOfRequiredElementsCorrect(){
        return requiredElements.size() == numberOfRequiredElements;
    }

    public FormFieldsPage validateListedDrinks(){
        boolean allMatch = drinkLabels.stream()
                .map(label -> label.getText().trim())
                .allMatch(favoriteDrinks::contains);

        if (!allMatch) {
            throw new AssertionError("Some drink labels are not in the favoriteDrinks list.");
        }
        return this;
    }

    public FormFieldsPage clickOnSubmitButton() {
        submitButton.click();
        return this;
    }

    public boolean isNameElementFocused() throws InterruptedException {
        scrollToElement(submitButton);
        Thread.sleep(3000);
        waitUntilElementIsVisible(submitButton);
        clickOnSubmitButton();
        scrollToElement(nameInput);
        waitUntilElementIsVisible(nameInput);
        return nameInput.equals(driver.switchTo().activeElement());
    }

}
