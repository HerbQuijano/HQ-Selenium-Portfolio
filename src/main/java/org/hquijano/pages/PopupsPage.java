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
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PopupsPage extends BasePage {

    public PopupsPage(WebDriver driver){
        super(driver);
    }

    // Element Locators
    @FindBy(id = "alert")
    private WebElement alertPopupButton;

    @FindBy(id = "confirm")
    private WebElement confirmPopupButton;

    @FindBy(id = "prompt")
    private WebElement promptPopupButton;

    @FindBy(css = ".tooltip_1")
    private WebElement tooltipDisplayLink;

    @FindBy(css = ".tooltip_text.show")
    private WebElement tooltipElement;

    @FindBy(id = "confirmResult")
    private WebElement confirmResultText;

    @FindBy(id = "promptResult")
    private WebElement promptResultText;

    // Action Methods

    public PopupsPage clickAlertPopupButton() {
        clickOnElement(alertPopupButton);
        return this;
    }

    public PopupsPage clickConfirmPopupButton() {
        clickOnElement(confirmPopupButton);
        return this;
    }

    public PopupsPage clickPromptPopupButton() {
        clickOnElement(promptPopupButton);
        return this;
    }

    public PopupsPage clickTooltipDisplayLink() {
        clickOnElement(tooltipDisplayLink);
        return this;
    }

    public String getTooltipText() {
        return getElementText(tooltipElement);
    }

    public boolean validateAlertIsClosed(){
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String getConfirmResultText(){
        return confirmResultText.getText();
    }

    public void typeAlertInput(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public String getPromptResultText() {
        return promptResultText.getText();
    }
}
