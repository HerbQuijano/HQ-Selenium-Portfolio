package org.hquijano.Tests;

import org.hquijano.core.DriverFactory;
import org.hquijano.pages.FormFieldsPage;
import org.hquijano.pages.JSDelaysPage;
import org.hquijano.pages.LandingPage;
import org.hquijano.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    public LandingPage landingPage;
    public JSDelaysPage jsDelaysPage;
    public FormFieldsPage formFieldsPage;

    @BeforeMethod(alwaysRun = true)
    public void launch() {
        driver.get(ConfigReader.getBaseUrl());
        landingPage = new LandingPage(driver);
        jsDelaysPage = new JSDelaysPage(driver);
        formFieldsPage = new FormFieldsPage(driver);
    }

    @BeforeClass(alwaysRun = true)
    public void setup(){
        driver = new DriverFactory().createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getImplicitWaitTime())));
    }


    @AfterClass(alwaysRun = true)
    public void teardown(){
        if (driver != null){
            driver.quit();
        }
        driver = null;
    }
}