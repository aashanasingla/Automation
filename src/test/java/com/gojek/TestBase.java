package com.gojek;

import com.gojek.util.InitiateDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBase extends TestListenerAdapter {

    protected RemoteWebDriver driver;

    @BeforeMethod
    public void setup() {
        InitiateDriver initiateDriver = new InitiateDriver();
        driver = initiateDriver.getDriver();
    }

    @Test
    public void test() {
        System.out.println("Hello world");
    }

    public void closeWindow()
    {
        driver.close();
    }
}
