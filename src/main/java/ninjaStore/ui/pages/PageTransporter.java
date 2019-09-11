/*
 * @(#) PageTransporter.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package ninjaStore.ui.pages;

import core.selenium.WebDriverManager;
import ninjaStore.utils.NinjaStoreConfig;
import org.openqa.selenium.WebDriver;

/**
 * PageTransporter class is in charge of navigate through pages.
 *
 * @author Melissa Román
 * @version 1.0
 */
public abstract class PageTransporter {
    private final static WebDriver WEB_DRIVER = WebDriverManager.getInstance().getWebDriver();

    /**
     * Navigates to login page.
     */
    public static void goToLoginPage() {
        WEB_DRIVER.get(NinjaStoreConfig.getInstance().getLoginURL());
    }

    /**
     * Navigates to home page.
     */
    public static void goToHomePage() {
        WEB_DRIVER.get(NinjaStoreConfig.getInstance().getHomeURL());
    }

    /**
     * Navigates to shopping cart page.
     */
    public static void goToShoppingCartPage() {
        WEB_DRIVER.get(NinjaStoreConfig.getInstance().getShoppingCartURL());
    }

    /**
     * Quits from the browser.
     */
    public static void quit() {
        WEB_DRIVER.quit();
    }
}
