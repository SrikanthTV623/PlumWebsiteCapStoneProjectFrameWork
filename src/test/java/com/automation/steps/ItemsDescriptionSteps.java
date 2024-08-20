package com.automation.steps;

import com.automation.pages.ItemsDescriptionPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class ItemsDescriptionSteps {

    ItemsDescriptionPage itemsDescriptionPage = new ItemsDescriptionPage();

    @Then("user should be redirected to the product details page")
    public void userShouldBeRedirectedToTheProductDetailsPage() {
        Assert.assertTrue("Items Description Page is not displayed",
                itemsDescriptionPage.itemDescriptionPageDisplayed());
    }

    @When("user clicks the Add to Cart button")
    public void userClicksTheAddToCartButton() {
        itemsDescriptionPage.clickOnAddToCartBtn();
    }

    @When("user scroll and clicks on write review button")
    public void userScrollAndClicksOnWriteReviewButton() {
        itemsDescriptionPage.scrollAndClickOnWriteReviewButton();
    }


    @And("user fills review data")
    public void userFillsReviewData(List<String> reviewData) {
        itemsDescriptionPage.addReviewData(reviewData);
    }

    @And("user clicks on submit review")
    public void userClicksOnSubmitReview() {
        itemsDescriptionPage.clickOnSubmitReviewButton();
    }

    @Then("verify user {string} review has been added")
    public void verifyUserReviewHasBeenAdded(String userName) {
        Assert.assertEquals(itemsDescriptionPage.verifyReviewIsAdded(), ConfigReader.getConfigValue(userName));
    }


}
