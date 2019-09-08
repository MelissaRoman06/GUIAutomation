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

import org.testng.Assert;
import theNinjaStore.ui.pages.LoginPage;
import theNinjaStore.ui.utils.NinjaStoreConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * LoginSteps implemented all steps to login.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class LoginSteps {
    private LoginPage loginPage;

    /**
     * Constructor initializes loginPage.
     */
    public LoginSteps() {
        loginPage = new LoginPage();
    }

    /**
     * Enters credentials read on properties file.
     */
    @Given("the user enters his email and password")
    public void theUserEntersHisEmailAndPassword() {
        loginPage.enterEmail(NinjaStoreConfig.getInstance().getEmail());
        loginPage.enterPassword(NinjaStoreConfig.getInstance().getPassword());
    }

    /**
     * Presses login button.
     */
    @When("the user presses login button")
    public void theUserPressesLoginButton() {
        loginPage.pressLoginButton();
    }

    /**
     * Verifies the successful login.
     */
    @Then("successful login")
    public void userLoginSuccessfully() {
        Assert.assertEquals(loginPage.getText(), "My Account", "Not successful login");
    }
}
