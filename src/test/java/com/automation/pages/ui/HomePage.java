package com.automation.pages.ui;

public interface HomePage {
    default void openWebsite() {

    }

    default boolean verifyHomePage() {
        return false;
    }

    default void clickOnLoginButton() {

    }

    default void clickOnLoginLogoBtn() {

    }

    default void enterValueOnSearchBar(String searchValue) {

    }

    default void selectProductCategory(String category) {

    }

    default void selectProductFromDropDown(String productType) {

    }

    default void selectProductCategoryAndType(String productCategory, String productType) {

    }

    default void selectSpecifiedProductFromDropDown(String specifiedProduct) {

    }

    default void gettingSearchValueFromTextFile() {

    }

    default void validateSearchResultsForSearchedItem(){
    };

    default void clickOnOrderHistory() {

    }

    default void searchTheProduct(){

    };
}
