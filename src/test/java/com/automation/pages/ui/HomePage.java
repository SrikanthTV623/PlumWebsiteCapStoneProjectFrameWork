package com.automation.pages.ui;

public interface HomePage {
    void openWebsite();

    boolean verifyHomePage();

    default void clickOnLoginButton() {

    }

    void clickOnLoginLogoBtn();

    void enterValueOnSearchBar(String searchValue);

    void selectProductCategory(String category);

    void selectProductFromDropDown(String productType);

    default void selectProductCategoryAndType(String productCategory, String productType) {

    }

    default void selectSpecifiedProductFromDropDown(String specifiedProduct) {

    }

    void gettingSearchValueFromTextFile();

    void validateSearchResultsForSearchedItem();

    default void clickOnOrderHistory() {

    }

    default void clickOnShopButton(String scrollElementName) {

    }

    default void selectsFirstProductAndAddedToWishlist(){

    }

    default void clickOnSearchToNavigateToProductFinder(){};

    default void selectConcernFromDropDown(String concern) {
        
    }

    default void selectProductTypeFromDropDown(String productType){};

    default void clickOnFindProduct(){}
}
