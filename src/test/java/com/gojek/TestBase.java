package com.gojek;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase extends TestListenerAdapter {

    protected RemoteWebDriver driver;

    @BeforeSuite
    public void init() {
        InitiateDriver initiateDriver = new InitiateDriver();
        driver = initiateDriver.getDriver();
    }

    public void openUrl(String url){
        driver.get(url);
    }

    @AfterMethod
    public void afterMethodOperation() {
       // driver.close();
    }
}
