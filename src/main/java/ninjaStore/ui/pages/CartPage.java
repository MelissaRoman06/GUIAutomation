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

import ninjaStore.entities.Product;
import ninjaStore.ui.BasePage;
import ninjaStore.utils.WebDriverHelper;
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
    private static final String PRODUCT_CELL_LOCATOR = "//a[text()='%s']"; // Used to find the cell where product
                                                                            // is located.
    private static final String ANCESTOR_SUFFIX_TR = "/ancestor::td/ancestor::tr"; // Used to find the row from cell
                                                                                    // in table.
    private static final String QTTY_PRODUCT_TEXTBOX_SUFFIX = "//div//input"; // Used to find the quantity text box
                                                                            // from row.
    private static final String QTTY_UPDATE_BUTTON_SUFFIX = "//div//button[@data-original-title='Update']"; // Used to
                                                                            // find update quantity button from row.
    /**
     * Checkout button.
     */
    @FindBy(xpath = "//a[text()='Checkout']")
    private WebElement checkoutButton;

    /**
     * Verifies if given product is in cart table.
     *
     * @param product - Product to find.
     * @return - True if the product is found.
     */
    public boolean isProductInCartTable(final Product product) {
        WebElement productCell = getProductCellElementByProductName(product);
        return productCell.getAttribute("textContent").equals(product.getProductName());
    }

    /**
     * Allows to get the cell web element where the product is according on product name.
     *
     * @param product - Product to be found.
     * @return - Cell web element where the product appears.
     */
    public WebElement getProductCellElementByProductName(final Product product) {
        return driver.findElement(By.xpath(String.format(PRODUCT_CELL_LOCATOR, product.getProductName())));
    }

    /**
     * Allows to get the row web element where the product is according to its product name.
     *
     * @param product - Product to be found.
     * @return - Row web element where the product appears.
     */
    public WebElement getProductRowElementByProductName(final Product product) {
        return driver.findElement(By.xpath(String.format(PRODUCT_CELL_LOCATOR, product.getProductName())
                + ANCESTOR_SUFFIX_TR));
    }

    /**
     * Allows to get the quantity text box web element correspondent to the given product according to its product name.
     *
     * @param product - Product to be found.
     * @return - Quantity text box web element correspondent to the given product.
     */
    public WebElement getQuantityTextBoxByProduct(final Product product) {
        return driver.findElement(By.xpath(String.format(PRODUCT_CELL_LOCATOR, product.getProductName())
                + ANCESTOR_SUFFIX_TR + QTTY_PRODUCT_TEXTBOX_SUFFIX));
    }

    /**
     * Allows to get the update quantity button web element correspondent to the given product according
     * to its product name.
     *
     * @param product - Product to be found.
     * @return - Update quantity button web element correspondent to the given product.
     */
    public WebElement getQuantityUpdateButtonByProduct(final Product product) {
        return driver.findElement(By.xpath(String.format(PRODUCT_CELL_LOCATOR, product.getProductName())
                + ANCESTOR_SUFFIX_TR + QTTY_UPDATE_BUTTON_SUFFIX));
    }

    /**
     * Checkouts from cart page.
     */
    public void checkout() {
        checkoutButton.click();
    }

    /**
     * Removes one element of given product from cart.
     *
     * @param product - Product to remove.
     */
    public void deleteFromCart(final Product product) {
        WebElement qttyTextBox = getQuantityTextBoxByProduct(product);
        String qttyProduct = qttyTextBox.getAttribute("value");
        int updatedQtty = Integer.parseInt(qttyProduct) - 1;
        WebDriverHelper.enterKeys(qttyTextBox, Integer.toString(updatedQtty));
        WebElement qttyUpdateButton = getQuantityUpdateButtonByProduct(product);
        qttyUpdateButton.click();
    }
}
