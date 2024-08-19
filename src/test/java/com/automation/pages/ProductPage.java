package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductPage extends BasePage{
    @FindBy(xpath = "//h1[@class='collection-banner__heading mb-0 inline']")
    WebElement productPageHeading;

    @FindBy(xpath = "//button[@class='usf-c-select__input-value usf-btn']")
    WebElement sortBy;

    //all products which includes sold out products too
    //@FindBy(xpath = "//p[@class='card__title font-bold mb-1']/a")

    //all products which excludes sold out products
    @FindBy(xpath = "//span[@class='quick-add-btn-text'][text()='Add to cart']//ancestor::div[@class='card__info-container flex flex-col flex-auto relative']//a[contains(@class,'text-current ')]")
    List<WebElement> productList;

    public boolean verifySelectedProductPage() {
        return productPageHeading.isDisplayed();
    }

    public void clickOnSortBy(){
        sortBy.click();
    }

    public void sortBy(String sortByKey) {
        String sortByXpath="//div[@class='usf-c-select__list']/button[contains(text(),'%s')]";
        driver.findElement(By.xpath(String.format(sortByXpath, ConfigReader.getConfigValue(sortByKey)))).click();
    }

    public boolean verifyProductsSortedATOZ() {
        List<String> productNames=new ArrayList<>();
        for(WebElement product:productList){
            productNames.add(product.getText());
        }
        List<String> collectionsSort=new ArrayList<>(productNames);
        Collections.sort(collectionsSort);
        System.out.println(productNames+"\n"+collectionsSort);
        if(productNames.equals(collectionsSort)){
            return true;
        }
        return false;
    }

    public boolean verifyProductsSortedZTOA() {
        List<String> productNames=new ArrayList<>();
        for(WebElement product:productList){
            productNames.add(product.getText());
        }

        List<String> collectionsSort = productNames.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(productNames+"\n"+collectionsSort);

        if(productNames.equals(collectionsSort)){
            return true;
        }
        return false;
    }

    public void printProductList() {
        List<String> productNames=new ArrayList<>();
        for(WebElement product:productList){
            productNames.add(product.getText());
        }
        System.out.println(productNames);
    }

    public boolean verifyProductName(String productName) {
        for(WebElement product:productList){
            String individualProductName=product.getText();
            System.out.println(individualProductName);
            if(!individualProductName.contains(productName)){
                return false;
            }
        }
        return true;
    }
}
