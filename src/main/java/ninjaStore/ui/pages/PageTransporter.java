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

import ninjaStore.ui.utils.NinjaStoreConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * PageTransporter class is in charge of navigate through pages.
 *
 * @author Melissa Román
 * @version 1.0
 */
public final class PageTransporter extends BasePage {
    private static PageTransporter pageTransporterInstance;

    /**
     * Constructs the page transporter with driver from parent class.
     */
    private PageTransporter() {
        super();
    }

    /**
     * Gets the instance of PageTransporter.
     *
     * @return PageTransporterInstance.
     */
    public static PageTransporter getInstance() {
        if (pageTransporterInstance == null) {
            pageTransporterInstance = new PageTransporter();
        }
        return pageTransporterInstance;
    }

    /**
     * Finds account drop down menu.
     */
    @FindBy(css = ".dropdown .hidden-xs")
    private WebElement accountDropDownMenu;

    /**
     * Finds logout option on menu.
     */
    @FindBy(linkText = "Logout")
    private WebElement logoutButton;

    /**
     * Navigates to login page.
     */
    public void goToLoginPage() {
        this.driver.get(NinjaStoreConfig.getInstance().getLoginURL());
    }

    /**
     * Allows to logout.
     */
    public void logout() {
        accountDropDownMenu.click();
        logoutButton.click();
    }

    /**
     * Quits from the browser.
     */
    public void quit() {
        this.driver.quit();
    }
}
