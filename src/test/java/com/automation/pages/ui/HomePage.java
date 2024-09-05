package com.automation.pages.ui;

public interface HomePage {
    void openWebsite();

    boolean verifyHomePage();

    void clickOnLoginButton();

    void clickOnLoginLogoBtn();

    void enterValueOnSearchBar(String searchValue);

    void selectProductCategory(String category);

    void selectProductFromDropDown(String productType);

    void selectSpecifiedProductFromDropDown(String specifiedProduct);

    void gettingSearchValueFromTextFile();

    void validateSearchResultsForSearchedItem();

    void clickOnOrderHistory();
}
