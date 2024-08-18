package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Then("verify user is on login page")
    public void verify_user_is_on_login_page() {
        Assert.assertTrue(loginPage.verifyLoginPage());
    }

    @When("user enters a valid phone number {string} and OTP")
    public void userEntersAValidPhoneNumberAndOTP(String phoneNo) {
        loginPage.enterMobileNumber(ConfigReader.getConfigValue(phoneNo));
    }

    @Then("verify user is logged in and print the welcome message to console")
    public void verifyUserIsLoggedInAndPrintTheWelcomeMessageToConsole() {
        Assert.assertTrue(loginPage.isLoggedInSuccessfully());
    }
}
