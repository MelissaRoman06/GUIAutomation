/*
 * @(#) LoginPage.java Copyright (c) 2019 Jala Foundation.
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
 * LoginPage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class LoginPage extends BasePage {

    /**
     * Finds the email box.
     */
    @FindBy(id = "input-email")
    private WebElement emailBox;

    /**
     * Finds the password box.
     */
    @FindBy(id = "input-password")
    private WebElement passwordBox;

    /**
     * Finds the login button.
     */
    @FindBy(css = ".btn:nth-child(3)")
    private WebElement loginButton;

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
     * Presses the login button.
     */
    public void pressLoginButton() {
        loginButton.click();
    }

    /**
     * Enters the email and password according to input string.
     *
     * @param email    - Email to be entered.
     * @param password - Password to be entered.
     */
    public void enterCredentials(final String email, final String password) {
        enterKeys(emailBox, email);
        enterKeys(passwordBox, password);
    }

    /**
     * Enters string into given web element. This will be moved to a util class.
     *
     * @param textBox    - TextBox to enter the keys.
     * @param stringKeys - Keys to be entered.
     */
    public void enterKeys(final WebElement textBox, final String stringKeys) {
        textBox.click();
        textBox.clear();
        textBox.sendKeys(stringKeys);
    }

    /**
     * Allows to logout.
     */
    public void logout() {
        accountDropDownMenu.click();
        logoutButton.click();
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
