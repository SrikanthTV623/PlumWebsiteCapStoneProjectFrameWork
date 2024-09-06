package com.automation.pages.web;

import com.automation.pages.ui.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WebProductPage extends WebBasePage implements ProductPage {

    @FindBy(xpath = "//div[@id='usf_container']//ul//li[1]")
    WebElement itemFieldClick;

    @FindBy(xpath = "//div[@class='header__icons flex justify-end mis-auto js-closes-menu']/a[3]")
    WebElement shoppingCartIcon;

    @FindBy(xpath = "//h1[@class='collection-banner__heading mb-0 inline']")
    WebElement productPageHeading;

    @FindBy(xpath = "//button[@class='usf-c-select__input-value usf-btn']")
    WebElement sortBy;

    //all products which includes sold out products too
    //@FindBy(xpath = "//p[@class='card__title font-bold mb-1']/a")

    //all products which excludes sold out products
    @FindBy(xpath = "//span[@class='quick-add-btn-text'][text()='Add to cart']//ancestor::div[@class='card__info-container flex flex-col flex-auto relative']//a[contains(@class,'text-current ')]")
    List<WebElement> productList;

    //all products price which excludes only sold out products
    @FindBy(xpath = "//span[@class='quick-add-btn-text'][text()='Add to cart']//ancestor::div[@class='card__info-container flex flex-col flex-auto relative']//div[@class='price price--on-sale']//strong/span")
    List<WebElement> productsPricesList;

    @FindBy(xpath = "//div[@class='usf-facets__body']/div[3]")
    WebElement priceRangeFilter;

    @FindBy(xpath = "//span[@class='usf-slider-input__from']/input")
    WebElement minimumPriceField;

    @FindBy(xpath = "//span[@class='usf-slider-input__to']/input")
    WebElement maximumPriceField;

    @FindBy(xpath = "//div[@id='usf_container']//ul/li//button/span[text()='Sold out']")
    WebElement listOfProductsOutOfStockBtn;

    //all products name which includes only sold out products
    @FindBy(xpath = "//button/span[@class='quick-add-btn-text'][text()='Sold out']//ancestor::div[@class='card__info-container flex flex-col flex-auto relative']//p/a")
    List<WebElement> listOfOutOfStockProductNames;

    @Override
    public void verifySearchedProductScreenIsDisplayedInApp(String productValue) {

    }

    public void clicksOnItem() {
        itemFieldClick.click();
    }

    @Override
    public void navigatesForNextProductSearching() {

    }

    public void clickOnShoppingCartIcon() {
        shoppingCartIcon.click();
    }

    public boolean verifySelectedProductPage() {
        return productPageHeading.isDisplayed();
    }

    public void clickOnSortBy() {
        sortBy.click();
    }

    public void sortBy(String sortByValue) {
        String sortByXpath = "//div[@class='usf-c-select__list']/button[contains(text(),'%s')]";
        driver.findElement(By.xpath(String.format(sortByXpath, sortByValue))).click();
    }

    public boolean verifyProductsSortedATOZ() {
        List<String> productNames = new ArrayList<>();
        for (WebElement product : productList) {
            productNames.add(product.getText());
        }
        List<String> collectionsSort = new ArrayList<>(productNames);
        Collections.sort(collectionsSort);
        System.out.println(productNames + "\n" + collectionsSort);
        if (productNames.equals(collectionsSort)) {
            return true;
        }
        return false;
    }

    public boolean verifyProductsSortedZTOA() {
        List<String> productNames = new ArrayList<>();
        for (WebElement product : productList) {
            productNames.add(product.getText());
        }

        List<String> collectionsSort = productNames.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(productNames + "\n" + collectionsSort);

        if (productNames.equals(collectionsSort)) {
            return true;
        }
        return false;
    }

    public void printProductList() {
        List<String> productNames = new ArrayList<>();
        for (WebElement product : productList) {
            productNames.add(product.getText());
        }
        System.out.println(productNames);
    }

    public boolean verifyProductName(String productName) {
        for (WebElement product : productList) {
            String individualProductName = product.getText();
            System.out.println(individualProductName);
            if (!individualProductName.contains(productName)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyProductsPricesSortedLowToHigh() {
        List<Double> priceValues = new ArrayList<>();
        for (WebElement price : productsPricesList) {
            String priceText = price.getText().replace("₹", "").replace("Rs. ", "").replace(",", "");
            priceValues.add(Double.parseDouble(priceText));
        }

        List<Double> sortedPriceValues = new ArrayList<>(priceValues);
        Collections.sort(sortedPriceValues);
        System.out.println(priceValues + "\n" + sortedPriceValues);

        if (priceValues.equals(sortedPriceValues)) {
            return true;
        }
        return false;
    }


    public boolean verifyProductsPricesSortedHighToLow() {
        List<Double> priceValues = new ArrayList<>();
        for (WebElement price : productsPricesList) {
            String priceText = price.getText().replace("₹", "").replace("Rs. ", "").replace(",", "");
            priceValues.add(Double.parseDouble(priceText));
        }

        List<Double> sortedPriceValues = new ArrayList<>(priceValues);
        Collections.sort(sortedPriceValues, Collections.reverseOrder());

        System.out.println(priceValues + "\n" + sortedPriceValues);

        if (priceValues.equals(sortedPriceValues)) {
            return true;
        }
        return false;
    }


    public void clickOnPriceFilter() {
        scrollToElement(priceRangeFilter);
        priceRangeFilter.click();
    }

    public void settingPriceRange(String fromPriceValue, String toPriceValue) {
        maximumPriceField.click();
        maximumPriceField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        maximumPriceField.sendKeys(toPriceValue);
        minimumPriceField.click();
        minimumPriceField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        minimumPriceField.sendKeys(fromPriceValue);

    }

    public boolean verifyProductsPricesSortedSpecifiedRange() {
        double minPrice = 200.0;
        double maxPrice = 800.0;

        for (WebElement priceElement : productsPricesList) {
            String priceText = priceElement.getText().replace("₹", "").replace("Rs. ", "").replace(",", "");
            double priceValue = Double.parseDouble(priceText);

            if (priceValue < minPrice || priceValue > maxPrice) {
                return false;
            }
        }
        return true;
    }

    public void getProductNameAndDescriptionText() {
        WebElement itemNameTxt = driver.findElement(By.xpath("//div[@id='usf_container']//ul//li[1]//p[@class='card__title font-bold mb-1']/a"));
        WebElement descriptionTxt = driver.findElement(By.xpath("//div[@id='usf_container']//ul//li[1]//p[@class='text-sm text-current mb-1']"));
        System.out.println(productPageHeading.getText());
        System.out.println(itemNameTxt.getText());
        System.out.println(descriptionTxt.getText());
    }

    public String checkOutOfStockButton() {
        return listOfProductsOutOfStockBtn.getText();
    }

    public void printOutOfStockProductList() {
        List<String> outOfStockProductNames = new ArrayList<>();
        for (WebElement product : listOfOutOfStockProductNames) {
            outOfStockProductNames.add(product.getText());
        }
        System.out.println(outOfStockProductNames);
    }

    @Override
    public void clickOnFilter() {

    }

    @Override
    public void clickOnTypeOfFilter(String typeOfFilter) {

    }

    @Override
    public void clickOnSubTypeOfFilter(String subTypeOfFilter) {

    }

    @Override
    public boolean verifyProductsSorted(String sortType) {
        return false;
    }


}
