package com.automation.pages.ui;

public interface ProductPage {

    void verifySearchedProductPageIsDisplayed();

    void clicksOnItem();

    void clickOnShoppingCartIcon();

    boolean verifySelectedProductPage();

    void clickOnSortBy();

    void sortBy(String sortByValue);

    boolean verifyProductsSortedATOZ();

    boolean verifyProductsSortedZTOA();

    boolean verifyProductsPricesSortedLowToHigh();

    boolean verifyProductsPricesSortedHighToLow();

    void printProductList();

    boolean verifyProductName(String configValue);

    void clickOnPriceFilter();

    void settingPriceRange(String fromPrice, String toPrice);

    boolean verifyProductsPricesSortedSpecifiedRange();

    void getProductNameAndDescriptionText();

    String checkOutOfStockButton();

    void printOutOfStockProductList();

}
