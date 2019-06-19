package com.gojek;

import com.gojek.amazon.AmazonPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTest extends TestBase {

    private Logger logger = Logger.getLogger(AmazonTest.class);

    private AmazonPage amazonPage;

    @BeforeMethod
    public void setup() {
       openUrl("https://www.amazon.com/");
       amazonPage = new AmazonPage(driver);
    }

    @Test
    public void validateLoginLogout() {
        amazonPage.clickOnAccountButton();
        Assert.assertTrue(amazonPage.isSignInTextPresent(), "navigation failed");
        amazonPage.enterEmailId("gojekproject9@gmail.com");
        amazonPage.enterPassword("gojek1234");
        amazonPage.clickSubmit();
        Assert.assertTrue(amazonPage.isSignedIn(),"we are not signed in to account");
        amazonPage.clickSignOut();
        Assert.assertTrue(amazonPage.isSignInTextPresent(), "navigation failed");

    }

    @Test
    public void addHeadPhone() {
        amazonPage.clickOnAccountButton();
        Assert.assertTrue(amazonPage.isSignInTextPresent(), "navigation failed");
        amazonPage.enterEmailId("gojekproject9@gmail.com");
        amazonPage.enterPassword("gojek1234");
        amazonPage.clickSubmit();
        Assert.assertTrue(amazonPage.isSignedIn(),"we are not signed in to account");
        amazonPage.clickElectronics();
        amazonPage.clickheadphones();
        amazonPage.clickfirstHeadphone();
        amazonPage.clickAddToCart();
        Assert.assertTrue(amazonPage.isproceedToCheckoutPresent(),"headphones are not added to cart");
    }

}
