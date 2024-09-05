package com.automation.pages.mobile;

import com.automation.pages.ui.CheckOutPage;
import com.automation.pages.web.WebAccountPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileCheckOutPage extends MobileBasePage implements CheckOutPage {

    @FindBy(xpath = "//android.widget.EditText")
    WebElement phoneNoTxt;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'hello')]")
    WebElement helloTxtDisplayedInPage;

    @FindBy(xpath = "//android.view.View[@content-desc='cash on delivery']")
    WebElement cashOnDeliveryOption;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'full name')]/android.widget.EditText[1]")
    WebElement fullNameField;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'email')]/android.widget.EditText[2]")
    WebElement emailIdField;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]")
    WebElement dateOfBirthField;

    @FindBy(xpath = "//android.view.View[@content-desc]/android.view.View/android.widget.Button")
    WebElement dateOfBirthChangeIcon;

    @FindBy(xpath = "//android.widget.EditText[@text]")
    WebElement dateOfBirthTxt;

    @FindBy(xpath = "//android.widget.Button[@content-desc='okay']")
    WebElement dobOkayBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='male']")
    WebElement gender;

    @FindBy(xpath = "//android.widget.Button[@content-desc='continue']")
    WebElement continueBtnInCheckOut;




    @Override
    public void enterPhoneNo() {
        phoneNoTxt.click();
        phoneNoTxt.sendKeys(ConfigReader.getConfigValue("valid.phoneNo"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void enterRequiredDetails() {
        try{
            fullNameField.clear();
            fullNameField.sendKeys(ConfigReader.getConfigValue("full.name"));
            emailIdField.sendKeys(ConfigReader.getConfigValue("email.id"));
            dateOfBirthField.click();
            dateOfBirthChangeIcon.click();
            dateOfBirthTxt.sendKeys(ConfigReader.getConfigValue("date.of.birth"));
            dobOkayBtn.click();
            gender.click();
            continueBtnInCheckOut.click();
        }catch (Exception ignored){}
    }

    @Override
    public boolean isPaymentOptionDisplayed() {
        return cashOnDeliveryOption.isDisplayed();
    }

    @Override
    public void selectCashOnDelivery() {

    }

    @Override
    public boolean verifyOrderIsPlaced() {
        return false;
    }

    @Override
    public void storeOrderId(String orderId) {

    }

    @Override
    public void navigateToHomePage() {

    }
}
