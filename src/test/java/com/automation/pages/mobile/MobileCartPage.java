package com.automation.pages.mobile;

import com.automation.pages.ui.CartPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileCartPage extends MobileBasePage implements CartPage {

    //@FindBy(xpath = "//android.view.View[@content-desc=\"view cart\"]/..//android.view.View//android.widget.ImageView[@content-desc]")
    @FindBy(xpath = "//android.view.View[@content-desc='cart']/following-sibling::android.view.View[1]")
    WebElement cartCount;

    @FindBy(xpath = "//android.view.View[@content-desc=\"cart\"]//following-sibling::android.view.View/android.view.View//android.view.View[@content-desc][1]")
    WebElement cartContentField;

    @FindBy(xpath = "(//android.view.View[@content-desc=\"1\"])[1]//following-sibling::android.widget.ImageView")//android.view.View[@content-desc="cart"]//following-sibling::android.view.View/android.view.View//android.view.View[@content-desc][1]
    WebElement removeIcon;

    @FindBy(xpath = "//android.view.View[@content-desc='remove']")
    WebElement removeButtonInDialogBox;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'order summary')]")
    WebElement orderSummaryField;

    @FindBy(xpath = "//android.view.View[@content-desc='checkout']")
    WebElement checkOutBtn;

    @Override
    public boolean cartContentsIsDisplayed() {
        return cartContentField.isDisplayed();
    }

    @Override
    public void clickOnRemoveButton() {
        removeIcon.click();
        removeButtonInDialogBox.click();
    }

    @Override
    public String getCartContentText(String removedProductName) {
        String cartContextTxtDisplayed = "//android.view.View[contains(@content-desc,'%s')]";
        return cartContextTxtDisplayed;
    }

    @Override
    public String takesCartCount() {
        String cartCountNumberText = getContentDescriptionOfAnElement(cartCount);
        return cartCountNumberText;
    }

    @Override
    public String sendCartEmptyText() {
        return "";
    }

    @Override
    public boolean validatingTheCartPriceIsMatchingWithCalculatedPrice() {
        performScrollTillElementVisible(orderSummaryField);
        performScrollToMovePage();
        return false;
    }

    @Override
    public String parsePrice(String priceText) {
        return "";
    }

    @Override
    public void clicksOnCheckOutButton() {
        checkOutBtn.click();
    }

    @Override
    public void enterPinCodeText(String pinCodeTxt) {

    }

    @Override
    public String findPinCodeIsValidOrNot() {
        return "";
    }
}
