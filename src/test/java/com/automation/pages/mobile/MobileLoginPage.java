package com.automation.pages.mobile;

import com.automation.pages.ui.LoginPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileLoginPage extends MobileBasePage implements LoginPage {

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']")
    WebElement frameId;

    @FindBy(xpath = "//android.widget.Button[@content-desc='continue']/../..//android.widget.EditText")
    WebElement mobileNumberField;

    @FindBy(xpath = "//android.widget.Button[@content-desc='continue']/../android.widget.ImageView")
    WebElement bacKArrowButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"my profile\"]")
    WebElement myProfileButton;

    @Override
    public boolean verifyLoginPage() {
        //driver.switchTo().frame(frameId);
        return mobileNumberField.isDisplayed();
    }

    @Override
    public void enterMobileNumber(String phoneNoVal) {
        mobileNumberField.click();
        mobileNumberField.sendKeys(phoneNoVal);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isLoggedInSuccessfully() {
        myProfileButton.click();
        String loggedInMobileNo = "//android.view.View[contains(@content-desc,'%s')]";
        WebElement validLoggedIn = driver.findElement(By.xpath(String.format(loggedInMobileNo, ConfigReader.getConfigValue("valid.phoneNo"))));
        return validLoggedIn.isDisplayed();
    }
}
