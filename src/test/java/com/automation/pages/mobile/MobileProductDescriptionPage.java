package com.automation.pages.mobile;

import com.automation.pages.ui.ProductDescriptionPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MobileProductDescriptionPage extends MobileBasePage implements ProductDescriptionPage {

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='add to cart']/..//android.view.View[@content-desc]")
    WebElement itemDescriptionTxt;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
    WebElement navigateBackProductListedPage;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")
    WebElement searchOptionInProductListedPage;

    @Override
    public boolean productDescriptionPageDisplayed() {
        return itemDescriptionTxt.isDisplayed() && addToCartBtn.isDisplayed();
    }

    @Override
    public void clickOnAddToCartBtn() {
        addToCartBtn.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        navigateBackProductListedPage.click();
        searchOptionInProductListedPage.click();
    }

    @Override
    public void scrollAndClickOnWriteReviewButton() {

    }

    @Override
    public void addReviewData(List<String> reviewData) {

    }

    @Override
    public void clickOnSubmitReviewButton() {

    }

    @Override
    public String verifyReviewIsAdded() {
        return "";
    }
}
