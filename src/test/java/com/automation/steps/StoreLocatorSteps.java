package com.automation.steps;

import com.automation.pages.StoreLocatorPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StoreLocatorSteps {
    StoreLocatorPage storeLocatorPage = new StoreLocatorPage();

    @Then("verify user is on {string}")
    public void verifyUserIsOn(String pageHeading) {
        Assert.assertEquals(pageHeading, storeLocatorPage.verifyPage());
    }

    @When("user clicks on {string}")
    public void userClicksOn(String cityName) {
        storeLocatorPage.selectCity(cityName);
    }

    @And("print all the store locations")
    public void printAllTheStoreLocations() {
        storeLocatorPage.printStoreLocations();
    }
}
