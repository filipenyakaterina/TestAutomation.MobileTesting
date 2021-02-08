package mobile.testing.utils;

import mobile.testing.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static java.lang.String.format;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        TestLogger.writeInfoMessage("{} started", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        TestLogger.writeInfoMessage("{} passed", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TestLogger.writeInfoMessage("{} failed", result.getName());
        takeScreenshot();
    }

    private void takeScreenshot() {
        File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(format(".//target/screenshots/%s.png", LocalDate.now())));
        } catch (IOException e) {
            TestLogger.writeErrorMessage("Failure to save screenshot: {}", e.getMessage());
        }
    }
}
