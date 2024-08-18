package com.automation.steps;

import com.automation.pages.ItemsDescriptionPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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

}
