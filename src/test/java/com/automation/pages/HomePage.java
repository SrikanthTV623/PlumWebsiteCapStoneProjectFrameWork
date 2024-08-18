package com.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[@class='flex']/img")
    WebElement plumLogo;

    @FindBy(id = "kp-login-button-header-logo")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@id='header-search']")
    WebElement searchBarField;

    public void openWebsite() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver.get("https://plumgoodness.com/");
    }

    public boolean verifyHomePage() {
        return plumLogo.isDisplayed();
    }

    public void clickOnLoginButton() {
        loginBtn.click();
    }

    public void enterValueOnSearchBar(String searchValue) {
        searchBarField.sendKeys(searchValue);
        searchBarField.sendKeys(Keys.ENTER);
    }
}
