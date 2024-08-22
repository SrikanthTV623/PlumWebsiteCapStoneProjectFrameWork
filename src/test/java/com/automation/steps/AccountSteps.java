package com.automation.steps;

import com.automation.pages.AccountPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountSteps {
    AccountPage accountPage=new AccountPage();
    @Then("verify user is on account page")
    public void verify_user_is_on_account_page() {
        Assert.assertTrue(accountPage.verifyPage());
    }


    @When("user clicks on order cancellation")
    public void userClicksOnOrderCancellation() {
        accountPage.clickOnOrderCancellation();
    }

    @And("Enter order cancellation details {string} and {string}")
    public void enterOrderCancellationDetailsAnd(String orderId, String phoneNo) {
        accountPage.enterOrderCancellationDetails(ConfigReader.getConfigValue(orderId),ConfigReader.getConfigValue(phoneNo));
    }


    @And("select reason for order cancellation as {string}")
    public void selectReasonForOrderCancellationAs(String reason) {
        accountPage.setReasonForOrderCancellation(ConfigReader.getConfigValue(reason));
    }


    @And("user clicks on cancel button")
    public void userClicksOnCancelButton() {
        accountPage.clickOnCancelButton();
    }


    @And("confirm cancellation")
    public void confirmCancellation() {
        accountPage.confirmCancellation();
    }

    @Then("verify user has successfully cancelled the order")
    public void verifyUserHasSuccessfullyCancelledTheOrder() {
        Assert.assertEquals("Your order has been canceled!",accountPage.verifyOrderCancellation());
    }
}
