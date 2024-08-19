package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {
    HomePage homePage = new HomePage();

    @Given("user opens website")
    public void user_opens_website() {
        homePage.openWebsite();
    }

    @Then("verify user is on the Plum Goodness homepage")
    public void verify_user_is_on_the_plum_goodness_homepage() {
        Assert.assertTrue(homePage.verifyHomePage());
    }

    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        homePage.clickOnLoginButton();
    }


    @When("the user enters {string} into the search bar")
    public void theUserEntersIntoTheSearchBar(String searchKey) {
        homePage.enterValueOnSearchBar(ConfigReader.getConfigValue(searchKey));
    }

    @When("user selects product category {string}")
    public void userSelectsProductCategory(String category) {
        homePage.selectProductCategory(ConfigReader.getConfigValue(category));
    }

    @And("user selects product type {string} from the drop down")
    public void userSelectsProductTypeFromTheDropDown(String productType) {
        homePage.selectProductFromDropDown(ConfigReader.getConfigValue(productType));
    }

//    @When("user clicks on hair dropdown")
//    public void userClicksOnHairDropdown() {
//        homePage.clickOnHairDropdown();
//    }
//
//    @And("user selects hair mask from the dropdown")
//    public void userSelectsHairMaskFromTheDropdown() {
//        homePage.selectHairMaskFromDropDown();
//    }




}
