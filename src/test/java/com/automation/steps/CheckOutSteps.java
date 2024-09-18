package com.automation.steps;

import com.automation.pages.mobile.MobileAccountPage;
import com.automation.pages.mobile.MobileCheckOutPage;
import com.automation.pages.ui.AccountPage;
import com.automation.pages.ui.CheckOutPage;
import com.automation.pages.web.WebAccountPage;
import com.automation.pages.web.WebCheckOutPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckOutSteps {

    CheckOutPage checkOutPage;

    public CheckOutSteps() {
        String env= System.getProperty("env");
        if (env.equals("web")) {
            checkOutPage = new WebCheckOutPage();
        } else {
            checkOutPage = new MobileCheckOutPage();
        }
    }

    @And("enters phoneNo and address")
    public void entersPhoneNoAndAddress() {
        checkOutPage.enterPhoneNo();
        if(ConfigReader.getConfigValue("application.type").contains("mobile")){
            checkOutPage.enterRequiredDetails();
        }
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
