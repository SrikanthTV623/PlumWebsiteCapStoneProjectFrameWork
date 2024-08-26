package com.automation.pages.mobile;

import com.automation.pages.ui.ProductPage;

public class MobileProductPage implements ProductPage {
    @Override
    public void clicksOnItem() {

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
