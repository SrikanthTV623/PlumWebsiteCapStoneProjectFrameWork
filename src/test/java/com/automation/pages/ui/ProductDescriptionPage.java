package com.automation.pages.ui;

import java.util.List;

public interface ProductDescriptionPage {
    boolean productDescriptionPageDisplayed();

    void clickOnAddToCartBtn();

    void scrollAndClickOnWriteReviewButton();

    void addReviewData(List<String> reviewData);

    void clickOnSubmitReviewButton();

    String verifyReviewIsAdded();

    default void clickOnWishListBtn(){

    }

    default void clickOnWishListIcon(){

    }

    default boolean verifyProductIsAddedToWishlist(String validateProductNameKey){
        return false;
    }
}
