package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//iframe[@id='iframe-kp']")
    WebElement iframeId;

    @FindBy(xpath = "//input[@id='phone-input']")
    WebElement mobileNumberField;

    @FindBy(xpath = "//div[@id='login-success-wrapper']//div")
    WebElement welcomeMessage;

    public boolean verifyLoginPage() {
        driver.switchTo().frame(iframeId);
        return mobileNumberField.isDisplayed();
    }

    public void enterMobileNumber(String phoneNoVal) {
        mobileNumberField.sendKeys(phoneNoVal);
    }

    public boolean isLoggedInSuccessfully() {
        System.out.println(welcomeMessage.getText());
        return welcomeMessage.isDisplayed();
    }
}
