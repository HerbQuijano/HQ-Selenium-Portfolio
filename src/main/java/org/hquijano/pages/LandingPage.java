package org.hquijano.pages;

// Import statements
import org.hquijano.base.BasePage;
import org.hquijano.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage extends BasePage {
    private final String url = ConfigReader.getBaseUrl();

    public LandingPage(WebDriver driver) {
        super(driver); // Call to the parent class constructor
    }

    // Locators

    @FindBy(css = ".wp-element-button")
    List<WebElement> buttonElements; // List of button elements

    @FindBy(css = "h1[class='wp-block-heading'] strong")
    private WebElement headingTitle; // Heading title element

    @FindBy(linkText = "JavaScript Delays")
    private WebElement jsDelaysLink; // Link to JavaScript Delays page

    @FindBy(linkText = "Form Fields")
    private WebElement formFieldsLink; // Link to Form Fields page

    @FindBy(linkText = "Popups")
    private WebElement popupsLink; // Link to Popups page

    @FindBy(linkText = "Sliders")
    private WebElement slidersLink; // Link to Sliders page

    @FindBy(linkText = "Calendar")
    private WebElement calendarLink; // Link to Calendar page

    @FindBy(linkText = "Modals")
    private WebElement modalsLink; // Link to Modals page

    @FindBy(linkText = "Tables")
    private WebElement tablesLink; // Link to Tables page

    @FindBy(linkText = "Window Operations")
    private WebElement windowOperationsLink; // Link to Window Operations page

    @FindBy(linkText = "Hover")
    private WebElement hoverLink; // Link to Hover page

    @FindBy(linkText = "Ads")
    private WebElement adsLink; // Link to Ads page

    @FindBy(linkText = "Gestures")
    private WebElement gesturesLink; // Link to Gestures page

    @FindBy(linkText = "File Download")
    private WebElement fileDownloadLink; // Link to File Download page

    @FindBy(linkText = "Click Events")
    private WebElement clickEventsLink; // Link to Click Events page

    @FindBy(linkText = "Spinners")
    private WebElement spinnersLink; // Link to Spinners page

    @FindBy(linkText = "File Upload")
    private WebElement fileUploadLink; // Link to File Upload page

    @FindBy(linkText = "Iframes")
    private WebElement iframesLink; // Link to Iframes page

    @FindBy(linkText = "Broken Images")
    private WebElement brokenImagesLink; // Link to Broken Images page

    @FindBy(linkText = "Broken Links")
    private WebElement brokenLinksLink; // Link to Broken Links page

    @FindBy(linkText = "Accordions")
    private WebElement accordionsLink; // Link to Accordions page

    // Actions

    public LandingPage navigateTo() {
        driver.get(url); // Navigate to the base URL
        return this;
    }

    public JSDelaysPage clickOnJSDelaysLink() {
        jsDelaysLink.click(); // Click on the JavaScript Delays link
        return new JSDelaysPage(driver);
    }

    public FormFieldsPage clickOnFormFieldsLink() {
        formFieldsLink.click(); // Click on the Form Fields link
        return new FormFieldsPage(driver);
    }

    public PopupsPage clickOnPopupsLink() {
        popupsLink.click();
        return new PopupsPage(driver);// Click on the Popups link
    }

    public void clickOnSlidersLink() {
        slidersLink.click(); // Click on the Sliders link
    }

    public void clickOnCalendarLink() {
        calendarLink.click(); // Click on the Calendar link
    }

    public void clickOnModalsLink() {
        modalsLink.click(); // Click on the Modals link
    }

    public void clickOnTablesLink() {
        tablesLink.click(); // Click on the Tables link
    }

    public void clickOnWindowOperationsLink() {
        windowOperationsLink.click(); // Click on the Window Operations link
    }

    public void clickOnHoverLink() {
        hoverLink.click(); // Click on the Hover link
    }

    public void clickOnAdsLink() {
        adsLink.click(); // Click on the Ads link
    }

    public void clickOnGesturesLink() {
        gesturesLink.click(); // Click on the Gestures link
    }

    public void clickOnFileDownloadLink() {
        fileDownloadLink.click(); // Click on the File Download link
    }

    public void clickOnClickEventsLink() {
        clickEventsLink.click(); // Click on the Click Events link
    }

    public void clickOnSpinnersLink() {
        spinnersLink.click(); // Click on the Spinners link
    }

    public void clickOnFileUploadLink() {
        fileUploadLink.click(); // Click on the File Upload link
    }

    public void clickOnIframesLink() {
        iframesLink.click(); // Click on the Iframes link
    }

    public void clickOnBrokenImagesLink() {
        brokenImagesLink.click(); // Click on the Broken Images link
    }

    public void clickOnBrokenLinksLink() {
        brokenLinksLink.click(); // Click on the Broken Links link
    }

    public void clickOnAccordionsLink() {
        accordionsLink.click(); // Click on the Accordions link
    }

    // Getters

    public String getHeadingTitle() {
        return headingTitle.getText();
    }

    public List<WebElement> getButtonElements() {
        return buttonElements; // Return the list of button elements
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getPageURL() {
        return driver.getCurrentUrl();
    }
}
