package org.hquijano.utilities;

import org.hquijano.core.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String captureScreenshot(String testName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            // Format: yyyy-MM-dd_HH-mm-ss
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

            String dirPath = "test-output/screenshots/";
            String fileName = testName + "_" + timestamp + ".png";
            String fullPath = dirPath + fileName;

            Files.createDirectories(Paths.get(dirPath));
            Files.write(Paths.get(fullPath), screenshot);

            // Return relative path for ExtentReports
            return "screenshots/" + fileName;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
