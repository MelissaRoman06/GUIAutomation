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
    private JavascriptExecutor js;

    @FindBy(css = ".product-layout:nth-child(1) .hidden-xs")
    private WebElement macBookAddToCartButton;

    @FindBy(css = ".alert")
    private WebElement alertMessage;

    /**
     * Constructs the page with driver from parent class and the javaScript executor.
     */
    public HomePage() {
        super();
        js = (JavascriptExecutor) driver;
    }

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
        alertMessage = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".alert")));
        String alertCompleteMessage = alertMessage.getText();
        int indexOfMessageFinish = alertCompleteMessage.indexOf("\n");
        String alertMessage = alertCompleteMessage.substring(0, indexOfMessageFinish);
        return alertMessage;
    }

}
