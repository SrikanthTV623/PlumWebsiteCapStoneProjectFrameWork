package com.automation.pages.mobile;

import com.automation.pages.ui.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MobileHomePage extends MobileBasePage implements HomePage {

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
    WebElement allowNotificationPopUp;

    @FindBy(xpath = "//android.view.View[@content-desc='skip']")
    WebElement skipButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
    WebElement plumLogo;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='search ']")
    WebElement searchBoxField;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement searchBoxTxt;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='my profile']")
    WebElement profileLoginOptionBeforeLogin;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'trending at plum')]")
    WebElement trendingAtPlumForScroll;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='view more']")
    WebElement viewMoreButton;


    @Override
    public void openWebsite() {
        clickOnElementIfPresent(allowNotificationPopUp);
        clickOnElementIfPresent(skipButton);
    }

    @Override
    public boolean verifyHomePage() {
        return plumLogo.isDisplayed() && searchBoxField.isDisplayed();
    }

    @Override
    public void clickOnLoginButton() {

    }

    @Override
    public void clickOnLoginLogoBtn() {
        profileLoginOptionBeforeLogin.click();
    }

    @Override
    public void enterValueOnSearchBar(String searchValue) {
        searchBoxField.click();
        searchBoxTxt.click();
        searchBoxTxt.sendKeys(searchValue);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void selectProductCategory(String productCategory) {
        String productCategoryXpath = "//android.view.View[@content-desc='%s']";
        WebElement product = driver.findElement(By.xpath(String.format(productCategoryXpath, productCategory)));
        product.click();
    }

    @FindBy(xpath = "//android.widget.HorizontalScrollView")
    WebElement bestOfFragrances;

    @Override
    public void selectProductFromDropDown(String productType) {
        String productTypeXpath = "";
        if (productType.equals("orchid-you-not")) {
            performScrollTillElementVisible(bestOfFragrances);
            productTypeXpath = "//android.view.View[@content-desc='%s']";
        } else {
            //makeup-nails
            performScrollTillElementVisible(trendingAtPlumForScroll);
            productTypeXpath = "//android.widget.ImageView[@content-desc='experience the joy of']//following-sibling::android.view.View//android.view.View[@content-desc='%s']";
        }
        WebElement productCategory = driver.findElement(By.xpath(String.format(productTypeXpath, productType)));
        productCategory.click();
    }

    public void selectProductCategoryAndType(String productCategory, String productType) {
        String productCategoryXpath = "//android.view.View[@content-desc='%s']";
        WebElement productCategoryField = driver.findElement(By.xpath(String.format(productCategoryXpath, productCategory)));
        waitForElementToBeVisible(productCategoryField);
        productCategoryField.click();

        viewMoreButton.click();
        performScrollToMovePage();

        String productTypeXpath = "";
        if(productCategory.equals("haircare")){
            productTypeXpath = "//android.view.View[contains(@content-desc,'%s')]";
        }

        WebElement productTypeFormattedXpath = driver.findElement(By.xpath(String.format(productTypeXpath,productType)));
        productTypeFormattedXpath.click();
    }

    @Override
    public void selectSpecifiedProductFromDropDown(String specifiedProductType) {

    }

    List<String> keywords = new ArrayList<>();
    @Override
    public void gettingSearchValueFromTextFile() {
        String filePath = "src/test/resources/files/searchItems.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String keyword = line.trim();
                if (!keyword.isEmpty()) {
                    keywords.add(keyword);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void validateSearchResultsForSearchedItem() {
        for (String keyword : keywords) {
            searchBoxField.click();
            searchBoxTxt.click();
            searchBoxTxt.sendKeys(keyword);

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='usf_container']//ul//li[1]//p[@class='card__title font-bold mb-1']/a")));
            String searchResultsText = searchResults.getText().toLowerCase();
            System.out.println(keyword);
            System.out.println(searchResultsText);
            Assert.assertTrue(searchResultsText.contains(keyword));
        }
    }

    @Override
    public void clickOnOrderHistory() {

    }
}
