package com.gojek;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class InitiateDriver {

    private RemoteWebDriver driver;
    private BrowserMobProxy server;
    private Proxy proxy;

    /**
     * Currently we are taking local url where selenium is running
     */
    private String url = "http://127.0.0.1:4444/wd/hub";

    //private String CHROME_DRIVER = "chrome";

    public InitiateDriver() {
        try {
            InputStream input = this.getClass().getClassLoader().getResourceAsStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
            Properties configProperties = new Properties();
            configProperties.load(input);
            DesiredCapabilities capabilities = getDesiredCapabilities(configProperties.get("browser").toString());
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
            driver = new RemoteWebDriver(new URL(url), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
        if (driverType.equals("Chrome")) {
            capabilities  = DesiredCapabilities.chrome();
            //capabilities.setCapability(CapabilityType.PROXY, startProxyServer());
        }
        return capabilities;
    }

    private Proxy startProxyServer() {
        if(server == null || !server.isStarted())
        {
            server = new BrowserMobProxyServer();
            server.start();
            proxy = ClientUtil.createSeleniumProxy(server);
            proxy.setHttpProxy(url);
        }

        return proxy;
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
