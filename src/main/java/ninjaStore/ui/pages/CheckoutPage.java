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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * CheckoutPage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CheckoutPage extends BasePage {
    private JavascriptExecutor js;

    /**
     * First name label on billing details forms.
     */
    @FindBy(css = ".form-group:nth-child(1) > .col-sm-2")
    private WebElement firstNameLabel;

    public CheckoutPage() {
        super();
        js = (JavascriptExecutor) driver;
    }

    public String getNameLabelText() {
        return firstNameLabel.getText();
    }

}
