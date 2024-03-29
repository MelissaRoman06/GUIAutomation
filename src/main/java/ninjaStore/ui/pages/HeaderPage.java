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
import ninjaStore.utils.StringHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * HeaderPage class models the used WebElements and actions for the page header.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class HeaderPage extends BasePage {
    private By alert = By.cssSelector(".alert");

    /**
     * Finds account drop down menu.
     */
    @FindBy(xpath = "//a[@title='My Account']")
    private static WebElement accountDropDownMenu;

    /**
     * Finds logout option on drop down menu.
     */
    @FindBy(xpath = "//a[text()='Logout']")
    private static WebElement logoutButton;

    /**
     * Finds login option on drop down menu.
     */
    @FindBy(xpath = "//a[text()='Login']")
    private static WebElement loginButton;

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
        return logoutButton.getAttribute("textContent");
    }

    /**
     * Presses login button.
     */
    public void pressLogin() {
        loginButton.click();
    }

    /**
     * Presses logout button.
     */
    public void pressLogout() {
        logoutButton.click();
    }

    /**
     * Allows to get the text from login button.
     *
     * @return Text from login button.
     */
    public String getLoginText() {
        return loginButton.getAttribute("textContent");
    }

    /**
     * Gets alert message text.
     *
     * @return - Alert message text.
     */
    public String getAlertMessageText() {
        WebElement alertMessage = wait.until(ExpectedConditions
                .visibilityOfElementLocated(alert));
        String alertCompleteMessage = alertMessage.getText();
        return StringHelper.getUntilLineBreak(alertCompleteMessage);
    }
}
