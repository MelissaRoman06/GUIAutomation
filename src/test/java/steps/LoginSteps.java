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

import cucumber.api.java.en.And;
import ninjaStore.ui.pages.PageTransporter;
import org.testng.Assert;
import ninjaStore.ui.pages.LoginPage;
import ninjaStore.ui.utils.NinjaStoreConfig;
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
     * Enters credentials read on properties file.
     */
    @And("the user enters his email and password")
    public void theUserEntersHisEmailAndPassword() {
        LoginPage.getInstance().enterEmail(NinjaStoreConfig.getInstance().getEmail());
        LoginPage.getInstance().enterPassword(NinjaStoreConfig.getInstance().getPassword());
    }

    /**
     * Presses login button.
     */
    @When("the user presses login button")
    public void theUserPressesLoginButton() {
        LoginPage.getInstance().pressLoginButton();
    }

    /**
     * Verifies the successful login.
     */
    @Then("successful login")
    public void userLoginSuccessfully() {
        Assert.assertEquals(LoginPage.getInstance().getText(), "My Account", "Not successful login");
    }

    /**
     * Navigates to login page.
     */
    @Given("the user goes to login page")
    public void theUserGoesToLoginPage() {
        PageTransporter.goToLoginPage();
    }
}
