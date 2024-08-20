package com.automation.steps;

import com.automation.pages.CheckOutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CheckOutSteps {

    CheckOutPage checkOutPage = new CheckOutPage();

    @And("enters phoneNo and address")
    public void entersPhoneNoAndAddress() {
        checkOutPage.enterPhoneNo();
        //checkOutPage.enterRequiredDetails();
    }

    @Then("verify payment option is displayed")
    public void verifyPaymentOptionIsDisplayed() {
        Assert.assertTrue(checkOutPage.isPaymentOptionDisplayed());
    }
}
