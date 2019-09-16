/*
 * @(#) HomePage.java Copyright (c) 2019 Jala Foundation.
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
 * HomePage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class HomePage extends BasePage {
    private By alert = By.cssSelector(".alert");

    /**
     * MacBook's add to cart button.
     */
    @FindBy(xpath = "//div[@id='content']/div[2]/div[1]/div/div[3]/button[1]")
    private WebElement macBookAddToCartButton;

    /**
     * Adds MacBook to cart.
     */
    public void addMacBookToCart() {
        macBookAddToCartButton.click();
    }

    /**
     * Adds the given product to cart. Product must be offered on home page.
     *
     * @param productName - Product offered on home page.
     */
    public void addProductToCart(final String productName) {
        String xpathAddToCart = String.format("//a[contains(text(),'%s')]/ancestor::div[@class='caption']"
                + "/following-sibling::div //i[@class='fa fa-shopping-cart']", productName);
        By productXpath = By.xpath(xpathAddToCart);
        driver.findElement(productXpath).click();
    }
}
