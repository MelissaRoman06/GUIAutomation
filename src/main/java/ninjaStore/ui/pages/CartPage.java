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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * CartPage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CartPage extends BasePage {
    private By tableXpath = By.xpath("//div[@id='content']/form/div/table/tbody/tr");

    /**
     * Checkout button.
     */
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    private WebElement checkoutButton;

    /**
     * Empty cart label.
     */
    @FindBy(xpath = "//p[@id='content']")
    private WebElement emptyCartLabel;

    /**
     * Verifies if given product is in cart table.
     *
     * @param productName - Product name to find.
     * @return - True if the product is found.
     */
    public boolean isProductInCartTable(final String productName) {
        boolean isFound = false;
        int cantRows = driver.findElements(tableXpath).size();
        for (int index = 1; index <= cantRows; index++) {
            String xpathByIndex = String.format("//*[@id='content']/form/div/table/tbody/tr[%d]/td[2]/a", index);
            if (driver.findElement(By.xpath(xpathByIndex)).getText().equals(productName)) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    /**
     * Checkouts from cart page.
     */
    public void checkout() {
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
