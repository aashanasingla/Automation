package com.gojek;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;


public class TestBase extends TestListenerAdapter {

    protected RemoteWebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        InitiateDriver initiateDriver = new InitiateDriver();
        driver = initiateDriver.getDriver();
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    @AfterTest(alwaysRun = true)
    public void afterMethodOperation() {
        driver.quit();
    }
}
