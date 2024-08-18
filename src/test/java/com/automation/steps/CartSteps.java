package com.automation.steps;

import com.automation.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps {

    CartPage cartPage = new CartPage();

    @Then("verify item is added into cart and should displays {string}")
    public void verifyItemIsAddedIntoCartAndShouldDisplays(String cartItemsCount) {
        Assert.assertEquals(cartItemsCount,cartPage.takesCartCount());
    }

    @And("user views the cart contents")
    public void userViewsTheCartContents() {
        Assert.assertTrue(cartPage.cartContentsIsDisplayed());
    }

    @When("user clicks on remove button next to an item")
    public void userClicksOnRemoveButtonNextToAnItem() {
        cartPage.clickOnRemoveButton();
    }

    @Then("verify shopping cart is empty")
    public void verifyShoppingCartIsEmpty() {
        Assert.assertEquals("Your cart is empty",cartPage.sendCartEmptyText());
    }

    @Then("the item should be removed from the cart")
    public void theItemShouldBeRemovedFromTheCart() {
        Assert.assertFalse(cartPage.getCartContentText().contains("Sunscreen"));
    }

    @And("the cart should display the updated cart count")
    public void theCartShouldDisplayTheUpdatedCartCount() {
        Assert.assertTrue(Integer.parseInt(cartPage.takesCartCount()) == 1);
    }


    @Then("verify cart contains correct products count and cart value")
    public void verifyCartContainsCorrectProductsCountAndCartValue() {
        cartPage.validatingTheCartPriceIsMatchingWithCalculatedPrice();
        //Assert.assertTrue(cartPage.validatingTheCartPriceIsMatchingWithCalculatedPrice());
    }
}
