package org.hquijano.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.hquijano.core.DriverFactory;
import org.hquijano.utilities.ExtentManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExtentTestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

        // Save screenshot to file and attach
        String screenshotPath = "screenshots/" + result.getMethod().getMethodName() + ".png";
        try {
            Files.createDirectories(Paths.get("test-output/screenshots/"));
            Files.write(Paths.get(screenshotPath), screenshot);
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
            test.get().warning("Failed to attach screenshot due to: " + e.getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
