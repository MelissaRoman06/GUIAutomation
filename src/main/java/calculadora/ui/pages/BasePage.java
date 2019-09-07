package calculadora.ui.pages;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = WebDriverManager.getInstance().getWebDriver();
        PageFactory.initElements(driver, this);
        this.wait = WebDriverManager.getInstance().getWait();
    }
}
