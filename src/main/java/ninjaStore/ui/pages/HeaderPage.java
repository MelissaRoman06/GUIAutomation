/*
 * @(#) HeaderPage.java Copyright (c) 2019 Jala Foundation.
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

import ninjaStore.ui.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * HeaderPage class models the used WebElements and actions for the page header.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class HeaderPage extends BasePage {

    /**
     * Finds account drop down menu.
     */
    @FindBy(css = ".dropdown .hidden-xs")
    private static WebElement accountDropDownMenu;

    /**
     * Finds logout option on menu.
     */
    @FindBy(linkText = "Logout")
    private static WebElement logoutButton;

    /**
     * Allows to logout.
     */
    public void logout() {
        accountDropDownMenu.click();
        logoutButton.click();
    }

    /**
     * Drops down account menu.
     */
    public void dropDownAccountMenu() {
        accountDropDownMenu.click();
    }

    /**
     * Allows to get the text from logout button.
     *
     * @return Text from logout button.
     */
    public String getLogoutText() {
        return logoutButton.getText();
    }
}
