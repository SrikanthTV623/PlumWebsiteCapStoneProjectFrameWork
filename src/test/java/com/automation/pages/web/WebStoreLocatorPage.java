package com.automation.pages.web;

import com.automation.pages.ui.StoreLocatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebStoreLocatorPage extends WebBasePage implements StoreLocatorPage {

    @FindBy(xpath = "//div[@class='page_header']//h1")
    WebElement pageHeading;

    @FindBy(xpath = "//div[@id='progus-store-locator']/iframe")
    WebElement iframe;

    @FindBy(xpath = "//div[@id='progus-store-locator-store-list-elements']//span//div[@class='progus-store-locator-popup-element-content']")
    List<WebElement> listOfStores;

    public String verifyPage() {
        return pageHeading.getText();

    }

    public void selectCity(String cityName) {
        driver.switchTo().frame(iframe);
        String cityXpath = "//div[@class='progus-store-locator-tags-container']//span[text()='%s']/../input";
        WebElement city = driver.findElement(By.xpath(String.format(cityXpath, cityName)));
        jsClick(city);
    }

    public void printStoreLocations() {
        for (WebElement store : listOfStores) {
            System.out.println(store.getText());
        }
    }
}