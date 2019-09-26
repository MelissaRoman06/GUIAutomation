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
     * Checkout options.
     */
    @FindBy(xpath = "//a[@href='#collapse-checkout-option']")
    private WebElement checkoutOptionsSubtitle;

    /**
     * Billing details.
     */
    @FindBy(xpath = "//a[@href='#collapse-payment-address']")
    private WebElement billingDetailsSubtitle;

    /**
     * Allows to get the text from first subtitle shown.
     *
     * @return - Text from first subtitle.
     */
    public String isCheckoutOptionsExpanded() {
        return checkoutOptionsSubtitle.getAttribute("aria-expanded");
    }

    /**
     * Allows to get the text from first subtitle shown.
     *
     * @return - Text from first subtitle.
     */
    public String isBillingDetailsExpanded() {
        return billingDetailsSubtitle.getAttribute("aria-expanded");
    }
}
