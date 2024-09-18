package com.automation.steps;

import com.automation.pages.mobile.MobileStoreLocatorPage;
import com.automation.pages.ui.StoreLocatorPage;
import com.automation.pages.web.WebStoreLocatorPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StoreLocatorSteps {
    StoreLocatorPage storeLocatorPage;
    
    public StoreLocatorSteps() {
        String env= System.getProperty("env");
        if (env.equals("web")) {
            storeLocatorPage = new WebStoreLocatorPage();
        } else {
            storeLocatorPage = new MobileStoreLocatorPage();
        }
    }

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
