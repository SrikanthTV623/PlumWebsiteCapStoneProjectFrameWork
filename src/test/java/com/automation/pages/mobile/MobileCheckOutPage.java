package com.automation.pages.mobile;

import com.automation.pages.ui.CheckOutPage;

public class MobileCheckOutPage implements CheckOutPage {

    @Override
    public void enterPhoneNo() {

    }

    @Override
    public boolean isPaymentOptionDisplayed() {
        return false;
    }

    @Override
    public void selectCashOnDelivery() {

    }

    @Override
    public boolean verifyOrderIsPlaced() {
        return false;
    }

    @Override
    public void storeOrderId(String orderId) {

    }

    @Override
    public void navigateToHomePage() {

    }
}
