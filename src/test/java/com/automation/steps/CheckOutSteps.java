package com.automation.steps;

import com.automation.pages.CheckOutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @When("user clicks on cash on delivery option")
    public void userClicksOnCashOnDeliveryOption() {
        checkOutPage.selectCashOnDelivery();
    }

    @Then("verify the order is placed")
    public void verifyTheOrderIsPlaced() {
        Assert.assertTrue(checkOutPage.verifyOrderIsPlaced());
    }

    @And("store the order id as {string}")
    public void storeTheOrderIdAs(String orderId) {
        checkOutPage.storeOrderId(orderId);
    }

    @And("user navigates to home page")
    public void userNavigatesToHomePage() {
         checkOutPage.navigateToHomePage();
    }
}
