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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ShoppingCartPage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class ShoppingCartPage extends BasePage {
    private static ShoppingCartPage shoppingCartPageInstance;

    @FindBy(css = "thead .text-left:nth-child(2)")
    private WebElement tableProductNameHeader;

    @FindBy(css = "tbody:nth-child(2) .text-left:nth-child(2)")
    private WebElement firstProductName;

    /**
     * Constructs the page transporter with driver from parent class.
     */
    private ShoppingCartPage() {
        super();
    }

    /**
     * Gets the instance of HomePage.
     *
     * @return shoppingCartPageInstance.
     */
    public static ShoppingCartPage getInstance() {
        if (shoppingCartPageInstance == null) {
            shoppingCartPageInstance = new ShoppingCartPage();
        }
        return shoppingCartPageInstance;
    }

    public String getFirstProductNameOnCart() {
        String firstProductComplete = firstProductName.getText();
        int indexNameFinish = firstProductComplete.indexOf("\n");
        String firstProduct = firstProductComplete.substring(0, indexNameFinish);
        return firstProduct;
    }
}
