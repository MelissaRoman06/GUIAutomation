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
import ninjaStore.ui.pages.*;
import ninjaStore.utils.CredentialsReader;
import org.apache.http.Header;
import org.testng.Assert;
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
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private AccountPage accountPage;
    private EditAccountPage editAccountPage;

    /**
     * Navigates to login page.
     */
    @Given("the user goes to login page")
    public void goToLoginPage() {
        PageTransporter.goToPage("login");
        loginPage = new LoginPage();
    }

    /**
     * Login reading credentials from properties file.
     */
    @When("the user login entering his email and password")
    public void login() {
        loginPage.enterCredentials(CredentialsReader.getInstance().getCredentials("email"),
                CredentialsReader.getInstance().getCredentials("password"));
        loginPage.pressLoginButton();
    }

    /**
     * Verifies the text in first title on account text.
     */
    @Then("My Account title is shown")
    public void verifySubtitle() {
        accountPage = new AccountPage();
        Assert.assertEquals(accountPage.getTextFirstTitle(), "My Account", "Subtitle text does not match");
    }

    @Then("logout option is on dropdown menu")
    public void logoutOptionIsOnDropdownMenu() {
        headerPage = new HeaderPage();
        Assert.assertEquals(headerPage.getLogoutText(), "Logout", "There is not logout option");
    }

    @Then("the used email appears on edit page")
    public void theUsedEmailAppearsOnEditPage() {
        accountPage.pressEditAccount();
        editAccountPage = new EditAccountPage();
        Assert.assertEquals(editAccountPage.getEmailText(),
                CredentialsReader.getInstance().getCredentials("email"));
    }
}
