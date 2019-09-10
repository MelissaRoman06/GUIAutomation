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
public final class LoginPage extends BasePage {
    private static LoginPage loginPageInstance;

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
     * Constructs the page and getting the page by url.
     */
    private LoginPage() {
        super();
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
    public void enterCredentials(String email, String password) {
        enterKeys(emailBox, email);
        enterKeys(passwordBox, password);
    }

    public void enterKeys(WebElement textBox, String stringKeys) {
        textBox.click();
        textBox.clear();
        textBox.sendKeys(stringKeys);
    }
}
