package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@id=\"phone-input\"]")
    WebElement mobileNumberField;

    public boolean verifyLoginPage() {
        return mobileNumberField.isDisplayed();
    }

    public void enterMobileNumber(String phoneNoVal) {
        mobileNumberField.sendKeys(phoneNoVal);
    }
}
