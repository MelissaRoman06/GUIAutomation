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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    @FindBy(css = ".product-layout:nth-child(1) .hidden-xs")
    private WebElement macBookAddToCartButton;

    /**
     * Adds MacBook to cart.
     */
    public void addMacBookToCart() {
        js.executeScript("window.scrollTo(0,658)");
        macBookAddToCartButton.click();
    }

    /**
     * Gets alert message text.
     *
     * @return - Alert message text.
     */
    public String getAlertMessageText() {
        WebElement alertMessage = wait.until(ExpectedConditions
                .visibilityOfElementLocated(alert));
        String alertCompleteMessage = alertMessage.getText();
        int indexOfMessageFinish = alertCompleteMessage.indexOf("\n");
        String alertMessageText = alertCompleteMessage.substring(0, indexOfMessageFinish);
        return alertMessageText;
    }

}
