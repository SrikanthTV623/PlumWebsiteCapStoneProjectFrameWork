package com.automation.pages.mobile;

import com.automation.pages.ui.ProductPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

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

    @FindBy(xpath = "(//android.view.View[@content-desc='add to cart']/..)[1]")
    WebElement firstProduct;
    @Override
    public boolean verifyProductName(String productName) {
        System.out.println(getContentDescriptionOfAnElement(firstProduct));
        return getContentDescriptionOfAnElement(firstProduct).contains(productName);
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

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='FILTERS']")
    WebElement filterBtn;

    @Override
    public void clickOnFilter() {
        filterBtn.click();
    }


    @Override
    public void clickOnTypeOfFilter(String typeOfFilter) {
        String typeOfFilterXpath = "//android.view.View[@content-desc='%s']";
        WebElement typeOfFilterBtn = driver.findElement(By.xpath(String.format(typeOfFilterXpath, typeOfFilter)));
        typeOfFilterBtn.click();
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc='apply filter']")
    WebElement applyFilterBtn;

    @Override
    public void clickOnSubTypeOfFilter(String subTypeOfFilter) {
        //String subTypeOfFilterXpath = "//android.widget.CheckBox[contains(@content-desc,'%s and above')]";
        String subTypeOfFilterXpath = "//android.widget.CheckBox[contains(@content-desc,'3 and above')]";
       // WebElement subTypeOfFilterBtn = driver.findElement(By.xpath(String.format(subTypeOfFilterXpath, subTypeOfFilter)));
        WebElement subTypeOfFilterBtn = driver.findElement(By.xpath(subTypeOfFilterXpath));
        subTypeOfFilterBtn.click();
        applyFilterBtn.click();
    }

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'products')]")
    WebElement totalProducts;

    @Override
    public boolean verifyProductsSorted(String sortType) {
        String totalProductsTxt = getContentDescriptionOfAnElement(totalProducts);
        int totalProducts = Integer.parseInt(totalProductsTxt.split(" ")[0]);
//        System.out.println(totalProducts);
        int prodNo=1;
        for (int i = 0; i < totalProducts / 2; i++) {
            WebElement prod=driver.findElement(By.xpath(String.format("(//android.view.View[@content-desc='add to cart']/..)[%s]",prodNo)));
            if(prod.isDisplayed()){
                System.out.println(getContentDescriptionOfAnElement(prod));
                performScrollToMoveFullPage();
                prodNo=2;
            }
        }
        return false;
    }
}
