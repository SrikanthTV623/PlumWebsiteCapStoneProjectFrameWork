package com.automation.pages.ui;

public interface LoginPage {
    boolean verifyLoginPage();

    void enterMobileNumber(String configValue);

    boolean isLoggedInSuccessfully();
}
