/*
 * @(#) AccountPage.java Copyright (c) 2019 Jala Foundation.
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
 * AccountPage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class AccountPage extends BasePage {

    /**
     * Finds tittle on account page.
     */
    @FindBy(css = "h2:nth-child(1)")
    private WebElement myAccountTitle;

    /**
     * Allows to get the text on page tittle.
     *
     * @return - Text on tittle.
     */
    public String getTextFirstTitle() {
        return myAccountTitle.getText();
    }
}
