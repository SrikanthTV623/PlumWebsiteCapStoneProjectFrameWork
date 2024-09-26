package com.automation.pages.mobile;

import com.automation.pages.ui.ProductDescriptionPage;
import com.automation.utils.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MobileProductDescriptionPage extends MobileBasePage implements ProductDescriptionPage {

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='view cart']")
    WebElement viewCartBtn;

    @FindBy(xpath = "(//android.widget.ImageView[@content-desc='add to cart']/..//following-sibling::android.view.View)[last()]")
    WebElement firstProductWishlistBtn;

    @FindBy(xpath = "(//android.widget.ImageView[@content-desc='add to cart']/..//following-sibling::android.widget.ImageView)[3]")
    WebElement wishListBtnInProductListedScreen;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'write a review')]/..//following-sibling::android.view.View/android.view.View/android.view.View[1]")
    WebElement firstReview;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'write a review')]")
    WebElement writeReviewBtn;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'you are rating this product')]/android.widget.ImageView[6]")
    WebElement fiveStarRating;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'write a review')]/android.widget.EditText[1]")
    WebElement reviewTitle;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'write a review')]/android.widget.EditText[2]")
    WebElement review;

    @FindBy(xpath = "//android.view.View[@content-desc='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='rate a product']/following-sibling::android.view.View")
    WebElement reviewSuccessMsg;

    @Override
    public boolean productDescriptionPageDisplayed() {
        waitForElementToBeVisible(addToCartBtn);
        return addToCartBtn.isDisplayed();
    }

    @Override
    public void clickOnAddToCartBtn() {
        addToCartBtn.click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOnWishListBtn(){
        firstProductWishlistBtn.click();
    }

    public void clickOnWishListIcon(){
        wishListBtnInProductListedScreen.click();
    }

    public boolean verifyProductIsAddedToWishlist(String validateProductNameKey){
        WebElement searchValueProductInWishList = driver.findElement(By.xpath("(//android.view.View[@content-desc='add to cart']/..)[1]"));
        waitForElementToBeVisible(searchValueProductInWishList);
        return searchValueProductInWishList.isDisplayed();
    }

    @Override
    public void scrollAndClickOnWriteReviewButton() {
        performScrollTillElementVisible(firstReview);
        writeReviewBtn.click();
    }

    @Override
    public void addReviewData(List<String> reviewData) {
        fiveStarRating.click();
        reviewTitle.click();
        reviewTitle.sendKeys(ConfigReader.getConfigValue(reviewData.get(0)));
        review.click();
        review.sendKeys(ConfigReader.getConfigValue(reviewData.get(1)));
    }

    @Override
    public void clickOnSubmitReviewButton() {
        submitBtn.click();
    }

    @Override
    public String verifyReviewIsAdded() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return getContentDescriptionOfAnElement(reviewSuccessMsg);
    }
}
