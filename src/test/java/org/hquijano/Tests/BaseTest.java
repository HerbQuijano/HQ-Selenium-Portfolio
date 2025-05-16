package org.hquijano.Tests;

import org.hquijano.core.DriverFactory;
import org.hquijano.pages.FormFieldsPage;
import org.hquijano.pages.JSDelaysPage;
import org.hquijano.pages.LandingPage;
import org.hquijano.pages.PopupsPage;
import org.hquijano.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.sql.Driver;
import java.time.Duration;

public class BaseTest {
    public LandingPage landingPage;
    public JSDelaysPage jsDelaysPage;
    public FormFieldsPage formFieldsPage;
    public PopupsPage popupsPage;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        // Getting driver instance from ThreadLocal DriverFactory
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getImplicitWaitTime())));

        landingPage = new LandingPage(DriverFactory.getDriver());
        jsDelaysPage = new JSDelaysPage(DriverFactory.getDriver());
        formFieldsPage = new FormFieldsPage(DriverFactory.getDriver());
        popupsPage = new PopupsPage(DriverFactory.getDriver());
    }


    @AfterMethod(alwaysRun = true)
    public void teardown(){
        // Quitting driver instance from ThreadLocal DriverFactory
        DriverFactory.quitDriver();
    }
}