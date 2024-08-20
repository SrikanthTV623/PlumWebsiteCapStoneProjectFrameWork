package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage{

    @FindBy(xpath = "//iframe[@id='gokwik-iframe']")
    WebElement iFrameID;

    @FindBy(xpath = "//input[@id='phone-input']")
    WebElement enterPhoneNoTxt;

    @FindBy(xpath = "//button[@class='add-new-add svelte-1d86hm6']/span")
    WebElement addNewAddress;

    @FindBy(xpath = "//input[@id='pincode-input']")
    WebElement pinCodeTxt;

    @FindBy(xpath = "//input[@id='full-name']")
    WebElement fullNameTxt;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailTxt;

    @FindBy(xpath = "//input[@id='address']")
    WebElement addressTxt;

    @FindBy(xpath = "//button[@id='continue-button']")
    WebElement continueBtn;

    @FindBy(xpath = "//div[@class='payment-btn-group svelte-hzxz3n']/button[1]")
    WebElement paymentOption;

    public void enterPhoneNo(){
        driver.switchTo().frame(iFrameID);
        scrollToElement(enterPhoneNoTxt);
        enterPhoneNoTxt.sendKeys(ConfigReader.getConfigValue("valid.phoneNo"));
    }

    public void enterRequiredDetails(){
        driver.switchTo().frame(iFrameID);
        scrollToElement(enterPhoneNoTxt);
        enterPhoneNoTxt.sendKeys(ConfigReader.getConfigValue("valid.phoneNo"));
        //addNewAddress.click();
        pinCodeTxt.sendKeys(ConfigReader.getConfigValue("pin.code"));
        fullNameTxt.sendKeys(ConfigReader.getConfigValue("full.name"));
        emailTxt.sendKeys(ConfigReader.getConfigValue("email.id"));
        addressTxt.sendKeys(ConfigReader.getConfigValue("full.address"));
        continueBtn.click();
    }

    public boolean isPaymentOptionDisplayed(){
        scrollToElement(paymentOption);
        return paymentOption.isDisplayed();
    }

    public void scrollToElement(WebElement element) {
        // Use JavaScript to scroll to the element if it's not in view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
