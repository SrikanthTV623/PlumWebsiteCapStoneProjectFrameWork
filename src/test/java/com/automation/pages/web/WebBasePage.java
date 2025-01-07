package com.automation.pages.web;

import com.automation.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebBasePage {

    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    public WebBasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean isPresent(WebElement element) {
        try {
            setImplicitWait(5);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(30);
        }
    }

    public void setImplicitWait(long sec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }

    public void clickOnElementIfPresent(WebElement element) {
        if (isPresent(element)) {
            element.click();
        }
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(WebElement element) {
        // Use JavaScript to scroll to the element if it's not in view
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToBottomOfPage() {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void jsClick(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollToSpecificAmount(){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 350);");
    }
}
