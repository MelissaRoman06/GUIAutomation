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
import ninjaStore.ui.pages.EditAccountPage;
import ninjaStore.ui.pages.HeaderPage;
import ninjaStore.ui.pages.LoginPage;
import ninjaStore.utils.NinjaStoreConfig;
import org.testng.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * LoginSteps implements all steps to login.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class LoginSteps {
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private AccountPage accountPage;
    private EditAccountPage editAccountPage;

    /**
     * Login reading credentials from properties file.
     */
    @When("the user login entering his email and password")
    public void login() {
        loginPage = new LoginPage();
        loginPage.login(NinjaStoreConfig.getInstance().getCredentials("email"),
                NinjaStoreConfig.getInstance().getCredentials("password"));
    }

    /**
     * Verifies the text in first title on account text.
     */
    @Then("My Account title is shown")
    public void verifySubtitle() {
        accountPage = new AccountPage();
        Assert.assertEquals(accountPage.getTextFirstTitle(), "My Account", "Subtitle text does not match");
    }

    /**
     * Verifies if logout option is in dropdown menu. If the account is logged in, logout option should be present.
     */
    @Then("logout option is on dropdown menu")
    public void verifyLogoutOption() {
        headerPage = new HeaderPage();
        Assert.assertEquals(headerPage.getLogoutText(), "Logout", "There is not logout option");
    }

    /**
     * Verifies if the email that appears on edit account page belongs to the user.
     */
    @Then("the used email appears on edit page")
    public void verifyEmailInEditAccount() {
        accountPage.pressEditAccount();
        editAccountPage = new EditAccountPage();
        Assert.assertEquals(editAccountPage.getEmailText(),
                NinjaStoreConfig.getInstance().getCredentials("email"));
    }
}
