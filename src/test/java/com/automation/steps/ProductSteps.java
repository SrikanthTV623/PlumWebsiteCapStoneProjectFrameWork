package com.automation.steps;

import com.automation.pages.ProductPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSteps {
    ProductPage productPage=new ProductPage();


    @Then("verify user is on product page")
    public void verifyUserIsOnProductPage() {
        Assert.assertTrue(productPage.verifySelectedProductPage());
    }

    @When("user clicks on sort by")
    public void userClicksOnSortBy() {
        productPage.clickOnSortBy();
    }

    @And("selects {string} from the drop down")
    public void selectsFromTheDropDown(String sortByKey) {
        productPage.sortBy(sortByKey);

    }

    @Then("verify products are sorted {string} accordingly")
    public void verifyProductsAreSortedAccordingly(String sortType) {
        sortType=ConfigReader.getConfigValue(sortType);
        if(sortType.equals("A-Z")){
            Assert.assertTrue(productPage.verifyProductsSortedATOZ());
        } else if (sortType.equals("Z-A")) {
            Assert.assertTrue(productPage.verifyProductsSortedZTOA());
        }
    }

    @And("get product list")
    public void getProductList() {
        productPage.printProductList();
    }

    @Then("verify searched product {string} and displayed product names are same")
    public void verifySearchedProductAndDisplayedProductNamesAreSame(String productName) {
        Assert.assertTrue(productPage.verifyProductName(ConfigReader.getConfigValue(productName)));
    }
}
