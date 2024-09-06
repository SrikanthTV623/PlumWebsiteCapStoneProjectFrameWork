package com.automation.pages.mobile;

import com.automation.pages.ui.ProductPage;
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

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[4]")
    //@FindBy(xpath = "//android.widget.ImageView[@content-desc='1']")
    WebElement shoppingCartIcon;

    @FindBy(xpath = "(//android.view.View[@content-desc='add to cart']/..)[1]")
    WebElement firstProductInSearchedResults;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='FILTERS']")
    WebElement filterBtn;

    @Override
    public void verifySearchedProductScreenIsDisplayedInApp(String productValue) {
        String searchedProductXpath = "//android.view.View[@content-desc='%s']";
        driver.findElement(By.xpath(String.format(searchedProductXpath, productValue))).isDisplayed();
    }

    @Override
    public void clicksOnItem() {
        waitForElementToBeVisible(selectProductField);
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
        shoppingCartIcon.click();
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
    public boolean verifyProductName(String validatedProductName) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitForElementToBeVisible(firstProductInSearchedResults);
        //System.out.println(getContentDescriptionOfAnElement(firstProductInSearchedResults));
        return getContentDescriptionOfAnElement(firstProductInSearchedResults).contains(validatedProductName);
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
        String subTypeOfFilterXpath = "//android.view.View//android.view.View//android.widget.CheckBox[@content-desc='%s']";
        WebElement subTypeOfFilterBtn = driver.findElement(By.xpath(String.format(subTypeOfFilterXpath,subTypeOfFilter)));
        tapOnElementByXPath(subTypeOfFilterBtn,0.1,0.6);
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
