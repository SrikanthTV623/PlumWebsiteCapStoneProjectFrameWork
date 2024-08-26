package com.automation.pages.ui;

public interface AccountPage {

    boolean verifyPage();

    void clickOnOrderCancellation();

    void enterOrderCancellationDetails(String orderId, String phoneNo);

    void setReasonForOrderCancellation(String reason);

    void clickOnCancelButton();

    void confirmCancellation();

    String verifyOrderCancellation();

}
