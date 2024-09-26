package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ExtentReportManager {

    static ExtentReports reports;
    static ExtentTest test;
    private static int i;
    private static String category;

    public static void initReporter() {
        String path = "";
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            path = System.getProperty("user.dir") + "\\ExtentReports\\WebExtentReport.html";
            category = "@web";
        } else {
            path = System.getProperty("user.dir") + "\\ExtentReports\\AndroidExtentReport.html";
            category = "@mobile";
        }
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("Plum Goodness Automation");
        reports = new ExtentReports();
        reports.setSystemInfo("OS", "Windows10");
        reports.setSystemInfo("Browser", "Chrome");
        reports.attachReporter(reporter);
    }

    public static void flush() {
        reports.flush();
    }

    public static void createTest(String name) {
        test = reports.createTest(name);
        test.assignCategory(category);
        test.assignAuthor("T V Srikanth", "Savita R K");
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void attachScreenshot() {
        test.addScreenCaptureFromPath(takeScreenshot());
    }

    public static String takeScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File file = ts.getScreenshotAs(OutputType.FILE);
        if(System.getProperty("env").equals("mobile")) {
            String path = "src\\test\\resources\\screenshots\\mobile\\screenshot" + ++i + ".png";
            try {
                FileUtils.copyFile(file, new File(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return System.getProperty("user.dir") + "\\" + path;
        }else{
            String path = "src\\test\\resources\\screenshots\\screenshotOfWeb" + ++i + ".png";
            try {
                FileUtils.copyFile(file, new File(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return System.getProperty("user.dir") + "\\" + path;
        }
    }
}
