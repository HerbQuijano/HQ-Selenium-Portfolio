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

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform(); // Use Actions to move mouse to the element
        return this;
    }

    public BasePage scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

}