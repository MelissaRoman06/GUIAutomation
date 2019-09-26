/*
 * @(#) EditAccountPage.java Copyright (c) 2019 Jala Foundation.
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
 * EditAccountPage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class EditAccountPage extends BasePage {

    /**
     * Email text box.
     */
    @FindBy(id = "input-email")
    private WebElement emailTextBox;

    /**
     * Allows to get the value in email text box.
     *
     * @return Email in email text box.
     */
    public String getEmailText() {
        return emailTextBox.getAttribute("value");
    }
}
