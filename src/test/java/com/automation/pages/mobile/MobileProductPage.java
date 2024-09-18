package com.automation.pages.mobile;

import com.automation.pages.ui.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MobileProductPage extends MobileBasePage implements ProductPage {

    //@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/(android.view.View)[1]")
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='FILTERS']/../android.view.View/android.view.View/android.view.View[1]")
    WebElement selectProductField;

    @FindBy(xpath = "//android.view.View[@content-desc=\"cart\"]/../android.widget.ImageView[1]")
    WebElement cartScreenToNavigatesBack;

    @FindBy(xpath = "(//android.view.View[@content-desc]/../../..//following-sibling::android.widget.ImageView)[1]")
    WebElement productDescScreenToNavigatesBack;

    @FindBy(xpath = "(//android.view.View[@content-desc]/../android.widget.ImageView)[1]")
    WebElement productScreenToNavigatesBack;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[4]")
    //@FindBy(xpath = "//android.widget.ImageView[@content-desc='1']")
    WebElement shoppingCartIcon;

    //@FindBy(xpath = "(//android.view.View[@content-desc='add to cart']/..)[1]")
    @FindBy(xpath = "(//android.view.View[@content-desc='notify me']/..)[1] | (//android.view.View[@content-desc='add to cart']/..)[1]")
    WebElement firstProductInSearchedResults;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='FILTERS']")
    WebElement filterBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='apply filter']")
    WebElement applyFilterOptionInFilterPage;

    @FindBy(xpath = "(//android.view.View[@content-desc='add to cart'] | //android.widget.ImageView[@content-desc='add to cart'])/..")
    List <WebElement> listOfSearchedProducts;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'products')]")
    WebElement totalProductsCount;

    @FindBy(xpath = "//android.view.View[@content-desc='notify me']/..")
    List<WebElement> outOfStockProductsList;

    @FindBy(xpath = "(//android.view.View[@content-desc='notify me']/..)[1]")
    WebElement selectFirstProductOfOutOfStockProductsList;

    @Override
    public void verifySearchedProductScreenIsDisplayedInApp(String productValue) {
        String searchedProductXpath = "//android.view.View[@content-desc='%s']";
        driver.findElement(By.xpath(String.format(searchedProductXpath, productValue))).isDisplayed();
    }

    @Override
    public void clicksOnItem() {
        waitForElementToBeVisible(selectProductField);
        selectProductField.click();
    }

    @Override
    public void navigatesForNextProductSearching() {
        cartScreenToNavigatesBack.click();
        productDescScreenToNavigatesBack.click();
        productScreenToNavigatesBack.click();
    }

    @Override
    public void clickOnShoppingCartIcon() {
        shoppingCartIcon.click();
    }

    @Override
    public boolean verifyProductName(String validatedProductName) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitForElementToBeVisible(firstProductInSearchedResults);
        return getContentDescriptionOfAnElement(firstProductInSearchedResults).toLowerCase().contains(validatedProductName.toLowerCase());
    }

    @Override
    public void clickOnPriceFilter() {

    }

    @Override
    public void settingPriceRange(String fromPriceValue, String toPriceValue) {

    }

    @Override
    public boolean verifyProductsPricesSortedSpecifiedRangeBasedOnFilterSelected(String sortType) {
        List<Double> priceValues = new ArrayList<>();

        String totalProductsTxt = getContentDescriptionOfAnElement(totalProductsCount);
        int totalProductsCount = Integer.parseInt(totalProductsTxt.split(" ")[0]);

        if(totalProductsCount>=3){
            performScrollToMovePage();
        }

        for(WebElement price : listOfSearchedProducts) {
            double priceText = extractPriceFromProductDescription(getContentDescriptionOfAnElement(price));
            priceValues.add(priceText);
        }

        System.out.println(priceValues);
        System.out.println(sortType);

        double startingPriceOfFilter = Double.parseDouble(sortType.split("-")[0]);
        double endingPriceOfFilter = Double.parseDouble(sortType.split("-")[1]);

        System.out.println(startingPriceOfFilter+" "+endingPriceOfFilter);

        for(double productPriceValue:priceValues){
            if(!(productPriceValue>=startingPriceOfFilter && productPriceValue<=endingPriceOfFilter)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void getProductNameAndDescriptionText() {

    }


    public boolean verifySelectedProductPage() {
        return false;
    }

    @Override
    public String checkOutOfStockButton() {
        return getContentDescriptionOfAnElement(selectFirstProductOfOutOfStockProductsList);
    }

    @Override
    public void printOutOfStockProductList() {
        List<String> outOfStockProductNames = new ArrayList<>();
        for (WebElement product : outOfStockProductsList) {
            outOfStockProductNames.add(getContentDescriptionOfAnElement(product));
        }
        System.out.println(outOfStockProductNames);
    }

    @Override
    public void clickOnFilter() {
        filterBtn.click();
    }


    @Override
    public void clickOnTypeOfFilter(String typeOfFilter) {
        String typeOfFilterXpath = "//android.view.View[@content-desc='%s']";
        WebElement typeOfFilterBtn = driver.findElement(By.xpath(String.format(typeOfFilterXpath, typeOfFilter)));
        typeOfFilterBtn.click();
    }

    @Override
    public void clickOnSubTypeOfFilter(String subTypeOfFilter) {
        String subTypeOfFilterXpath = "//android.view.View//android.view.View//android.widget.CheckBox[contains(@content-desc,'%s')]";
        WebElement subTypeOfFilterBtn = driver.findElement(By.xpath(String.format(subTypeOfFilterXpath,subTypeOfFilter)));
        tapOnElementByXPath(subTypeOfFilterBtn);
        applyFilterOptionInFilterPage.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean verifyProductsSorted(String sortType) {
        String totalProductsTxt = getContentDescriptionOfAnElement(totalProductsCount);
        int totalProducts = Integer.parseInt(totalProductsTxt.split(" ")[0]);
        if(totalProducts==1){
            WebElement product=driver.findElement(By.xpath("(//android.view.View[@content-desc='add to cart']/..)[1]"));
            double rating = Double.parseDouble(getContentDescriptionOfAnElement(product).substring(0, 3));
            if (!(rating >= Double.parseDouble(sortType))) {
                return false;
            }
        }
        else if(totalProducts>=2){
            performScrollToMovePage();
            List<WebElement> products=driver.findElements(By.xpath("//android.view.View[@content-desc='add to cart']/.."));
            for (WebElement product : products) {
                double rating = Double.parseDouble(getContentDescriptionOfAnElement(product).substring(0, 3));
                if (!(rating >= Double.parseDouble(sortType))){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void clicksOnFirstProduct() {
        firstProductInSearchedResults.click();
    }
}
