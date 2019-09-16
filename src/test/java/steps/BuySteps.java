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
    public BuySteps(Context context) {
        this.context = context;
    }

    /**
     * Adds an available product offered on home page to cart.
     */
    @When("the user adds (.*) product to cart")
    public void addProductToCart(String productName) {
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
        Assert.assertTrue(cartPage.isProductInCartTable(context.getProduct().getProductName()));
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
    public void verifiesCheckoutOptionsSubtitle() {
        Assert.assertEquals(checkoutPage.getFirstSubtitleText(), "Step 1: Checkout Options");
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
     * Verifies the text of empty cart label.
     */
    @Then("the shopping cart is empty message is shown")
    public void verifyEmptyCartLabel() {
        Assert.assertEquals(cartPage.getEmptyCartLabelText(), "Your shopping cart is empty!");
    }

    /**
     * Verifies if the billing details form is shown.
     */
    @Then("the billing details form is shown")
    public void verifiesBillingDetailsSubtitle() {
        Assert.assertEquals(checkoutPage.getSecondSubtitleText(), "Step 2: Billing Details");
    }

    /**
     * Verifies the text displayed on alert ignoring the name of the product.
     *
     * @param alertMessage - Expected alert message.
     */
    @Then("an alert (.*) is displayed")
    public void verifyAlert(String alertMessage) {
        String actual = homePage.getAlertMessageText();
        Assert.assertEquals(actual.replaceAll(context.getProduct().getProductName() + " ", ""),
                alertMessage);
    }
}
