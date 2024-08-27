package com.automation.steps;

import com.automation.pages.mobile.MobileProductDescriptionPage;
import com.automation.pages.ui.ProductDescriptionPage;
import com.automation.pages.web.WebProductDescriptionPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class ProductDescriptionSteps {

    ProductDescriptionPage productDescriptionPage ;

    public ProductDescriptionSteps() {
        String env= ConfigReader.getConfigValue("application.type");
        if (env.equals("web")) {
            productDescriptionPage = new WebProductDescriptionPage();
        } else {
            productDescriptionPage = new MobileProductDescriptionPage();
        }
    }
    

    @Then("user should be redirected to the product details page")
    public void userShouldBeRedirectedToTheProductDetailsPage() {
        Assert.assertTrue("Items Description Page is not displayed",productDescriptionPage.productDescriptionPageDisplayed());
    }

    @When("user clicks the Add to Cart button")
    public void userClicksTheAddToCartButton() {
        productDescriptionPage.clickOnAddToCartBtn();
    }

    @When("user scroll and clicks on write review button")
    public void userScrollAndClicksOnWriteReviewButton() {
        productDescriptionPage.scrollAndClickOnWriteReviewButton();
    }


    @And("user fills review data")
    public void userFillsReviewData(List<String> reviewData) {
        productDescriptionPage.addReviewData(reviewData);
    }

    @And("user clicks on submit review")
    public void userClicksOnSubmitReview() {
        productDescriptionPage.clickOnSubmitReviewButton();
    }

    @Then("verify user {string} review has been added")
    public void verifyUserReviewHasBeenAdded(String userName) {
        Assert.assertEquals(productDescriptionPage.verifyReviewIsAdded(), ConfigReader.getConfigValue(userName));
    }


}
