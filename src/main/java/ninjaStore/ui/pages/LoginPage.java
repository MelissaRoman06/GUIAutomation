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
import ninjaStore.utils.WebDriverHelper;
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
     * Enters the email and password according to input string.
     *
     * @param email    - Email to be entered.
     * @param password - Password to be entered.
     */
    public void login(final String email, final String password) {
        WebDriverHelper.enterKeys(emailBox, email);
        WebDriverHelper.enterKeys(passwordBox, password);
        loginButton.click();
    }
}
