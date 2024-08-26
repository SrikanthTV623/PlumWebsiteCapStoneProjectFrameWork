package com.automation.pages.mobile;

import com.automation.pages.ui.AccountPage;

public class MobileAccountPage implements AccountPage {

    @Override
    public boolean verifyPage() {
        return false;
    }

    @Override
    public void clickOnOrderCancellation() {

    }

    @Override
    public void enterOrderCancellationDetails(String orderId, String phoneNo) {

    }

    @Override
    public void setReasonForOrderCancellation(String reason) {

    }

    @Override
    public void clickOnCancelButton() {

    }

    @Override
    public void confirmCancellation() {

    }

    @Override
    public String verifyOrderCancellation() {
        return "";
    }
}
