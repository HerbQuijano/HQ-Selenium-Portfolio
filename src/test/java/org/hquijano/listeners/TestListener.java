package org.hquijano.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hquijano.core.DriverFactory;
import org.hquijano.utilities.ExtentManager;
import org.hquijano.utilities.ScreenshotUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("STARTING TEST: {}", result.getName());
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("✅ PASSED: {}", result.getName());
        test.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("❌ FAILED: {}", result.getName());
        logger.error("Cause: {}", String.valueOf(result.getThrowable()));
        test.get().fail(result.getThrowable());

        String relativePath = ScreenshotUtil.captureScreenshot(result.getMethod().getMethodName());
        test.get().addScreenCaptureFromPath(relativePath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("⏭\uFE0F SKIPPED: {}", result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
