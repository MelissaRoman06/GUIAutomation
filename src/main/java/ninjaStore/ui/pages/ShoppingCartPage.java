/*
 * @(#) ShoppingCartPage.java Copyright (c) 2019 Jala Foundation.
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
 * ShoppingCartPage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ShoppingCartPage extends BasePage {

    /**
     * Table with a list of all products in shopping cart.
     */
    @FindBy(css = "thead .text-left:nth-child(2)")
    private WebElement tableProductNameHeader;

    /**
     * First element on shopping cart list.
     */
    @FindBy(css = "tbody:nth-child(2) .text-left:nth-child(2)")
    private WebElement firstProductOnList;

    /**
     * Gets the first element name on shopping cart list.
     *
     * @return - First element name.
     */
    public String getFirstProductNameOnCart() {
        String firstProductComplete = firstProductOnList.getText();
        int indexNameFinish = firstProductComplete.indexOf("\n");
        String firstProduct = firstProductComplete.substring(0, indexNameFinish);
        return firstProduct;
    }
}
