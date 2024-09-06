package com.automation.pages.ui;

public interface ProductPage {

    void clicksOnItem();

    void navigatesForNextProductSearching();

    void clickOnShoppingCartIcon();

    boolean verifySelectedProductPage();

    void verifySearchedProductScreenIsDisplayedInApp(String productValue);

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

    void clickOnFilter();

    void clickOnTypeOfFilter(String typeOfFilter);

    void clickOnSubTypeOfFilter(String subTypeOfFilter);

    boolean verifyProductsSorted(String sortType);

    default void clicksOnFirstProduct() {

    }
}
