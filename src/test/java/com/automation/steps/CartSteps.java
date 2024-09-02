package com.automation.steps;

import com.automation.pages.mobile.MobileAccountPage;
import com.automation.pages.mobile.MobileCartPage;
import com.automation.pages.ui.AccountPage;
import com.automation.pages.ui.CartPage;
import com.automation.pages.web.WebAccountPage;
import com.automation.pages.web.WebCartPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps {
    CartPage cartPage;

    public CartSteps() {
        String env= ConfigReader.getConfigValue("application.type");
        if (env.equals("web")) {
            cartPage = new WebCartPage();
        } else {
            cartPage = new MobileCartPage();
        }
    }

    @Then("verify item is added into cart and should displays {string}")
    public void verifyItemIsAddedIntoCartAndShouldDisplays(String cartItemsCount) {
        Assert.assertEquals(cartItemsCount, cartPage.takesCartCount());
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
        Assert.assertEquals("Your cart is empty", cartPage.sendCartEmptyText());
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
        Assert.assertTrue(cartPage.validatingTheCartPriceIsMatchingWithCalculatedPrice());
    }

    @And("clicks on checkout button")
    public void clicksOnCheckoutButton() {
        cartPage.clicksOnCheckOutButton();
    }


    @And("user enters pin code {string}")
    public void userEntersPinCode(String pinCodeKey) {
        cartPage.enterPinCodeText(pinCodeKey);
    }

    @Then("then validate whether pin code is valid or not")
    public void thenValidateWhetherPinCodeIsValidOrNot() {
        Assert.assertEquals("delivery by", cartPage.findPinCodeIsValidOrNot());
    }
}
