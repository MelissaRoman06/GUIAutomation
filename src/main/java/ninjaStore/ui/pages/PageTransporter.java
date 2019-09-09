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
import ninjaStore.ui.utils.NinjaStoreConfig;

/**
 * PageTransporter class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class PageTransporter {
    public static void goToLoginPage() {
        WebDriverManager.getInstance().getWebDriver().get(NinjaStoreConfig.getInstance().getLoginURL());
    }
}
