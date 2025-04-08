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
    private final String browser = ConfigReader.getBrowser();
    //private final String browser = System.getProperty("browser", "chrome");
    private final boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));
    private final boolean isRemote = Boolean.parseBoolean(System.getProperty("remote", "false"));


    public WebDriver createDriver() {
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

    public WebDriver createChromeDriver() {
         ChromeOptions options = new ChromeOptions();
         if (isHeadless) {
             options.addArguments("--headless=new");
         }

         return new ChromeDriver(options);
    }

    public RemoteWebDriver createRemoteChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {
            options.addArguments("--headless=new");
        }

        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }
        catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL for Selenium Grid", e);
        }
    }

    public WebDriver createFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        if (isHeadless){
            options.addArguments("-headless");
        }
        return new FirefoxDriver(options);
    }

    private WebDriver createRemoteFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        if (isHeadless) {
            options.addArguments("--headless");
        }

        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }
        catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL for Selenium Grid", e);
        }
    }

    private WebDriver createEdgeDriver(){
        EdgeOptions options = new EdgeOptions();
        if (isHeadless){
            options.addArguments("--headless=new");
        }
        return new EdgeDriver(options);
    }

    private WebDriver createRemoteEdgeDriver(){
        EdgeOptions options = new EdgeOptions();

        if (isHeadless){
            options.addArguments("-headless=new");
        }
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }
        catch (MalformedURLException e){
            throw new RuntimeException("Invalid URL for Selenium Grid", e);
        }

    }

}
