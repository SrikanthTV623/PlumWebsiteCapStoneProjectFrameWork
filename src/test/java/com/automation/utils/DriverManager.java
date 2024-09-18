package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.time.Duration;

public class DriverManager {

    static WebDriver driver;

    public static void createDriver() {

        if(System.getProperty("env").equals("mobile")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
            capabilities.setCapability("deviceName", ConfigReader.getConfigValue("device.name.srikanth.mobile"));
            //capabilities.setCapability("deviceName", ConfigReader.getConfigValue("device.name"));
            //capabilities.setCapability("deviceName", ConfigReader.getConfigValue("device.name.savita.mobile"));
            capabilities.setCapability("automationName", ConfigReader.getConfigValue("automation.name"));
            capabilities.setCapability("app", ConfigReader.getConfigValue("app.srikanth.path"));
            //capabilities.setCapability("app", ConfigReader.getConfigValue("app.savita.path"));
            capabilities.setCapability("appActivity", "com.esmagico.plum.MainActivity");
            capabilities.setCapability("appPackage", "com.esmagico.plum");
            capabilities.setCapability("autoGrantPermissions", true);
            driver = new AppiumDriver(capabilities);
        }
        else {
           // driver = new EdgeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
