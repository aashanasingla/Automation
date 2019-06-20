package com.gojek.amazon;

import com.gojek.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AmazonPage extends PageBase {

    private static String filePath = "/src/main/java/com/gojek/amazon/amazondomelements.json";

    private RemoteWebDriver driver;

    public AmazonPage(RemoteWebDriver driver) {
        super(filePath, driver);
        this.driver = driver;
    }

    public void clickOnAccountButton() {
        find("accountButton").click();
    }

    public boolean isSignInTextPresent() {
        boolean signinText = isElementPresent("signInText");
        return signinText;
    }

    public void enterEmailId(final String text) {
        enterText("emailId", text);
    }

    public void enterPassword(final String text) {
        enterText("password", text);
    }

    public void clickSubmit() {
        find("submit").click();
    }

    public boolean isSignedIn() {
        return isElementPresent("accounts");
    }

    public void clickSignOut() {
        Actions action = new Actions(driver);
        WebElement we = find("accounts");
        action.moveToElement(we).moveToElement(find("signOut")).click().build().perform();
    }

    public void clickElectronics() {
        Actions action = new Actions(driver);
        WebElement we = find("department");
        action.moveToElement(we).moveToElement(find("electronics")).click().build().perform();
    }

    public void clickheadphones() {
        find("headphones").click();
    }

    public void clickfirstHeadphone() {
        find("firstHeadphone").click();
    }

    public void clickAddToCart() {
        find("addToCart").click();
    }

    public boolean isproceedToCheckoutPresent() {
        return isElementPresent("proceedToCheckout");
    }

    public void clickOnSearchBar() {
        find("clickSearchBar").click();
    }

    public void inputOnSearchBar(String s) {
        enterText("clickSearchBar", s);
    }

    public void clickOnSearchButton() {
        find("clickOnSearch").click();
    }

    public void selectSecondElement() {
        find("selectSecondElement").click();
    }

    public void clickQuantity() {
        find("selectQuantity").click();
    }

    public void selectQuantity() {
        find("markItAs2").click();
    }

    public void clickOnCart() {
        find("viewCart").click();
    }

    public boolean isShoppingCartPresent() {
        return find("shoppingCart").isDisplayed();
    }

    public void deleteFirstProduct() {
        find("delete").click();
    }

    public void clickSecondProductQuantity() {
        find("changeQuantity").click();
    }

    public void changeQuantity() {
        find("changeNumber").click();
    }

    public boolean isProductDeleted() {
        return isElementPresent("productDeleted");
    }

    public boolean isQuantitChanged() {
        return isElementPresent("verifyQuantity");
    }

}
