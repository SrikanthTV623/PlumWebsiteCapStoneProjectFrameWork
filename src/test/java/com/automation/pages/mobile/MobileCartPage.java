package com.automation.pages.mobile;

import com.automation.pages.ui.CartPage;

public class MobileCartPage implements CartPage {
    @Override
    public boolean cartContentsIsDisplayed() {
        return false;
    }

    @Override
    public void clickOnRemoveButton() {

    }

    @Override
    public String getCartContentText() {
        return "";
    }

    @Override
    public String takesCartCount() {
        return "";
    }

    @Override
    public String sendCartEmptyText() {
        return "";
    }

    @Override
    public boolean validatingTheCartPriceIsMatchingWithCalculatedPrice() {
        return false;
    }

    @Override
    public String parsePrice(String priceText) {
        return "";
    }

    @Override
    public void clicksOnCheckOutButton() {

    }

    @Override
    public void enterPinCodeText(String pinCodeTxt) {

    }

    @Override
    public String findPinCodeIsValidOrNot() {
        return "";
    }
}
