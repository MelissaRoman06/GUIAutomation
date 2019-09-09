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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LoginPage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class LoginPage extends BasePage {
    private static LoginPage loginPageInstance;
    /**
     * Finds the email box.
     */
    @FindBy(id = "input-email")
    WebElement emailBox;

    /**
     * Finds the password box.
     */
    @FindBy(id = "input-password")
    WebElement passwordBox;

    /**
     * Finds the login button.
     */
    @FindBy(css = ".btn:nth-child(3)")
    WebElement loginButton;

    /**
     * Constructs the page and getting the page by url.
     */
    protected LoginPage() {
        super();
        this.driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
    }

    /**
     * Gets the instance of LoginPage.
     *
     * @return configInstance.
     */
    public static LoginPage getInstance() {
        if (loginPageInstance == null) {
            loginPageInstance = new LoginPage();
        }
        return loginPageInstance;
    }

    /**
     * Enters the email according to input string.
     *
     * @param email - Email to be entered.
     */
    public void enterEmail(String email) {
        emailBox.click();
        emailBox.sendKeys(email);
    }

    /**
     * Enters the password according to input string.
     *
     * @param password - Password to be entered.
     */
    public void enterPassword(String password) {
        passwordBox.click();
        passwordBox.sendKeys(password);
    }

    /**
     * Presses the login button.
     */
    public void pressLoginButton() {
        loginButton.click();
    }

    /**
     * Finds tittle on account page.
     */
    @FindBy(css = "h2:nth-child(1)")
    WebElement myAccountTittle;

    /**
     * Allows to get the text on page tittle.
     *
     * @return - Text on tittle.
     */
    public String getText() {
        return myAccountTittle.getText();
    }

    /**
     * Finds account drop down menu.
     */
    @FindBy(css = ".dropdown .hidden-xs")
    WebElement accountDropDownMenu;

    /**
     * Finds logout option on menu.
     */
    @FindBy(linkText = "Logout")
    WebElement logoutButton;

    /**
     * Allows to logout.
     */
    public void logout() {
        accountDropDownMenu.click();
        logoutButton.click();
    }

    public void quit() {
        this.driver.quit();
    }
}
