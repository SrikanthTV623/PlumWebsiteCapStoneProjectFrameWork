package com.automation.pages.mobile;

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

    MobileBasePage() {
        driver = DriverManager.getDriver();
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

    public double extractPriceFromProductDescription(String text) {
        // Example description: "Green Tea Day-Light Sunscreen Gel SPF 35 PA+++ \n₹474.00 \n₹575.00 \n you save ₹101.00"
        Pattern pattern = Pattern.compile("₹([0-9,.]+)");
        Matcher matcher = pattern.matcher(text);

        double price = 0.0;
        if (matcher.find()) {
            price = Double.parseDouble(matcher.group(1).replace(",", ""));
        }
        System.out.println("Extracted Price From Product Description: " + price);
        return price;
    }

    public double extractSecondPriceFromProductDescription(String text) {
        // Example description: "Vanilla Vibes Body Oil by Plum BodyLovin\n₹443\nwith\n₹467\n₹550\n(15% off)"
        Pattern pattern = Pattern.compile("₹([0-9,.]+)");
        Matcher matcher = pattern.matcher(text);

        double secondPrice = 0.0;
        int priceCount = 0;

        while (matcher.find()) {
            priceCount++;
            // Check if this is the second price
            if (priceCount == 2) {
                secondPrice = Double.parseDouble(matcher.group(1).replace(",", ""));
                break; // Exit the loop after finding the second price
            }
        }

        System.out.println("Extracted Second Price From Product Description: " + secondPrice);
        return secondPrice;
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

    public void tapOnElementByXPath(WebElement element) {
        Dimension dimension = driver.manage().window().getSize();
        int pageX = element.getLocation().getX();
        int pagey = element.getLocation().getY();
        int eleHeight = element.getSize().getHeight();
        int eleWidth = element.getSize().getWidth();

        int x = pageX + 5;
        int y = pagey + eleHeight;

        //System.out.println(x + " " + y);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

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
