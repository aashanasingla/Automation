package com.gojek;

import com.gojek.amazon.AmazonPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Reporting.class)
public class AmazonTest extends TestBase {

    private Logger logger = Logger.getLogger(AmazonTest.class);

    private AmazonPage amazonPage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        openUrl("https://www.amazon.com/");
        amazonPage = new AmazonPage(driver);
    }

    @Test(priority = 1)
    public void validateLoginLogout() {
        amazonPage.clickOnAccountButton();
        Assert.assertTrue(amazonPage.isSignInTextPresent(), "navigation failed");
        amazonPage.enterEmailId("gojekproject9@gmail.com");
        amazonPage.enterPassword("gojek1234");
        amazonPage.clickSubmit();
        Assert.assertTrue(amazonPage.isSignedIn(), "we are not signed in to account");
        amazonPage.clickSignOut();
        Assert.assertTrue(amazonPage.isSignInTextPresent(), "navigation failed");

    }

    @Test(priority = 2)
    public void addHeadPhone() {
        amazonPage.clickOnAccountButton();
        Assert.assertTrue(amazonPage.isSignInTextPresent(), "navigation failed");
        amazonPage.enterEmailId("gojekproject9@gmail.com");
        amazonPage.enterPassword("gojek1234");
        amazonPage.clickSubmit();
        Assert.assertTrue(amazonPage.isSignedIn(), "we are not signed in to account");
        amazonPage.clickElectronics();
        amazonPage.clickheadphones();
        amazonPage.clickfirstHeadphone();
        amazonPage.clickAddToCart();
        Assert.assertTrue(amazonPage.isproceedToCheckoutPresent(), "headphones are not added to cart");
    }

    @Test(priority = 3)
    public void addMacBookPro() {
        amazonPage.clickOnAccountButton();
        Assert.assertTrue(amazonPage.isSignInTextPresent(), "navigation failed");
        amazonPage.enterEmailId("gojekproject9@gmail.com");
        amazonPage.enterPassword("gojek1234");
        amazonPage.clickSubmit();
        Assert.assertTrue(amazonPage.isSignedIn(), "we are not signed in to account");
        amazonPage.clickOnSearchBar();
        amazonPage.inputOnSearchBar("Macbook pro");
        amazonPage.clickOnSearchButton();
        amazonPage.selectSecondElement();
        amazonPage.clickQuantity();
        amazonPage.selectQuantity();
        amazonPage.clickAddToCart();
        Assert.assertTrue(amazonPage.isproceedToCheckoutPresent(), "headphones are not added to cart");
    }

    @Test(priority = 4)
    public void deleteFirstProductFromCart() {
        amazonPage.clickOnAccountButton();
        Assert.assertTrue(amazonPage.isSignInTextPresent(), "navigation failed");
        amazonPage.enterEmailId("gojekproject9@gmail.com");
        amazonPage.enterPassword("gojek1234");
        amazonPage.clickSubmit();
        Assert.assertTrue(amazonPage.isSignedIn(), "we are not signed in to account");
        amazonPage.clickOnCart();
        Assert.assertTrue(amazonPage.isShoppingCartPresent(), "navigation is not done properly");
        amazonPage.deleteFirstProduct();
        Assert.assertTrue(amazonPage.isProductDeleted(), "product is not deleted");
    }

    @Test(priority = 5)
    public void changeQuantityOfSecondProductFromCart() {
        amazonPage.clickOnAccountButton();
        Assert.assertTrue(amazonPage.isSignInTextPresent(), "navigation failed");
        amazonPage.enterEmailId("gojekproject9@gmail.com");
        amazonPage.enterPassword("gojek1234");
        amazonPage.clickSubmit();
        Assert.assertTrue(amazonPage.isSignedIn(), "we are not signed in to account");
        amazonPage.clickOnCart();
        Assert.assertTrue(amazonPage.isShoppingCartPresent(), "navigation is not done properly");
        amazonPage.clickSecondProductQuantity();
        amazonPage.changeQuantity();
        Assert.assertTrue(amazonPage.isQuantitChanged(), "Quantity is not changed");
    }

    @Test(dataProvider = "serachProduct", dataProviderClass = AmazonDataProvider.class, priority = 6)
    public void validateMultipleProducts(String product, String keyword) {
        amazonPage.clickOnAccountButton();
        Assert.assertTrue(amazonPage.isSignInTextPresent(), "navigation failed");
        amazonPage.enterEmailId("gojekproject9@gmail.com");
        amazonPage.enterPassword("gojek1234");
        amazonPage.clickSubmit();
        Assert.assertTrue(amazonPage.isSignedIn(), "we are not signed in to account");
        amazonPage.clickOnSearchBar();
        amazonPage.inputOnSearchBar(product);
        amazonPage.clickOnSearchButton();
        Assert.assertTrue(driver.getCurrentUrl().contains(keyword), "not navigated properly");
    }


}
