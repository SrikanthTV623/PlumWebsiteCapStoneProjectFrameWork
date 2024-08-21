package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[@class='flex']/img")
    WebElement plumLogo;

    @FindBy(id = "kp-login-button-header-logo")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@id='header-search']")
    WebElement searchBarField;


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

    public void clickOnLoginButton() {
        loginBtn.click();
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

    public void scrollToElement(WebElement element) {
        // Use JavaScript to scroll to the element if it's not in view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
