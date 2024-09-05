package com.automation.pages.mobile;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileBasePage {

    WebDriver driver;
    WebDriverWait wait;

    String envType = ConfigReader.getConfigValue("application.type");

    MobileBasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElementIfPresent(WebElement element) {
        if (isPresent(element)) {
            element.click();
        }
    }

    public String getContentDescriptionOfAnElement(WebElement element) {
        // Ensure the element is displayed and enabled before getting the attribute
        if (element.isDisplayed() && element.isEnabled()) {
            String contentDesc = element.getAttribute("content-desc");
            System.out.println("Content-desc: " + contentDesc);
            return contentDesc;
        } else {
            throw new RuntimeException("Element is not displayed or enabled.");
        }
    }

    public double calculateTotalPriceFromProductList(List<WebElement> elements) {
        double total = 0.0;

        List<WebElement> xPath = elements;

        for (WebElement description : xPath) {
            String text = getContentDescriptionOfAnElement(description);
            double price = extractPriceFromProductDescription(text);
            total += price;
        }

        return total;
    }

    private double extractPriceFromProductDescription(String text) {
        // Example description: "Green Tea Day-Light Sunscreen Gel SPF 35 PA+++ \n₹474.00 \n₹575.00 \n you save ₹101.00"
        Pattern pattern = Pattern.compile("₹([0-9,.]+)");
        Matcher matcher = pattern.matcher(text);

        double price = 0.0;
        if (matcher.find()) {
            price = Double.parseDouble(matcher.group(1).replace(",", ""));
        }
        System.out.println("Extracted Price From Product Description: "+price);
        return price;
    }

    public double extractValueFromOrderSummaryText(String text, String label) {
        //Pattern pattern1 = Pattern.compile(label + "\\s*\\n(\\₹[0-9,.]+|Free)");
        Pattern pattern = Pattern.compile(Pattern.quote(label) + "\\s*\\n([-₹][0-9,.]+|₹[0-9,.]+|Free)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String valueText = matcher.group(1).replace("₹", "").replace(",", "").replace("-", "").trim();
            if (valueText.equalsIgnoreCase("Free")) {
                return 0.0;
            } else {
                return Double.parseDouble(valueText);
            }
        }
        throw new RuntimeException("Value for " + label + " not found in text");
    }

    public void scrollOrSwipe(int startX, int startY, int endX, int endY) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(2)))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AppiumDriver) driver).perform(Collections.singletonList(sequence));
    }

    public void performScrollToMoveFullPage() {
        // Scroll Logic
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        scrollOrSwipe(width / 2, height * 4 / 5, width / 2, height / 5);
    }

    public void performScrollToMovePage() {
        // Scroll Logic
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        scrollOrSwipe(width / 2, height / 2, width / 2, 0);
    }

    public void performScrollTillElementVisible(WebElement element) {
        // Scroll Logic
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresent(element)) {
            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
        }
    }
}
