package com.automation.pages.web;

import com.automation.pages.ui.StoreLocatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        scrollToSpecificAmount();
        driver.switchTo().frame(iframe);
        String cityXpath = "//div[@class='progus-store-locator-tags-container']//span[text()='%s']/../input";
        WebElement city = driver.findElement(By.xpath(String.format(cityXpath, cityName)));
        jsClick(city);
    }

    public void printStoreLocations() {
        // Wait for elements to be present
        List<WebElement> listOfStores = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='progus-store-locator-store-list-elements']//span//div[@class='progus-store-locator-popup-element-content']")));

        for (WebElement store : listOfStores) {
            try {
                System.out.println(store.getText());
            } catch (StaleElementReferenceException e) {
                // Handle stale element reference exception
                System.out.println("Encountered stale element reference: " + e.getMessage());
            }
        }
    }
}
