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

package org.hquijano.Tests;

import org.hquijano.core.DriverFactory;
import org.hquijano.pages.*;
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
    public SlidersPage slidersPage;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        // Getting driver instance from ThreadLocal DriverFactory
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getImplicitWaitTime())));

        landingPage = new LandingPage(DriverFactory.getDriver());
        jsDelaysPage = new JSDelaysPage(DriverFactory.getDriver());
        formFieldsPage = new FormFieldsPage(DriverFactory.getDriver());
        popupsPage = new PopupsPage(DriverFactory.getDriver());
        slidersPage = new SlidersPage(DriverFactory.getDriver());
    }


    @AfterMethod(alwaysRun = true)
    public void teardown(){
        // Quitting driver instance from ThreadLocal DriverFactory
        DriverFactory.quitDriver();
    }
}