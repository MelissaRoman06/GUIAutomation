package ninjaStore.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * AccountPage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public final class AccountPage extends BasePage {
    private static AccountPage accountPageInstance;

    /**
     * Finds tittle on account page.
     */
    @FindBy(css = "h2:nth-child(1)")
    private WebElement myAccountTitle;


    /**
     * Constructs the page transporter with driver from parent class.
     */
    private AccountPage() {
        super();
    }

    /**
     * Gets the instance of AccountPage.
     *
     * @return accountPageInstance.
     */
    public static AccountPage getInstance() {
        if (accountPageInstance == null) {
            accountPageInstance = new AccountPage();
        }
        return accountPageInstance;
    }

    /**
     * Allows to get the text on page tittle.
     *
     * @return - Text on tittle.
     */
    public String getTextFirstTitle() {
        return myAccountTitle.getText();
    }
}
