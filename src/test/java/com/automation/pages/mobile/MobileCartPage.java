package com.automation.pages.mobile;

import com.automation.pages.ui.CartPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(xpath = "//android.view.View[@content-desc=\"cart\"]/following-sibling::android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[@content-desc]")
    List<WebElement> individualProductDescriptionTexts;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'delivery address')]")
    WebElement deliveryAddressField;

    //@FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'apply coupon')]//following-sibling::android.widget.EditText")
    @FindBy(xpath = "//android.widget.EditText")
    WebElement checkDeliveryPinCodeTxt;

    @FindBy(xpath = "//android.view.View[@content-desc='check']")
    WebElement checkButtonClickForPinCode;

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
        double totalCalculatedPrice = calculateTotalPriceFromProductList(individualProductDescriptionTexts);
        System.out.println("totalCalculatedPrice: "+totalCalculatedPrice);

        performScrollTillElementVisible(orderSummaryField);
        performScrollToMovePage();

        String cartSummaryTxt = getContentDescriptionOfAnElement(orderSummaryField);

        double itemMRP = extractValueFromOrderSummaryText(cartSummaryTxt, "total item mrp");
        double discount = extractValueFromOrderSummaryText(cartSummaryTxt, "discount");
        double tierDiscount = extractValueFromOrderSummaryText(cartSummaryTxt, "tier discount");
        double shippingFee = extractValueFromOrderSummaryText(cartSummaryTxt, "shipping fee");
        double toPayPriceDisplayedInApp = extractValueFromOrderSummaryText(cartSummaryTxt, "to pay");

        System.out.println("itemMRP: "+itemMRP);
        System.out.println("discount: "+discount);
        System.out.println("tierDiscount: "+tierDiscount);
        System.out.println("shippingFee: "+shippingFee);
        System.out.println("toPayPriceDisplayedInApp: "+toPayPriceDisplayedInApp);

        double expectedToPay = itemMRP - discount - tierDiscount + shippingFee;

        System.out.println("Calculated expected To Pay: "+expectedToPay);

        return totalCalculatedPrice==toPayPriceDisplayedInApp && toPayPriceDisplayedInApp==expectedToPay;
    }


    /*
    public double calculateTotalPriceFromProductList(WebElement element) {
        double total = 0.0;

        for (WebElement description : individualProductDescriptionTexts) {
            String text = description.getText();
            double price = extractPriceFromProductDescription(text);
            total += price;
        }

        return total;
    }

    private double extractPriceFromProductDescription(String text) {
        // Example description: "Green Tea Day-Light Sunscreen Gel SPF 35 PA+++ \n₹474.00 \n₹575.00 \n you save ₹101.00"
        Pattern pattern = Pattern.compile("₹([0-9,.]+)");
        Matcher matcher = pattern.matcher(text);

        double price = 0.0;
        if (matcher.find()) {
            price = Double.parseDouble(matcher.group(1).replace(",", ""));
        }
        return price;
    }

     */

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
        //performScrollToMovePage();
        performScrollTillElementVisible(deliveryAddressField);
        checkDeliveryPinCodeTxt.click();
        checkDeliveryPinCodeTxt.sendKeys(pinCodeTxt);
    }

    @Override
    public String findPinCodeIsValidOrNot() {
        checkButtonClickForPinCode.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(checkDeliveryPinCodeTxt.getAttribute("hint"));
        String deliveryEstimatedTime = checkDeliveryPinCodeTxt.getAttribute("hint");
        return deliveryEstimatedTime;
    }
}
