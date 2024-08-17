package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//span[@class='flex']/img")
    WebElement plumLogo;
    @FindBy(id = "kp-login-button-header-logo")
    WebElement loginBtn;

    public void openWebsite() {

        driver.get("https://plumgoodness.com/");
    }

    public boolean verifyHomePage() {
        return plumLogo.isDisplayed();
    }

    public void clickOnLoginButton() {
        loginBtn.click();
    }
}
