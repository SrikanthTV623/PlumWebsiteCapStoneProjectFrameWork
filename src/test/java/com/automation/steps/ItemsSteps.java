package com.automation.steps;

import com.automation.pages.ItemsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ItemsSteps {

    ItemsPage itemsPage = new ItemsPage();

    @Then("verify user is on product results page")
    public void verifyUserIsOnProductResultsPage() {

    }

    @When("user clicks on a product from the search results")
    public void userClicksOnAProductFromTheSearchResults() {
        itemsPage.clicksOnItem();
    }

    @And("clicks on the shopping cart icon")
    public void clicksOnTheShoppingCartIcon() {
        itemsPage.clickOnShoppingCartIcon();
    }


}
