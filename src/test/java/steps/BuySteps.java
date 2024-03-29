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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ninjaStore.entities.Context;
import ninjaStore.ui.pages.CartPage;
import ninjaStore.ui.pages.CheckoutPage;
import ninjaStore.ui.pages.HomePage;
import ninjaStore.ui.PageTransporter;
import org.testng.Assert;

/**
 * BuySteps implements all steps to buy feature.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class BuySteps {
    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private Context context;

    /**
     * Initializes the class setting the context.
     *
     * @param context - Context to be set.
     */
    public BuySteps(final Context context) {
        this.context = context;
    }

    /**
     * Adds a product to cart according to given product name.
     * Product must be offered in home page.
     *
     * @param productName - Product's name.
     */
    @When("the user adds (.*) product to cart")
    public void addProductToCart(final String productName) {
        homePage = new HomePage();
        context.getProduct().setProductName(productName);
        homePage.addProductToCart(productName);
    }

    /**
     * Verifies if the product is in shopping cart table.
     */
    @Then("the product is displayed on cart page")
    public void verifyProductOnShoppingCart() {
        PageTransporter.goToPage("cart");
        cartPage = new CartPage();
        Assert.assertTrue(cartPage.isProductInCartTable(context.getProduct()));
    }

    /**
     * Checkouts from cart page by pressing the button.
     */
    @When("the user checkouts")
    public void checkout() {
        cartPage = new CartPage();
        cartPage.checkout();
        checkoutPage = new CheckoutPage();
    }

    /**
     * Verifies if the checkout options form is shown.
     */
    @Then("the checkout options form is shown")
    public void verifiesCheckoutOptionsForm() {
        Assert.assertEquals(checkoutPage.isCheckoutOptionsExpanded(), "true");
    }

    /**
     * Adds a MacBook to shopping cart as prerequisite.
     */
    @Given("there is a product on shopping cart")
    public void addProductOnShoppingCart() {
        PageTransporter.goToPage("home");
        homePage = new HomePage();
        homePage.addMacBookToCart();
    }

    /**
     * Verifies if the billing details form is shown.
     */
    @Then("the billing details form is shown")
    public void verifiesBillingDetailsForm() {
        Assert.assertEquals(checkoutPage.isBillingDetailsExpanded(), "true");
    }
}
