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
import ninjaStore.utils.CredentialsReader;
import org.testng.Assert;
import ninjaStore.ui.pages.LoginPage;
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
    private AccountPage accountPage;

    /**
     * Navigates to login page.
     */
    @Given("the user goes to login page")
    public void theUserGoesToLoginPage() {
        PageTransporter.goToPage("login");
        loginPage = new LoginPage();
    }

    /**
     * Login reading credentials from properties file.
     */
    @When("the user login entering his email and password")
    public void theUserLoginEnteringHisEmailAndPassword() {
        loginPage.enterCredentials(CredentialsReader.getInstance().getCredentials("email"),
                CredentialsReader.getInstance().getCredentials("password"));
        loginPage.pressLoginButton();
    }

    /**
     * Verifies the text in first title on account text.
     *
     * @param title - Expected title.
     */
    @Then("{string} title is shown")
    public void verifySubtitle(final String title) {
        accountPage = new AccountPage();
        Assert.assertEquals(accountPage.getTextFirstTitle(), title, "Subtitle text does not match");
    }
}
