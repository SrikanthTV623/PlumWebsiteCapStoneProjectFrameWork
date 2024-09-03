package com.automation.pages.ui;

public interface CheckOutPage {

    void enterPhoneNo();

    void enterRequiredDetails();

    boolean isPaymentOptionDisplayed();

    void selectCashOnDelivery();

    boolean verifyOrderIsPlaced();

    void storeOrderId(String orderId);

    void navigateToHomePage();
}
