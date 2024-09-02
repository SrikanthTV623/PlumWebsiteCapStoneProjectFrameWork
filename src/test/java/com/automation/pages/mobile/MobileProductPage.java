package com.automation.pages.mobile;

import com.automation.pages.ui.ProductPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileProductPage extends MobileBasePage implements ProductPage {

    //@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/(android.view.View)[1]")
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='FILTERS']/../android.view.View/android.view.View/android.view.View[1]")
    WebElement selectProductField;

    @FindBy(xpath = "//android.view.View[@content-desc=\"cart\"]/../android.widget.ImageView[1]")
    WebElement cartScreenToNavigatesBack;

    @FindBy(xpath = "(//android.view.View[@content-desc]/../../..//following-sibling::android.widget.ImageView)[1]")
    WebElement productDescScreenToNavigatesBack;

    @FindBy(xpath = "(//android.view.View[@content-desc]/../android.widget.ImageView)[1]")
    WebElement productScreenToNavigatesBack;

    @Override
    public void verifySearchedProductScreenIsDisplayedInApp(String productValue) {
        String searchedProductXpath = "//android.view.View[@content-desc='%s']";
        driver.findElement(By.xpath(String.format(searchedProductXpath, productValue))).isDisplayed();
    }

    @Override
    public void clicksOnItem() {
        selectProductField.click();
    }

    @Override
    public void navigatesForNextProductSearching() {
        cartScreenToNavigatesBack.click();
        productDescScreenToNavigatesBack.click();
        productScreenToNavigatesBack.click();
    }

    @Override
    public void clickOnShoppingCartIcon() {

    }

    @Override
    public boolean verifySelectedProductPage() {
        return false;
    }

    @Override
    public void clickOnSortBy() {

    }

    @Override
    public void sortBy(String sortByValue) {

    }

    @Override
    public boolean verifyProductsSortedATOZ() {
        return false;
    }

    @Override
    public boolean verifyProductsSortedZTOA() {
        return false;
    }

    @Override
    public boolean verifyProductsPricesSortedLowToHigh() {
        return false;
    }

    @Override
    public boolean verifyProductsPricesSortedHighToLow() {
        return false;
    }

    @Override
    public void printProductList() {

    }

    @Override
    public boolean verifyProductName(String productName) {
        return false;
    }

    @Override
    public void clickOnPriceFilter() {

    }

    @Override
    public void settingPriceRange(String fromPriceValue, String toPriceValue) {

    }

    @Override
    public boolean verifyProductsPricesSortedSpecifiedRange() {
        return false;
    }

    @Override
    public void getProductNameAndDescriptionText() {

    }

    @Override
    public String checkOutOfStockButton() {
        return "";
    }

    @Override
    public void printOutOfStockProductList() {

    }
}
