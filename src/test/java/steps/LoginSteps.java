package steps;

import theNinjaStore.ui.pages.LoginPage;
import theNinjaStore.ui.utils.NinjaStoreConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Given("the user enters his email and password")
    public void theUserEntersHisEmailAndPassword() {
        loginPage.enterEmail(NinjaStoreConfig.getInstance().getEmail());
        loginPage.enterPassword(NinjaStoreConfig.getInstance().getPassword());
    }

    @When("the user presses login button")
    public void theUserPressesLoginButton() {
        loginPage.pressLoginButton();
    }

    @Then("user login successfully")
    public void userLoginSuccessfully() {
        assertThat(loginPage.getText(), is("My Account"));
    }
}
