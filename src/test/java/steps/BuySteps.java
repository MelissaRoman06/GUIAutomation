/*
 * @(#) BuySteps.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Pa;
import ninjaStore.ui.pages.HomePage;
import ninjaStore.ui.pages.PageTransporter;
import ninjaStore.ui.pages.ShoppingCartPage;
import org.testng.Assert;

/**
 * BuySteps implemented all steps to buy feature.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class BuySteps {
    private HomePage homePage;
    private ShoppingCartPage shoppingCartPage;

    /**
     * Navigates to home page.
     */
    @When("the user goes to home page")
    public void theUserGoesToLoginPage() {
        PageTransporter.goToHomePage();
        homePage = new HomePage();
    }

    @And("the user adds MacBook product to cart")
    public void addProductToCart() {
        homePage.addMacBookToCart();
    }

    @Then("a success alert is shown")
    public void assertAlertText() {
        String expected = "Success: You have added MacBook to your shopping cart!";
        String actual = homePage.getAlertMessageText();
        Assert.assertEquals(actual, expected, "Alert message text doesn't match");
    }

    @And("the product is shown on shopping cart page")
    public void verifyProductOnShoppingCart() {
        PageTransporter.goToShoppingCartPage();
        shoppingCartPage = new ShoppingCartPage();
        String actual = shoppingCartPage.getFirstProductNameOnCart();
        Assert.assertEquals(actual, "MacBook");
    }
}
