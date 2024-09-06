package com.automation.steps;

import com.automation.pages.mobile.MobileAccountPage;
import com.automation.pages.ui.AccountPage;
import com.automation.pages.web.WebAccountPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountSteps {
    AccountPage accountPage;

    public AccountSteps() {
        String env=ConfigReader.getConfigValue("application.type");
        if (env.equals("web")) {
            accountPage = new WebAccountPage();
        } else {
            accountPage = new MobileAccountPage();
        }
    }
    //accountPage = new accountPage();

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
        accountPage.enterOrderCancellationDetails(ConfigReader.getConfigValue(orderId), ConfigReader.getConfigValue(phoneNo));
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
        Assert.assertEquals("Your order has been canceled!", accountPage.verifyOrderCancellation());
    }

    @When("user store the profile name and navigate back to home page")
    public void userStoreTheProfileNameAndNavigateBackToHomePage() {

    }

    @When("user store the profile name as {string}")
    public void userStoreTheProfileNameAs(String usernameKey) {
        accountPage.storeTheUserName(usernameKey);
    }

    @And("navigate back to home page")
    public void navigateBackToHomePage() {
        accountPage.navigateToHomePage();
    }
}
