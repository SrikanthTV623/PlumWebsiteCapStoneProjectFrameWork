package com.automation.pages.mobile;

import com.automation.pages.ui.HomePage;
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

    }

    @Override
    public void selectProductFromDropDown(String productType) {

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
