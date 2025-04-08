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

    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    public void waitUntilElementByXpathIsVisible(String locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitUntilElementByLinkTextIsVisible(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(text)));
    }

    public void waitUntilElementByClassNameIsVisible(String className){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    public void waitUntilElementByIdIsVisible(String id){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))); // Wait for element by ID
    }

    public void waitUntilElementByCssSelectorIsVisible(String cssSelector){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector))); // Wait for element by CSS selector
    }

    public void waitUntilElementIsVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)); // Wait for element to be visible
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public void inputText(WebElement element, String text){
        element.sendKeys(text);
    }

    public String getElementText(WebElement element){
        return element.getText(); // Use WebDriver to retrieve text from the element
    }

    public void clickJavaScriptExecutor(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element); // Use JavaScriptExecutor to click
    }

    public void selectByVisibleText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByIndex(WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index); // Use Select to select by index
    }

    public void clickCheckBoxByIndex(WebElement checkbox, int index){
        WebElement checkboxes = driver.findElements(By.cssSelector(checkbox.getAttribute("name"))).get(index);
        if (!checkboxes.isSelected()){
            checkboxes.click();
        }

    }

    public void clickCheckBoxByValue(WebElement checkbox, String value){
        WebElement checkboxes = driver.findElement(By.cssSelector("input[value='" + value + "']"));
        if (!checkboxes.isSelected()){
            checkboxes.click();
        }
    }

    public void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform(); // Use Actions to move mouse to the element
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}