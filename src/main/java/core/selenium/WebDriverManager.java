/*
 * @(#) WebDriverManager.java Copyright (c) 2019 Jala Foundation.
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

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * WebDriverManager is in charge of returning the web driver to be used for the tests.
 *
 * @author Melissa Román
 * @version 1.0
 */
public final class WebDriverManager {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private static WebDriverManager driverManagerInstance;

    /**
     * Constructor WebDriverManager.
     */
    private WebDriverManager() {
        initialize();
    }

    /**
     * Gets Instance of a Web Driver Manager.
     *
     * @return Instance of Web Driver Manager.
     */
    public static WebDriverManager getInstance() {
        if (driverManagerInstance == null) {
            driverManagerInstance = new WebDriverManager();
        }
        return driverManagerInstance;
    }

    /**
     * Initializes the settings for the Web Driver.
     */
    private void initialize() {
        this.webDriver = BrowserFactory.getBrowser(WebDriverConfig.getInstance().getBrowserName()).initDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage()
                .timeouts()
                .implicitlyWait(WebDriverConfig.getInstance().getImplicitWaitTime(), TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, WebDriverConfig.getInstance().getExplicitWaitTime(),
                WebDriverConfig.getInstance().getWaitSleepTime());
    }

    /**
     * Allows to get the Web Driver.
     *
     * @return WebDriver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Gets the Web Driver wait.
     *
     * @return WebDriverWait.
     */
    public WebDriverWait getWait() {
        return webDriverWait;
    }
}
