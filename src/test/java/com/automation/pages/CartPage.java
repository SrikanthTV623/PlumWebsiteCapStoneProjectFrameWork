package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//tr[@id='cart-item-1']/td[2]/a")
    WebElement cartContentsTxt;

    @FindBy(xpath = "//a[@aria-label='Remove']")
    WebElement removeBtn;

    @FindBy(xpath = "//div[@id='cart-icon-bubble']/div/span")
    WebElement cartCount;

    @FindBy(xpath = "//cart-items[@id='cart-items']/div/p")
    WebElement cartEmptyTxt;

    @FindBy(xpath = "//dd[@class='price__current inline m-0 font-bold']/span")
    List<WebElement> priceOfIndividualItem;

    @FindBy(xpath = "//div[@class='total_cc']/span")
    WebElement totalCartPrice;

    @FindBy(xpath = "//div[@class='gokwik-checkout']")
    WebElement checkOutBtn;

    @FindBy(xpath = "//input[@id='pincode_input_cart']")
    WebElement enterPinCodeTxtInCart;

    @FindBy(xpath = "//p[@class='expected_cart']")
    WebElement deliveryMessage;

    public boolean cartContentsIsDisplayed() {
        return cartContentsTxt.isDisplayed();
    }

    public void clickOnRemoveButton() {
        removeBtn.click();
    }

    public String getCartContentText() {
        return cartContentsTxt.getText();
    }

    public String takesCartCount() {
        return cartCount.getText();
    }

    public String sendCartEmptyText() {
        return cartEmptyTxt.getText();
    }

    public boolean validatingTheCartPriceIsMatchingWithCalculatedPrice() {

        double caluclatedTotalCartValue = 0;
        for (WebElement price : priceOfIndividualItem) {
            caluclatedTotalCartValue = caluclatedTotalCartValue + Double.parseDouble(price.getText().split("\\₹")[1]);
        }

        String totalCartValueTxt = totalCartPrice.getText().split("\\₹")[1];
        double totalCartValueOnWeb = Double.parseDouble(parsePrice(totalCartValueTxt));

        System.out.println("Price on Web===" + totalCartValueOnWeb);
        System.out.println("Price after calculation===" + caluclatedTotalCartValue);

        return totalCartValueOnWeb == caluclatedTotalCartValue;
    }

    public String parsePrice(String priceText) {
        // Remove commas
        priceText = priceText.replace(",", "");

        return priceText;
    }

    public void clicksOnCheckOutButton() {
        checkOutBtn.click();
    }

    public void enterPinCodeText(String pinCodeTxt) {
        enterPinCodeTxtInCart.sendKeys(pinCodeTxt);
    }

    public String findPinCodeIsValidOrNot() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String validationMessageTxt = deliveryMessage.getText().toLowerCase().split("\n")[0];
        System.out.println(validationMessageTxt);

        return validationMessageTxt;
    }

    /*
    //p[@class='expected_cart' and (text()='Delivery by ' or text()='Enter a valid pincode')]

    public String findPinCodeIsValidOrNot() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement deliveryMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Delivery by ' or text()='Enter a valid pincode']"))); // Adjust selector as needed

        String validationMessageTxt = deliveryMessage.getText().toLowerCase().split("\n")[0];
        System.out.println(validationMessageTxt);

        return validationMessageTxt;
    }

     */

}
