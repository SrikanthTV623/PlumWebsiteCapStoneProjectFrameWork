package com.automation.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[@class='flex']/img")
    WebElement plumLogo;

    @FindBy(xpath = "//div[@id=\"kp-login-button-header-logo\"]")
    WebElement loginLogoBtn;

    @FindBy(xpath = "//div[@id='icon-kwikpass']")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@id='header-search']")
    WebElement searchBarField;

    @FindBy(xpath = "//div[@id='kwikpass-drawer-desktop']//a")
    WebElement orderHistory;


    @FindBy(xpath = "//li[3]//summary/a")
    WebElement hairTab;

    @FindBy(xpath = "//a[contains(@href,'hair-mask')]")
    WebElement hairMask;


    public void openWebsite() {
        driver.get("https://plumgoodness.com/");
    }

    public boolean verifyHomePage() {
        return plumLogo.isDisplayed();
    }

    public void clickOnLoginLogo() {
        loginLogoBtn.click();
    }


    public void enterValueOnSearchBar(String searchValue) {
        searchBarField.sendKeys(searchValue);
        searchBarField.sendKeys(Keys.ENTER);
    }

    public void selectProductCategory(String productCategory) {
        String categoryXpath = "//li//summary//a[contains(text(),'%s')]";
        driver.findElement(By.xpath(String.format(categoryXpath, productCategory))).click();
    }

    public void selectProductFromDropDown(String productType) {
        String categoryXpath = "//a[contains(@href,'%s')]";
        WebElement product = driver.findElement(By.xpath(String.format(categoryXpath, productType)));
        scrollToElement(product);
        product.click();
    }

    public void clickOnLoginButton() {
        driver.switchTo().defaultContent();
        jsClick(loginBtn);
    }

    public void clickOnOrderHistory() {
        jsClick(orderHistory);
    }



}
