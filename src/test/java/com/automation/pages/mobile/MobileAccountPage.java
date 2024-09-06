package com.automation.pages.mobile;

import com.automation.pages.ui.AccountPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileAccountPage extends MobileBasePage implements AccountPage {

    @Override
    public boolean verifyPage() {
        return false;
    }

    @Override
    public void clickOnOrderCancellation() {

    }

    @Override
    public void enterOrderCancellationDetails(String orderId, String phoneNo) {

    }

    @Override
    public void setReasonForOrderCancellation(String reason) {

    }

    @Override
    public void clickOnCancelButton() {

    }

    @Override
    public void confirmCancellation() {

    }

    @Override
    public String verifyOrderCancellation() {
        return "";
    }

     @FindBy(xpath = "//android.view.View[@content-desc='edit profile']/../android.view.View[1]")
     WebElement username;
    @Override
    public void storeTheUserName(String usernameKey) {
        ConfigReader.setConfigValue(usernameKey,getContentDescriptionOfAnElement(username));
        System.out.println(ConfigReader.getConfigValue(usernameKey));
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='home']")
    WebElement homeBtn;
    @Override
    public void navigateToHomePage() {
        homeBtn.click();
    }
}
