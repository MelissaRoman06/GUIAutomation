package steps;

import calculadora.ui.pages.LoginPage;
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
        loginPage.enterEmail("melissa.roman@fundacion-jala.org");
        loginPage.enterPassword("m8046119R");
    }

    @When("the user presses login button")
    public void theUserPressesLoginButton() {
        loginPage.pressLoginButton();
    }

    @Then("{string} text is displayed")
    public void textIsDisplayed(String tittle) {
        assertThat(loginPage.getText(), is(tittle));
    }
}
