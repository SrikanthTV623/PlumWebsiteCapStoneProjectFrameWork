package com.automation.pages.mobile;

import com.automation.pages.ui.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileHomePage extends MobileBasePage implements HomePage {

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
    WebElement allowNotificationPopUp;

    @FindBy(xpath = "//android.view.View[@content-desc='skip']")
    WebElement skipButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
    WebElement plumLogo;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='search ']")
    WebElement searchBoxField;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement searchBoxTxt;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='my profile']")
    WebElement profileLoginOptionBeforeLogin;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'trending at plum')]")
    WebElement trendingAtPlumForScroll;


    @Override
    public void openWebsite() {
        clickOnElementIfPresent(allowNotificationPopUp);
        clickOnElementIfPresent(skipButton);
    }

    @Override
    public boolean verifyHomePage() {
        return plumLogo.isDisplayed() && searchBoxField.isDisplayed();
    }

    @Override
    public void clickOnLoginButton() {

    }

    @Override
    public void clickOnLoginLogoBtn() {
        profileLoginOptionBeforeLogin.click();
    }

    @Override
    public void enterValueOnSearchBar(String searchValue) {
        searchBoxField.click();
        searchBoxTxt.click();
        searchBoxTxt.sendKeys(searchValue);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void selectProductCategory(String productCategory) {
        String productCategoryXpath="//android.view.View[@content-desc='%s']";
        WebElement product=driver.findElement(By.xpath(String.format(productCategoryXpath,productCategory)));
        product.click();
    }

     @FindBy(xpath = "//android.widget.HorizontalScrollView")
      WebElement bestOfFragrances;
    @Override
    public void selectProductFromDropDown(String productType) {
        String productCategoryXpath = "";
        if(productType.equals("orchid-you-not")){
            performScrollTillElementVisible(bestOfFragrances);
            productCategoryXpath = "//android.view.View[@content-desc='%s']";
        }else {
            performScrollTillElementVisible(trendingAtPlumForScroll);
            productCategoryXpath = "//android.widget.ImageView[@content-desc='experience the joy of']//following-sibling::android.view.View//android.view.View[@content-desc='%s']";
        }
        WebElement productCategory=driver.findElement(By.xpath(String.format(productCategoryXpath,productType)));
        productCategory.click();
    }

    @Override
    public void selectSpecifiedProductFromDropDown(String specifiedProductType) {

    }

    @Override
    public void gettingSearchValueFromTextFile() {

    }

    @Override
    public void validateSearchResultsForSearchedItem() {

    }

    @Override
    public void clickOnOrderHistory() {

    }
}
