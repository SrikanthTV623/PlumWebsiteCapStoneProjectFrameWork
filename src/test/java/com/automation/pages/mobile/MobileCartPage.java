package com.automation.pages.mobile;

import com.automation.pages.ui.CartPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileCartPage extends MobileBasePage implements CartPage {

    @FindBy(xpath = "//android.view.View[@content-desc=\"view cart\"]")
    WebElement viewCartBtn;

    @FindBy(xpath = "//android.view.View[@content-desc=\"view cart\"]/..//android.view.View//android.widget.ImageView[@content-desc]")
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
        System.out.println(cartCount.getAttribute("content-desc"));
        return cartCount.getAttribute("content-desc");
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
