/*
 * @(#) WebDriverConfig.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package core.selenium;

import ninjaStore.utils.PropertiesReader;

import java.util.Properties;

/**
 * WebDriverConfig reads properties file to set waits' time to be used by the web driver.
 *
 * @author Melissa Román
 * @version 1.0
 */
public final class WebDriverConfig {
    private int implicitWaitTime;
    private int explicitWaitTime;
    private int waitSleepTime;
    private String browserName;
    private Properties properties;
    private static WebDriverConfig configInstance;

    /**
     * Constructor WebDriverConfig.
     */
    private WebDriverConfig() {
        properties = PropertiesReader.getProperties("webDriver.properties");
        readProperties();
    }

    /**
     * Gets the instance of WebDriverConfig.
     *
     * @return configInstance.
     */
    public static WebDriverConfig getInstance() {
        if (configInstance == null) {
            configInstance = new WebDriverConfig();
        }
        return configInstance;
    }

    /**
     * Reads properties file for Web Driver waits' config.
     */
    public void readProperties() {
        browserName = properties.getProperty("browserName");
        implicitWaitTime = Integer.parseInt(properties.getProperty("implicitWaitTime"));
        explicitWaitTime = Integer.parseInt(properties.getProperty("explicitWaitTime"));
        waitSleepTime = Integer.parseInt(properties.getProperty("waitSleepTime"));
    }

    /**
     * Gets the implicit wait time set for the WebDriver.
     *
     * @return Implicit wait time.
     */
    public String getBrowserName() {
        return browserName;
    }

    /**
     * Gets the implicit wait time set for the WebDriver.
     *
     * @return Implicit wait time.
     */
    public int getImplicitWaitTime() {
        return implicitWaitTime;
    }

    /**
     * Gets the explicit wait time set for the WebDriver.
     *
     * @return Explicit wait time.
     */
    public int getExplicitWaitTime() {
        return explicitWaitTime;
    }

    /**
     * Gets the sleep time wait set for the WebDriver.
     *
     * @return Sleep wait time.
     */
    public int getWaitSleepTime() {
        return waitSleepTime;
    }
}
