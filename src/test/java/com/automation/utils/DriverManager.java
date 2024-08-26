package com.automation.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.time.Duration;

public class DriverManager {

    static WebDriver driver;

    public static void createDriver() {

        if(ConfigReader.getConfigValue("application.type").equals("mobile")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
            capabilities.setCapability("deviceName", ConfigReader.getConfigValue("device.name"));
            capabilities.setCapability("automationName", ConfigReader.getConfigValue("automation.name"));
            capabilities.setCapability("app", ConfigReader.getConfigValue("app.path"));
            capabilities.setCapability("appActivity", "com.esmagico.plum.MainActivity");
            capabilities.setCapability("appPackage", "com.esmagico.plum");
            driver = new AndroidDriver(capabilities);
        }
        else {
            //driver = new EdgeDriver();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
