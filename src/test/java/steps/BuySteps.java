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
import ninjaStore.ui.pages.CartPage;
import ninjaStore.ui.pages.CheckoutPage;
import ninjaStore.ui.pages.HomePage;
import ninjaStore.ui.pages.PageTransporter;
import org.testng.Assert;

/**
 * BuySteps implemented all steps to buy feature.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class BuySteps {
    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    /**
     * Navigates to home page.
     */
    @When("the user goes to home page")
    public void theUserGoesToLoginPage() {
        PageTransporter.goToPage("home");
        homePage = new HomePage();
    }

    /**
     * Adds an available product to cart.
     */
    @When("the user adds MacBook product to cart")
    public void addProductToCart() {
        homePage.addMacBookToCart();
    }

    /**
     * Verifies the text on alert message.
     */
    @Then("a success alert is shown")
    public void assertAlertText() {
        String expected = "Success: You have added MacBook to your shopping cart!";
        String actual = homePage.getAlertMessageText();
        Assert.assertEquals(actual, expected, "Alert message text doesn't match");
    }

    /**
     * Verifies if the product is the first element on shopping cart list.
     */
    @Then("the product is shown on cart page")
    public void verifyProductOnShoppingCart() {
        PageTransporter.goToPage("cart");
        cartPage = new CartPage();
        String actual = cartPage.getFirstProductNameOnCart();
        Assert.assertEquals(actual, "MacBook");
    }

    @When("the user goes to cart page")
    public void theUserGoesToCartPage() {
        PageTransporter.goToPage("cart");
        cartPage = new CartPage();
    }

    @And("the user checkouts")
    public void theUserCheckouts() {
        cartPage.checkout();
        checkoutPage = new CheckoutPage();
    }

    @Then("billing details form is shown")
    public void billingDetailsFormIsShown() {
        Assert.assertEquals(checkoutPage.getNameLabelText(), "First Name");
    }

    @Given("there is a product on shopping cart")
    public void thereIsAProductOnShoppingCart() {
        PageTransporter.goToPage("home");
        homePage = new HomePage();
        homePage.addMacBookToCart();
    }
}
