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

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * HomePage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class HomePage extends BasePage {
    private static HomePage homePageInstance;
    private JavascriptExecutor js;

    @FindBy(css = ".product-layout:nth-child(1) .hidden-xs")
    private WebElement macBookAddToCartButton;

    @FindBy(css = ".alert")
    private WebElement alertMessage;

    /**
     * Constructs the page transporter with driver from parent class.
     */
    private HomePage() {
        super();
        js = (JavascriptExecutor) driver;
    }

    /**
     * Gets the instance of HomePage.
     *
     * @return homePageInstance.
     */
    public static HomePage getInstance() {
        if (homePageInstance == null) {
            homePageInstance = new HomePage();
        }
        return homePageInstance;
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
        return alertMessage.getText();
    }

}
