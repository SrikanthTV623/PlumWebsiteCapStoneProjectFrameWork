package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemsDescriptionPage extends BasePage {

    @FindBy(xpath = "//h1[@class='product-title h5']")
    WebElement itemDescriptionTxt;

    @FindBy(xpath = "//button[@class='btn btn--secondary w-full']")
    WebElement addToCartBtn;

    public void clickOnAddToCartBtn(){
        scrollToElement(addToCartBtn);
        addToCartBtn.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean itemDescriptionPageDisplayed(){
        return itemDescriptionTxt.isDisplayed() && addToCartBtn.isDisplayed();
    }

    public void scrollToElement(WebElement element) {
        // Use JavaScript to scroll to the element if it's not in view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
