package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.ReportManager;
import io.cucumber.java.*;


public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        ConfigReader.initConfig();
        ReportManager.initReporter(scenario);
        ExtentReportManager.createTest(scenario.getName());
        DriverManager.createDriver();
    }

    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            ReportManager.attachScreenshot();
            ReportManager.log("Scenario Failed");
            ExtentReportManager.attachScreenshot();
            ExtentReportManager.getTest().fail("Test Failed : " + scenario.getName());
        } else {
            ReportManager.attachScreenshot();
            ReportManager.log("Scenario Passed");
            ExtentReportManager.attachScreenshot();
            ExtentReportManager.getTest().pass("Test Passed : " + scenario.getName());
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        DriverManager.getDriver().quit();
    }

    @BeforeAll
    public static void setUpAll() {
        ConfigReader.initConfig();
        ConfigReader.setConfigValue("application.type", System.getProperty("env"));
        ExtentReportManager.initReporter();
    }

    @AfterAll
    public static void cleanUpAll() {
        ExtentReportManager.flush();
    }
}


