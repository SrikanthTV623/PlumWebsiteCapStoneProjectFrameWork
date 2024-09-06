package com.automation.pages.mobile;

import com.automation.pages.ui.ProductPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
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

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[4]")
    //@FindBy(xpath = "//android.widget.ImageView[@content-desc='1']")
    WebElement shoppingCartIcon;

    @FindBy(xpath = "(//android.view.View[@content-desc='add to cart']/..)[1]")
    WebElement firstProductInSearchedResults;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='FILTERS']")
    WebElement filterBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='apply filter']")
    WebElement applyFilterOptionInFilterPage;

    @FindBy(xpath = "(//android.view.View[@content-desc='add to cart'] | //android.widget.ImageView[@content-desc='add to cart'])/..")
    List <WebElement> listOfSearchedProducts;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'products')]")
    WebElement totalProductsCount;

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



    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
    WebElement plumLogo;

    @Override
    public void navigateToHomePage() {
        plumLogo.click();
    }



    @Override
    public boolean verifyProductName(String validatedProductName) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitForElementToBeVisible(firstProductInSearchedResults);
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
        List<Double> priceValues = new ArrayList<>();

        String totalProductsTxt = getContentDescriptionOfAnElement(totalProductsCount);
        int totalProductsCount = Integer.parseInt(totalProductsTxt.split(" ")[0]);

        for(WebElement price : listOfSearchedProducts){
            double priceText = extractPriceFromProductDescription(getContentDescriptionOfAnElement(price));
            System.out.println(priceText);
            priceValues.add(priceText);
            System.out.println(priceValues);
            if(totalProductsCount>3){
                performScrollToMovePage();
            }
        }

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

    @Override
    public void clickOnSubTypeOfFilter(String subTypeOfFilter) {
        String subTypeOfFilterXpath = "//android.view.View//android.view.View//android.widget.CheckBox[@content-desc='%s']";
        WebElement subTypeOfFilterBtn = driver.findElement(By.xpath(String.format(subTypeOfFilterXpath,subTypeOfFilter)));
        tapOnElementByXPath(subTypeOfFilterBtn);
        applyFilterOptionInFilterPage.click();
    }

    @Override
    public boolean verifyProductsSorted(String sortType) {
        String totalProductsTxt = getContentDescriptionOfAnElement(totalProductsCount);
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

    @Override
    public void clicksOnFirstProduct() {
        firstProductInSearchedResults.click();
    }
}
