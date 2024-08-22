package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage extends BasePage{

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @FindBy(xpath = "//div[text()='Order Cancellation ']")
    WebElement orderCancellation;
    public boolean verifyPage() {
        return orderCancellation.isDisplayed();
    }

    public void clickOnOrderCancellation() {
        orderCancellation.click();
    }

    @FindBy(xpath = "//input[@id='order_id']")
    WebElement orderIdField;
    @FindBy(xpath = "//input[@id='cno']")
    WebElement phoneNoField;
    public void enterOrderCancellationDetails(String orderId, String phoneNo) {
        orderIdField.sendKeys(orderId);
        phoneNoField.sendKeys(phoneNo);
    }

    @FindBy(xpath = "//select[@id='cancellation_reason']")
    WebElement selectReason;
    public void setReasonForOrderCancellation(String reason) {
        Select select=new Select(selectReason);
        select.selectByVisibleText(reason);
    }

    @FindBy(xpath = "//button[@class='btn'][text()='Cancel']")
    WebElement cancelBtn;
    public void clickOnCancelButton() {
        cancelBtn.click();
    }

    @FindBy(xpath = "//button[@id='submit_bt']")
    WebElement yesBtn;
    public void confirmCancellation() {
        yesBtn.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='order-cancellation']//div[@id='text-error-after-cancel']")));
    }

    public String verifyOrderCancellation() {
        WebElement orderCancellationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='order-cancellation']//div[@id='text-error-after-cancel']")));
        System.out.println(orderCancellationMsg.getText());
        return orderCancellationMsg.getText();
    }
}
