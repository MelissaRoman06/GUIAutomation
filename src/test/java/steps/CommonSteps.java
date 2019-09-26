/*
 * @(#) CommonSteps.java Copyright (c) 2019 Jala Foundation.
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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ninjaStore.entities.Context;
import ninjaStore.ui.PageTransporter;
import ninjaStore.ui.pages.HeaderPage;
import org.testng.Assert;

/**
 * CommonSteps implemented all common steps.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CommonSteps {
    private HeaderPage headerPage;
    private Context context;

    /**
     * Initializes the class setting the context.
     *
     * @param context - Context to be set.
     */
    public CommonSteps(final Context context) {
        this.context = context;
    }

    /**
     * Navigates to given page.
     *
     * @param pageName - Page name to redirect.
     */
    @When("the user goes to (.*) page")
    public void goToPage(final String pageName) {
        PageTransporter.goToPage(pageName);
    }

    /**
     * Verifies the text displayed on alert ignoring the name of the product.
     *
     * @param alertMessage - Expected alert message.
     */
    @Then("an alert (.*) is displayed")
    public void verifyAlert(final String alertMessage) {
        headerPage = new HeaderPage();
        String actual = headerPage.getAlertMessageText();
        Assert.assertEquals(actual.replaceAll(context.getProduct().getProductName() + " ", ""),
                alertMessage);
    }
}
