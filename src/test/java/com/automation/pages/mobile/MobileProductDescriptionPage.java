package com.automation.pages.mobile;

import com.automation.pages.ui.ProductDescriptionPage;

import java.util.List;

public class MobileProductDescriptionPage implements ProductDescriptionPage {
    @Override
    public boolean productDescriptionPageDisplayed() {
        return false;
    }

    @Override
    public void clickOnAddToCartBtn() {

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
