package com.automation.pages.ui;

public interface CartPage {
    boolean cartContentsIsDisplayed();

    void clickOnRemoveButton();

    default String getCartContentText(String removedProductName) {
        return "";
    }

    String takesCartCount();

    String sendCartEmptyText();

    boolean validatingTheCartPriceIsMatchingWithCalculatedPrice();

    String parsePrice(String priceText);

    void clicksOnCheckOutButton();

    void enterPinCodeText(String pinCodeTxt);

    String findPinCodeIsValidOrNot();
}
