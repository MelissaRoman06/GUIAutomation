/*
 * @(#) AddressBookSteps.java Copyright (c) 2019 Jala Foundation.
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
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ninjaStore.entities.Context;
import ninjaStore.ui.pages.AddAddressPage;
import ninjaStore.ui.pages.AddressBookPage;
import org.testng.Assert;

import java.util.Map;

/**
 * AddressBookSteps implements all required steps for Address book management feature.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class AddressBookSteps {
    private AddAddressPage addAddressPage;
    private AddressBookPage addressBookPage;
    private Context context;

    /**
     * Initializes the class setting the context.
     *
     * @param context - Context to be set.
     */
    public AddressBookSteps(Context context) {
        this.context = context;
    }

    /**
     * Adds an available product offered on home page to cart.
     */
    @When("the user adds a new address with minimum data required")
    public void addProductToCart(Map<String, String> inputFields) {
        addAddressPage = new AddAddressPage();
        context.getAddress().setAddress(inputFields);
        addAddressPage.fillForm(context.getAddress());
    }

    /**
     * Verifies the text displayed on alert.
     *
     * @param alertMessage - Expected alert message.
     */
    @Then("a alert (.*) is displayed")
    public void verifyAlert(String alertMessage) {
        addressBookPage = new AddressBookPage();
        String actual = addressBookPage.getAlertMessageText();
        Assert.assertEquals(actual, alertMessage);
    }

    /**
     * Verifies if address appears on address book entries table.
     */
    @And("the address appears on Address Book Entries table")
    public void theAddressAppearsOnAddressBookEntriesTable() {
        Assert.assertTrue(addressBookPage.isAddressInTable(context.getAddress()));
    }
}
