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

package org.hquijano.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public BasePage waitUntilElementByXpathIsVisible(String locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return this;
    }

    public BasePage waitUntilElementByLinkTextIsVisible(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(text)));
        return this;
    }

    public BasePage waitUntilElementByClassNameIsVisible(String className){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
        return this;
    }

    public BasePage waitUntilElementByIdIsVisible(String id){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))); // Wait for element by ID
        return this;
    }

    public BasePage waitUntilElementByCssSelectorIsVisible(String cssSelector){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector))); // Wait for element by CSS selector
        return this;
    }

    public BasePage waitUntilElementIsVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)); // Wait for element to be visible
        return this;
    }

    public void waitUntilAlertIsPresent(){
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public BasePage clickOnElement(WebElement element){
        element.click();
        return this;
    }

    public BasePage inputText(WebElement element, String text){
        element.sendKeys(text);
        return this;
    }

    public String getElementText(WebElement element){
        return element.getText(); // Use WebDriver to retrieve text from the element
    }

    public BasePage clickJavaScriptExecutor(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element); // Use JavaScriptExecutor to click
        return this;
    }

    public BasePage selectByVisibleText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
        return this;
    }

    public BasePage selectByIndex(WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index); // Use Select to select by index
        return this;
    }

    public BasePage clickCheckBoxByIndex(WebElement checkbox, int index){
        WebElement checkboxes = driver.findElements(By.cssSelector(checkbox.getAttribute("name"))).get(index);
        if (!checkboxes.isSelected()){
            checkboxes.click();
        }
        return this;
    }

    public BasePage clickCheckBoxByValue(WebElement checkbox, String value){
        WebElement checkboxes = driver.findElement(By.cssSelector("input[value='" + value + "']"));
        if (!checkboxes.isSelected()){
            checkboxes.click();
        }
        return this;
    }

    public BasePage moveToElement(WebElement element){
        actions.moveToElement(element).build().perform(); // Use Actions to move mouse to the element
        return this;
    }

    public BasePage scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public BasePage dismissPopupAlert(){
        driver.switchTo().alert().dismiss();
        return this;
    }

    public BasePage acceptPopupAlert(){
        driver.switchTo().alert().accept();
        return this;
    }

    public String getPopupText(){
        return driver.switchTo().alert().getText();
    }

}