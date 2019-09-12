/*
 * @(#) CartPage.java Copyright (c) 2019 Jala Foundation.
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
 * CartPage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CartPage extends BasePage {
    private JavascriptExecutor js;

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
     * Checkout button.
     */
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    private WebElement checkoutButton;

    /**
     * Empty cart label.
     */
    @FindBy(css = "p:nth-child(2)")
    private WebElement emptyCartLabel;

    /**
     * Constructs the page with driver from parent class and the javaScript executor.
     */
    public CartPage() {
        super();
        js = (JavascriptExecutor) driver;
    }

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

    /**
     * Checkouts from cart page.
     */
    public void checkout() {
        js.executeScript("window.scrollTo(0,658)");
        checkoutButton.click();
    }

    /**
     * Allows to get the text from emptyCart label.
     *
     * @return Empty card label text.
     */
    public String getEmptyCartLabelText() {
        return emptyCartLabel.getText();
    }
}
