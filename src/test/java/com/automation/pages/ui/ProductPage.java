package com.automation.pages.ui;

public interface ProductPage {

    void clicksOnItem();

    default void navigatesForNextProductSearching() {

    }

    void clickOnShoppingCartIcon();

    boolean verifySelectedProductPage();

    default void verifySearchedProductScreenIsDisplayedInApp(String productValue) {

    }

    default void clickOnSortBy() {

    }

    default void sortBy(String sortByValue) {

    }

    ;

    default boolean verifyProductsSortedATOZ() {

        return false;
    }

    ;

    default boolean verifyProductsSortedZTOA() {

        return false;
    }

    ;

    default boolean verifyProductsPricesSortedLowToHigh() {

        return false;
    }

    ;

    default boolean verifyProductsPricesSortedHighToLow() {

        return false;
    }

    ;

    default void printProductList() {

    }

    ;

    default boolean verifyProductName(String configValue) {

        return false;
    }

    ;

    default void clickOnPriceFilter() {

    }

    ;

    default void settingPriceRange(String fromPrice, String toPrice) {

    }

    ;

    default boolean verifyProductsPricesSortedSpecifiedRange() {

        return false;
    }

    ;

    default void getProductNameAndDescriptionText() {

    }

    ;

    default String checkOutOfStockButton() {

        return "";
    }

    ;

    void printOutOfStockProductList();

    default void clickOnFilter() {

    }

    ;

    default void clickOnTypeOfFilter(String typeOfFilter) {

    }

    ;

    default void clickOnSubTypeOfFilter(String subTypeOfFilter) {

    }

    ;

    default boolean verifyProductsSorted(String sortType) {

        return false;
    }

    ;

    default void clicksOnFirstProduct() {

    }

    default boolean verifyProductsPricesSortedSpecifiedRangeBasedOnFilterSelected(String sortType){
        return false;
    }
}
