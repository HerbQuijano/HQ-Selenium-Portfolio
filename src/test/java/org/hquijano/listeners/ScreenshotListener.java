package org.hquijano.listeners;

import org.apache.commons.io.FileUtils;
import org.hquijano.Tests.BaseTest;
import org.hquijano.core.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = DriverFactory.getDriver();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String methodName = result.getName(); // Failing test method name
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = "screenshots/" + methodName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(src, new File(filePath));
            System.out.println("Screenshot taken for failed test: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
