/*
 * @(#) LoginSteps.java Copyright (c) 2019 Jala Foundation.
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

import ninjaStore.ui.pages.AccountPage;
import ninjaStore.ui.pages.PageTransporter;
import org.testng.Assert;
import ninjaStore.ui.pages.LoginPage;
import ninjaStore.utils.NinjaStoreConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * LoginSteps implemented all steps to login.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class LoginSteps {

    /**
     * Navigates to login page.
     */
    @Given("the user goes to login page")
    public void theUserGoesToLoginPage() {
        PageTransporter.getInstance().goToLoginPage();
    }

    /**
     * Login reading credentials from properties file.
     */
    @When("the user login entering his email and password")
    public void theUserLoginEnteringHisEmailAndPassword() {
        LoginPage.getInstance().enterCredentials(NinjaStoreConfig.getInstance().getEmail(),
                NinjaStoreConfig.getInstance().getPassword());
        LoginPage.getInstance().pressLoginButton();
    }

    /**
     * Verifies the text in first title on account text.
     *
     * @param title - Expected title.
     */
    @Then("{string} title is shown")
    public void tittleIsShown(final String title) {
        Assert.assertEquals(AccountPage.getInstance().getTextFirstTitle(), title, "Not successful login");
    }
}
