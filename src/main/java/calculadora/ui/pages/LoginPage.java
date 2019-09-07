package calculadora.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "input-email")
    WebElement emailBox;

    @FindBy(id = "input-password")
    WebElement passwordBox;

    @FindBy(css = ".btn:nth-child(3)")
    WebElement loginButton;

    /**
     * Constructs the page asking for a web driver to web driver manager.
     */
    public LoginPage() {
        super();
        this.driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
    }

    public void enterEmail(String email) {
        emailBox.click();
        emailBox.sendKeys(email);

    }

    public void enterPassword(String password) {
        passwordBox.click();
        passwordBox.sendKeys(password);
    }

    public void pressLoginButton() {
        loginButton.click();
    }

    @FindBy(css = "h2:nth-child(1)")
    WebElement myAccountTittle;

    public String getText() {
        return myAccountTittle.getText();
    }
}
