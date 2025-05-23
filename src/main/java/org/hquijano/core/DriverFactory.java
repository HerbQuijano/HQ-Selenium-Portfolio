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

package org.hquijano.core;

import org.hquijano.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    // Setting up variable for Singleton pattern
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //private static final String browser = ConfigReader.getBrowser();
    private static final String browser = System.getProperty("browser");
    private static final boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless"));
    private static final boolean isRemote = Boolean.parseBoolean(System.getProperty("remote"));

    // Setting up private constructor to implement Singleton pattern
    private DriverFactory(){
        // Singleton Magic!!
    }

    // The following methods are to create the WebDriver
    public static WebDriver getDriver(){
        if (driver.get() == null){
            driver.set(createDriver());
        }
        return driver.get();
    }

    // And quit the WebDriver
    public static void quitDriver(){
        if (driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }

    public static WebDriver createDriver() {
        switch(browser.toLowerCase()) {
            case "chrome":
                return isRemote ? createRemoteChromeDriver() : createChromeDriver();
            case "firefox":
                return isRemote ? createRemoteFirefoxDriver() : createFirefoxDriver();
            case "edge":
                return isRemote ? createRemoteEdgeDriver() : createEdgeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public static WebDriver createChromeDriver() {
         ChromeOptions options = new ChromeOptions();
         if (isHeadless) {
             options.addArguments("--headless=new");
         }

         return new ChromeDriver(options);
    }

    public static RemoteWebDriver createRemoteChromeDriver() {
        ChromeOptions options = new ChromeOptions();

        // Generate a unique temp profile directory for each run
        String userDataDir = System.getProperty("java.io.tmpdir") + "/chrome-profile-" + System.nanoTime();

        options.addArguments("--user-data-dir=" + userDataDir);

        if (isHeadless) {
            options.addArguments("--headless=new");
        }

        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            //return new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options);

        }
        catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL for Selenium Grid", e);
        }
    }

    public static WebDriver createFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        if (isHeadless){
            options.addArguments("-headless");
        }
        return new FirefoxDriver(options);
    }

    private static WebDriver createRemoteFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        if (isHeadless) {
            options.addArguments("-headless");
        }

        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            //return new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options);

        }
        catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL for Selenium Grid", e);
        }
    }

    private static WebDriver createEdgeDriver(){
        EdgeOptions options = new EdgeOptions();
        if (isHeadless){
            options.addArguments("--headless=new");
        }
        return new EdgeDriver(options);
    }

    private static WebDriver createRemoteEdgeDriver(){
        EdgeOptions options = new EdgeOptions();

        if (isHeadless) {
            options.addArguments("-headless=new");
            options.addArguments("--disable-gpu");
        }

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");

        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            //return new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options);
        }
        catch (MalformedURLException e){
            throw new RuntimeException("Invalid URL for Selenium Grid", e);
        }

    }
}
