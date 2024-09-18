package com.automation.pages.web;

import com.automation.pages.ui.CheckOutPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

public class WebCheckOutPage extends WebBasePage implements CheckOutPage {

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

    @FindBy(xpath = "//div[@class='payment-btn-group svelte-1yo52pf']/button[1]")
    WebElement paymentOption;

    @FindBy(xpath = "//div[@class='payment-btn-group svelte-1yo52pf']/button//span[contains(text(),'Cash on Delivery')]")
    WebElement cashOnDelivery;

    @FindBy(xpath = "//div[@class='os-header__heading']//span")
    WebElement orderIdAndText;

    @FindBy(xpath = "//div[@class='order-successful svelte-1ny41cs']//p")
    WebElement orderPlacedMsg;

    public void enterPhoneNo() {
        driver.switchTo().frame(iFrameID);
        scrollToElement(enterPhoneNoTxt);
        enterPhoneNoTxt.sendKeys(ConfigReader.getConfigValue("valid.phoneNo"));
    }

    public void enterRequiredDetails() {
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

    public boolean isPaymentOptionDisplayed() {
        scrollToElement(paymentOption);
        return paymentOption.isDisplayed();
    }


    public void selectCashOnDelivery() {
        scrollToElement(cashOnDelivery);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cashOnDelivery.click();
    }

    public boolean verifyOrderIsPlaced() {
        System.out.println(orderPlacedMsg.getText());
        return orderPlacedMsg.isDisplayed();

    }

    public void storeOrderId(String orderId) {
        driver.switchTo().defaultContent();
        String text = orderIdAndText.getText();
        String[] order = text.split("\\s+");
        ConfigReader.setConfigValue(orderId, order[1]);
        System.out.println(Arrays.toString(order));
    }

    @FindBy(xpath = "//a[@class='button-round']")
    WebElement navigateToHomePageBtn;

    public void navigateToHomePage() {
        scrollToElement(navigateToHomePageBtn);
        navigateToHomePageBtn.click();
    }
}
