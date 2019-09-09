/*
 * @(#) Hooks.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package hooks;

import cucumber.api.java.After;
import ninjaStore.ui.pages.LoginPage;
import ninjaStore.ui.pages.PageTransporter;
import org.testng.annotations.AfterClass;

/**
 * Hooks class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class Hooks {

    /**
     * Logout from the session account.
     */
    @After("@Login")
    public void logout() {
        PageTransporter.getInstance().logout();
    }

    /**
     * Quits from the browser.
     */
    @AfterClass
    public void quit() {
        PageTransporter.getInstance().quit();
    }


}
