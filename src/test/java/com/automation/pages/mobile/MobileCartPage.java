package com.automation.pages.mobile;

import com.automation.pages.ui.CartPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileCartPage extends MobileBasePage implements CartPage {

    @FindBy(xpath = "//android.view.View[@content-desc='view cart']")
    WebElement viewCartBtn;

    //@FindBy(xpath = "//android.view.View[@content-desc=\"view cart\"]/..//android.view.View//android.widget.ImageView[@content-desc]")
    @FindBy(xpath = "//android.view.View[@content-desc='cart']/following-sibling::android.view.View[1]")
    WebElement cartCount;

    @Override
    public boolean cartContentsIsDisplayed() {
        return false;
    }

    @Override
    public void clickOnRemoveButton() {

    }

    @Override
    public String getCartContentText() {
        return "";
    }

    @Override
    public String takesCartCount() {
        //System.out.println(cartCount.getAttribute("content-desc"));
        String cartCountNumberText = getContentDescriptionOfAnElement(cartCount);
        return cartCountNumberText;
        //return cartCount.getAttribute("content-desc");
    }

    public String getCartCountDescription() {
        // Ensure the element is displayed and enabled before getting the attribute
        if (cartCount.isDisplayed() && cartCount.isEnabled()) {
            String contentDesc = cartCount.getAttribute("content-desc");
            System.out.println("Content-desc: " + contentDesc);
            return contentDesc;
        } else {
            throw new RuntimeException("Element is not displayed or enabled.");
        }
    }


    @Override
    public String sendCartEmptyText() {
        return "";
    }

    @Override
    public boolean validatingTheCartPriceIsMatchingWithCalculatedPrice() {
        return false;
    }

    @Override
    public String parsePrice(String priceText) {
        return "";
    }

    @Override
    public void clicksOnCheckOutButton() {

    }

    @Override
    public void enterPinCodeText(String pinCodeTxt) {

    }

    @Override
    public String findPinCodeIsValidOrNot() {
        return "";
    }
}
