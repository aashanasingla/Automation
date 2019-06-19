package com.gojek;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;

public class PageBase {

    private Logger logger = Logger.getLogger(PageBase.class);

    private final int TIMEOUT = 40;

    private String fileName;

    private RemoteWebDriver driver;

    private Wait wait;

    private static final ObjectMapper mapper = new ObjectMapper();

    public PageBase(String fileName, RemoteWebDriver driver) {
        this.fileName = fileName;
        this.driver = driver;
    }

    protected boolean isElementPresent(final String element) {
        WebElement webElement = find(element);
        logger.info("webElement: " + webElement + " for element: " + element);
        return webElement != null;
    }

    protected WebElement find(final String element) {
        try {
            File jsonInputFile = new File(System.getProperty("user.dir") + fileName);
            JsonNode rootNode = mapper.readTree(jsonInputFile);
            JsonNode currentElementNode = rootNode.get(element);
            if (currentElementNode.get("xpath") != null) {
                return driver.findElementByXPath(currentElementNode.get("xpath").asText());
            } else if (currentElementNode.get("id") != null) {
                return driver.findElementById(currentElementNode.get("id").asText());
            } else if (currentElementNode.get("name") != null) {
                return driver.findElementByName(currentElementNode.get("name").asText());
            }
        } catch (IOException e) {
            logger.warn("Not able to find element " + element);
        }
        return null;
    }

    protected void enterText(final String element, final String text) {
        find(element).sendKeys(text);
    }

}
