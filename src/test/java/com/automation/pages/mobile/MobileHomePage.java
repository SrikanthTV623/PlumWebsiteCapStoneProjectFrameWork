package com.automation.pages.mobile;

import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MobileHomePage extends MobileBasePage implements HomePage {

    public static List<String> keywords = new ArrayList<>();

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
    WebElement allowNotificationPopUp;

    @FindBy(xpath = "//android.view.View[@content-desc='skip']")
    WebElement skipButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
    WebElement plumLogo;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='search ']")
    WebElement searchBoxField;

    @FindBy(xpath = "//android.view.View[@content-desc='home']")
    WebElement homeLogo;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement searchBoxTxt;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[5]")
    WebElement wishListBtn;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'my profile')]")
    WebElement profileLoginOptionBeforeLogin;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'trending at plum')]")
    WebElement trendingAtPlumForScroll;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='view more']")
    WebElement viewMoreButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='shop']")
    WebElement shopButton;

    @FindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'shop by concern')]")
    WebElement shopOnConcernInShop;

    @FindBy(xpath = "//android.widget.HorizontalScrollView")
    WebElement bestOfFragrances;

    @FindBy(xpath = "//android.view.View[@content-desc=\"super deals\"]")
    WebElement superDealsInWishListScreen;

    @FindBy(xpath = "(//android.view.View[@content-desc='add to cart']/..)[1]/android.view.View[2]")
    WebElement firstProductWishListButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='find product']")
    WebElement findProductBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='looking for']/android.widget.Button")
    WebElement productTypeDropdownBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='i have']/android.widget.Button")
    WebElement concernDropdownBtn;

    @Override
    public void openWebsite() {
        clickOnElementIfPresent(allowNotificationPopUp);
        clickOnElementIfPresent(skipButton);
    }

    @Override
    public boolean verifyHomePage() {
        waitForElementToBeVisible(searchBoxField);
        waitForElementToBeVisible(homeLogo);
        return searchBoxField.isDisplayed() && homeLogo.isDisplayed();
    }


    @Override
    public void clickOnLoginLogoBtn() {
        driver.findElement(By.xpath("//android.widget.ImageView[contains(@content-desc,'my profile')]")).click();
        //profileLoginOptionBeforeLogin.click();
    }

    @Override
    public void enterValueOnSearchBar(String searchValue) {
        searchBoxField.click();
        searchBoxTxt.click();
        searchBoxTxt.sendKeys(searchValue);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void selectProductCategory(String productCategory) {
        String productCategoryXpath = "//android.view.View[@content-desc='%s']";
        WebElement product = driver.findElement(By.xpath(String.format(productCategoryXpath, productCategory)));
        waitForElementToBeVisible(product);
        product.click();
    }

    @Override
    public void selectProductFromDropDown(String productType) {
        String productTypeXpath = "";
        if (productType.equals("orchid-you-not")) {
            performScrollTillElementVisible(bestOfFragrances);
            productTypeXpath = "//android.view.View[@content-desc='%s']";
        } else if (productType.equals("beard")) {
            productTypeXpath = "//android.view.View[contains(@content-desc,'%s')]";
        } else if(productType.equals("nails")){
            //makeup-nails
            performScrollTillElementVisible(trendingAtPlumForScroll);
            productTypeXpath = "//android.widget.ImageView[@content-desc='experience the joy of']//following-sibling::android.view.View//android.view.View[@content-desc='%s']";
        }else if (productType.equals("hair mask")){
            productTypeXpath = "//android.view.View[contains(@content-desc,'%s')]";
        }
        WebElement productCategory = driver.findElement(By.xpath(String.format(productTypeXpath, productType)));
        productCategory.click();
    }

    public void selectProductCategoryAndType(String productCategory, String productType) {
        String productCategoryXpath = "//android.view.View[@content-desc='%s']";
        WebElement productCategoryField = driver.findElement(By.xpath(String.format(productCategoryXpath, productCategory)));
        waitForElementToBeVisible(productCategoryField);
        productCategoryField.click();

        viewMoreButton.click();
        performScrollToMovePage();

        String productTypeXpath = "";
        if (productCategory.equals("haircare")) {
            productTypeXpath = "//android.view.View[contains(@content-desc,'%s')]";
        } else if (productCategory.equals("bodycare")) {
            productTypeXpath = "//android.view.View[contains(@content-desc,'%s')]";
        }

        WebElement productTypeFormattedXpath = driver.findElement(By.xpath(String.format(productTypeXpath, productType)));
        productTypeFormattedXpath.click();
    }

    @Override
    public void gettingSearchValueFromTextFile() {
        String filePath = "src/test/resources/files/searchItems.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String keyword = line.trim();
                if (!keyword.isEmpty()) {
                    keywords.add(keyword);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void validateSearchResultsForSearchedItem() {
        for (String keyword : keywords) {
            searchBoxField.click();
            searchBoxTxt.click();
            searchBoxTxt.sendKeys(keyword);
            ConfigReader.setConfigValue("keywordKey", keyword);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            WebElement firstProduct = driver.findElement(By.xpath("(//android.view.View[@content-desc='add to cart']/..)[1]"));
            String contentDes = getContentDescriptionOfAnElement(firstProduct).toLowerCase();
            String searchedProduct = ConfigReader.getConfigValue("keywordKey");
            System.out.println(contentDes);
            System.out.println(searchedProduct);
            System.out.println();
            Assert.assertTrue(contentDes.contains(searchedProduct));
            plumLogo.click();
        }
    }

    public void selectsFirstProductAndAddedToWishlist() {
        for (String keyword : keywords) {
            for (int i = 1; i <= 5; i++) {
                searchBoxField.click();
                searchBoxTxt.click();
                searchBoxTxt.sendKeys(keyword);
                ConfigReader.setConfigValue("searchedValueKey", keyword);
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                WebElement clicksFirstProductWishlistBtn = driver.findElement(By.xpath("(//android.view.View[@content-desc='add to cart']/..)[1]/android.view.View[2]"));
                tapOnElementByXPath(clicksFirstProductWishlistBtn);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                wishListBtn.click();
                if (i == 3) {
                    performScrollTillElementVisible(superDealsInWishListScreen);
                }
                WebElement searchValueProductInWishList = driver.findElement(By.xpath("(//android.view.View[@content-desc='add to cart']/..)[" + i + "]"));
                waitForElementToBeVisible(searchValueProductInWishList);
                String contentDesOfProduct = getContentDescriptionOfAnElement(searchValueProductInWishList).toLowerCase();
                String searchedProductName = ConfigReader.getConfigValue("searchedValueKey");
                System.out.println(contentDesOfProduct);
                System.out.println(searchedProductName);
                System.out.println("======================================================");
                Assert.assertTrue(contentDesOfProduct.contains(searchedProductName));
                WebElement navigateBackFromWishlistPage = driver.findElement(By.xpath("//android.view.View[@content-desc='my wishlist']/../android.widget.ImageView[1]"));
                navigateBackFromWishlistPage.click();
                plumLogo.click();
            }
        }
    }

    @Override
    public void clickOnSearchToNavigateToProductFinder() {
        searchBoxField.click();
    }

    @Override
    public void selectConcernFromDropDown(String concern) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        concernDropdownBtn.click();
        clickOnDropDown(concern);
    }

    public void clickOnDropDown(String dropdownEle) {
        List<WebElement> concernDropDown = driver.findElements(By.xpath("//android.view.View/android.view.View/android.view.View/android.view.View[@content-desc]"));
        List<String> concernDropDownNames = concernDropDown.stream().map(ele -> ele.getAttribute("content-desc")).toList();
        System.out.println(concernDropDownNames);
        while (true) {
            if (concernDropDownNames.contains(dropdownEle)) {
                driver.findElement(By.xpath("//android.view.View/android.view.View/android.view.View/android.view.View[@content-desc='" + dropdownEle + "']")).click();
                break;
            } else {
                int x = concernDropDown.get(concernDropDown.size() - 1).getLocation().getX() + concernDropDown.get(concernDropDown.size() - 1).getSize().getWidth() / 2;
                int y = concernDropDown.get(concernDropDown.size() - 1).getLocation().getY();

                scrollOrSwipe(x, y, x, y - 500);
                concernDropDown = driver.findElements(By.xpath("//android.view.View/android.view.View/android.view.View/android.view.View[@content-desc]"));
                concernDropDownNames = concernDropDown.stream().map(ele -> ele.getAttribute("content-desc")).toList();
                System.out.println(concernDropDownNames);
            }
        }
    }

    @Override
    public void selectProductTypeFromDropDown(String productType) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productTypeDropdownBtn.click();
        clickOnDropDown(productType);
    }

    @Override
    public void clickOnFindProduct() {
        findProductBtn.click();
    }

    public void clickOnShopButton(String scrollElementName) {
        shopButton.click();
        if (scrollElementName.contains("shopOnConcern")) {
            performScrollTillElementVisible(shopOnConcernInShop);
        }
    }
}
