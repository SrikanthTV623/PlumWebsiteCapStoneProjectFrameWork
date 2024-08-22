package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    WebDriverWait wait;
    List<String> keywords = new ArrayList<>();

    @FindBy(xpath = "//span[@class='flex']/img")
    WebElement plumLogo;

    @FindBy(id = "kp-login-button-header-logo")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@id='header-search']")
    WebElement searchBarField;

    public void openWebsite() {
        driver.get("https://plumgoodness.com/");
    }

    public boolean verifyHomePage() {
        return plumLogo.isDisplayed();
    }

    public void clickOnLoginButton() {
        loginBtn.click();
    }

    public void enterValueOnSearchBar(String searchValue) {
        searchBarField.sendKeys(searchValue);
        searchBarField.sendKeys(Keys.ENTER);
    }

    public void selectProductCategory(String productCategory) {
        String categoryXpath = "//li//summary//a[contains(text(),'%s')]";
        driver.findElement(By.xpath(String.format(categoryXpath, productCategory))).click();
    }


    public void selectProductFromDropDown(String productType) {
        String categoryXpath = "//a[contains(@href,'%s')]";
        WebElement product = driver.findElement(By.xpath(String.format(categoryXpath, productType)));
        scrollToElement(product);
        product.click();
    }

    public void selectSpecifiedProductFromDropDown(String specifiedProductType) {
        String productXpath = "//a[contains(text(),'%s')]";
        WebElement product = driver.findElement(By.xpath(String.format(productXpath, specifiedProductType)));
        scrollToElement(product);
        product.click();
    }

    public void gettingSearchValueFromTextFile(){
        String filePath = "src/test/resources/files/searchItems.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String keyword = line.trim();
                if (!keyword.isEmpty()) {
                    keywords.add(keyword);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void validateSearchResultsForSearchedItem(){
        for (String keyword : keywords) {
            searchBarField.clear();
            searchBarField.sendKeys(keyword);
            searchBarField.submit();

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='usf_container']//ul//li[1]//p[@class='card__title font-bold mb-1']/a")));
            String searchResultsText = searchResults.getText().toLowerCase();
            System.out.println(keyword);
            System.out.println(searchResultsText);
            Assert.assertTrue(searchResultsText.contains(keyword));
        }
    }
}
