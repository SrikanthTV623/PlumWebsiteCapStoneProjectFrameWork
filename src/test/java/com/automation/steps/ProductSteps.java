package com.automation.steps;

import com.automation.pages.ProductPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSteps {
    ProductPage productPage = new ProductPage();

    @Then("verify user is on searched product page")
    public void verifyUserIsOnSearchedProductPage() {

    }

    @When("user clicks on a product from the search results")
    public void userClicksOnAProductFromTheSearchResults() {
        productPage.clicksOnItem();
    }

    @And("clicks on the shopping cart icon")
    public void clicksOnTheShoppingCartIcon() {
        productPage.clickOnShoppingCartIcon();
    }


    @Then("verify user is on product page")
    public void verifyUserIsOnProductPage() {
        Assert.assertTrue(productPage.verifySelectedProductPage());
    }

    @When("user clicks on sort by")
    public void userClicksOnSortBy() {
        productPage.clickOnSortBy();
    }

    @And("selects {string} from the drop down")
    public void selectsFromTheDropDown(String sortByValue) {
        //productPage.sortBy(ConfigReader.getConfigValue(sortByValue));
        productPage.sortBy(sortByValue);

    }

    @Then("verify products are sorted {string} accordingly")
    public void verifyProductsAreSortedAccordingly(String sortType) {
        //sortType=ConfigReader.getConfigValue(sortType);
        if (sortType.equals("A-Z")) {
            Assert.assertTrue(productPage.verifyProductsSortedATOZ());
        } else if (sortType.equals("Z-A")) {
            Assert.assertTrue(productPage.verifyProductsSortedZTOA());
        } else if (sortType.equals("Low to High")) {
            Assert.assertTrue(productPage.verifyProductsPricesSortedLowToHigh());
        } else if (sortType.equals("High to Low")) {
            Assert.assertTrue(productPage.verifyProductsPricesSortedHighToLow());
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

    @When("user clicks on price range filter")
    public void userClicksOnPriceRangeFilter() {
        productPage.clickOnPriceFilter();
    }

    @And("user sets price range between {string} and {string}")
    public void userSetsPriceRangeBetweenAnd(String fromPrice, String toPrice) {
        productPage.settingPriceRange(fromPrice, toPrice);
    }

    @Then("displayed products should have prices within the specified range")
    public void displayedProductsShouldHavePricesWithinTheSpecifiedRange() {
        Assert.assertTrue(productPage.verifyProductsPricesSortedSpecifiedRange());
    }

    @Then("verify specific-product type {string} of products are displayed")
    public void verifySpecificProductTypeOfProductsAreDisplayed(String displayedSpecifiedProduct) {
        Assert.assertTrue(productPage.verifySelectedProductPage());
    }

    @And("print product name and description")
    public void printProductNameAndDescription() {
        productPage.getProductNameAndDescriptionText();
    }

    @Then("verify product is out of stock")
    public void verifyProductIsOutOfStock() {
        Assert.assertEquals("sold out", productPage.checkOutOfStockButton());
    }

    @And("print names of all out of stock products")
    public void printNamesOfAllOutOfStockProducts() {
        productPage.printOutOfStockProductList();
    }
}
