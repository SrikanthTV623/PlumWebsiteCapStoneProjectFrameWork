package com.automation.pages.mobile;

import com.automation.pages.ui.LoginPage;

public class MobileLoginPage implements LoginPage {
    @Override
    public boolean verifyLoginPage() {
        return false;
    }

    @Override
    public void enterMobileNumber(String phoneNoVal) {

    }

    @Override
    public boolean isLoggedInSuccessfully() {
        return false;
    }
}
