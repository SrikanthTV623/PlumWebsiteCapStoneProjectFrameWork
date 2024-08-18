package com.automation.pages;

import org.openqa.selenium.By;
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
        addToCartBtn.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='product-title h5']"))); // Any condition that is always true
        //WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
    }

    public boolean itemDescriptionPageDisplayed(){
        return itemDescriptionTxt.isDisplayed() && addToCartBtn.isDisplayed();
    }
}
