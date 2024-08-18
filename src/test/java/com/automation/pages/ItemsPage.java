package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemsPage extends BasePage{

    @FindBy(xpath = "//div[@id='usf_container']//ul//li[1]")
    WebElement itemFieldClick;

    @FindBy(xpath = "//div[@class='header__icons flex justify-end mis-auto js-closes-menu']/a[3]")
    WebElement shoppingCartIcon;


    public void clicksOnItem() {
        itemFieldClick.click();
    }

    public void clickOnShoppingCartIcon() {
        shoppingCartIcon.click();
    }
}
