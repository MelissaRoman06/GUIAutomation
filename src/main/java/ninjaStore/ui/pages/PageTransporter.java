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
import ninjaStore.utils.StoreURLReader;
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
     * Navigates to given page.
     * @param page - Page which is wanted to go to.
     */
    public static void goToPage(final String page) {
        WEB_DRIVER.get(StoreURLReader.getInstance().getURL(page));
    }
    /**
     * Quits from the browser.
     */
    public static void quit() {
        WEB_DRIVER.quit();
    }
}
