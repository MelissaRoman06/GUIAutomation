/*
 * @(#) CheckoutPage.java Copyright (c) 2019 Jala Foundation.
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
 * CheckoutPage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CheckoutPage extends BasePage {

    /**
     * First name label on billing details forms.
     */
    @FindBy(css = ".form-group:nth-child(1) > .col-sm-2")
    private WebElement firstNameLabel;

    /**
     * First name label on billing details forms.
     */
    @FindBy(css = ".panel:nth-child(1) .panel-title")
    private WebElement firstSubtitle;

    /**
     * Second subtitle.
     */
    @FindBy(xpath = "//a[contains(.,'Step 2: Billing Details ')]")
    private WebElement secondSubtitle;

    /**
     * Allows to get the text from first subtitle shown.
     *
     * @return - Text from first subtitle.
     */
    public String getFirstSubtitleText() {
        return firstSubtitle.getText();
    }

    /**
     * Allows to get the text from first subtitle shown.
     *
     * @return - Text from first subtitle.
     */
    public String getSecondSubtitleText() {
        return secondSubtitle.getText();
    }
}
