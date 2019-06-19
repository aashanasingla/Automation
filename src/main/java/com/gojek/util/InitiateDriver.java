package com.gojek.util;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 */
public class InitiateDriver {

    /**
     *
     */
    private RemoteWebDriver driver;
    /**
     * Currently we are taking local url where selenium is running
     */
    private String url = "http://127.0.0.1:4444/wd/hub";

    /**
     *
     */
    private String CHROME_DRIVER = "chrome";

    /**
     *
     */
    public InitiateDriver() {
        try {
            DesiredCapabilities capabilities = getDesiredCapabilities(CHROME_DRIVER);
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
            driver = new RemoteWebDriver(new URL(url), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function will give you desireCapabilities based on driverType
     * @param driverType it can be chrome drive, firefox, etc
     * @return  DesiredCapabilities
     */
    private DesiredCapabilities getDesiredCapabilities(final String driverType) {
        DesiredCapabilities capabilities = null;
        if (driverType.equals(CHROME_DRIVER)) {
            capabilities  = DesiredCapabilities.chrome();
        }
        return capabilities;
    }

    /**
     * It will return driver object if driver is null will throw Exception
     * @return RemoteWebDriver
     */
    public RemoteWebDriver getDriver() {
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initiated");
        }
        return driver;
    }
}
