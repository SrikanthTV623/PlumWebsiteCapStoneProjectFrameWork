package com.automation.pages.mobile;

import com.automation.pages.ui.ProductDescriptionPage;
import com.automation.pages.web.WebLoginPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MobileProductDescriptionPage extends MobileBasePage implements ProductDescriptionPage {

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='add to cart']/..//android.view.View[@content-desc]")
    WebElement itemDescriptionTxt;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='view cart']")
    WebElement viewCartBtn;

    @Override
    public boolean productDescriptionPageDisplayed() {
        waitForElementToBeVisible(itemDescriptionTxt);
        waitForElementToBeVisible(addToCartBtn);
        return itemDescriptionTxt.isDisplayed() && addToCartBtn.isDisplayed();
    }

    @Override
    public void clickOnAddToCartBtn() {
        addToCartBtn.click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        /*
        if (ConfigReader.getConfigValue("application.type").equals("mobile")) {
            viewCartBtn.click();
        }

         */
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
