package com.automation.pages;


import com.automation.utils.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ItemsDescriptionPage extends BasePage {

    @FindBy(xpath = "//h1[@class='product-title h5']")
    WebElement itemDescriptionTxt;

    @FindBy(xpath = "//button[@class='btn btn--secondary w-full']")
    WebElement addToCartBtn;

    public void clickOnAddToCartBtn() {
        scrollToElement(addToCartBtn);
        addToCartBtn.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean itemDescriptionPageDisplayed() {
        return itemDescriptionTxt.isDisplayed() && addToCartBtn.isDisplayed();
    }

    @FindBy(xpath = "//a[@class='jdgm-write-rev-link']")
    WebElement writeReviewBtn;

    public void scrollAndClickOnWriteReviewButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 2000);");
        writeReviewBtn.click();
    }

    @FindBy(xpath = "//input[@aria-label='REVIEW TITLE']")
    WebElement reviewTitle;

    @FindBy(xpath = "//textarea[@aria-label='REVIEW']")
    WebElement review;

    @FindBy(xpath = "//input[@aria-label='Name']")
    WebElement name;

    @FindBy(xpath = "//input[@aria-label='Email']")
    WebElement email;

    @FindBy(xpath = "//a[contains(@class,'jdgm-cancel-rev ')]/following-sibling::input")
    WebElement submitReviewBtn;

    public void addReviewData(List<String> reviewData) {

        String ratingXpath="//span[@class='jdgm-form__rating']//a[@data-alt='%s']";
        WebElement stars=driver.findElement(By.xpath(String.format(ratingXpath,ConfigReader.getConfigValue(reviewData.get(0)))));
        jsClick(stars);

        reviewTitle.sendKeys(ConfigReader.getConfigValue(reviewData.get(1)));

        review.sendKeys(ConfigReader.getConfigValue(reviewData.get(2)));

        name.sendKeys(ConfigReader.getConfigValue(reviewData.get(3)));

        email.sendKeys(ConfigReader.getConfigValue(reviewData.get(4)));

    }

    public void clickOnSubmitReviewButton() {
        submitReviewBtn.click();
    }

    @FindBy(xpath = "(//div[@class='jdgm-rev-widg__reviews']/div//span[@class='jdgm-rev__author'])[1]")
    WebElement userName;

    public String verifyReviewIsAdded() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return userName.getText();
    }
}
