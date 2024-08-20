package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;
import java.util.List;

public class StoreLocatorPage extends BasePage{

    @FindBy(xpath = "//div[@class='page_header']//h1")
    WebElement pageHeading;
    public String verifyPage() {
        return pageHeading.getText();

    }


    public void selectCity(String cityName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");
        String cityXpath="//div[@class='progus-store-locator-tags-container']//span[text()='Mumbai']/../input";
        WebElement city=driver.findElement(By.xpath(String.format(cityXpath,cityName)));
        city.click();
    }

    @FindBy(xpath = "//div[@id='progus-store-locator-store-list-elements']//span//div[@class='progus-store-locator-popup-element-content']")
    List<WebElement> listOfStores;
    public void printStoreLocations() {
        for (WebElement store:listOfStores){
            System.out.println(store.getText());
        }
    }
}
