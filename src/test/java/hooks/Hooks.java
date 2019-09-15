/*
 * @(#) Hooks.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package hooks;

import core.selenium.WebDriverManager;
import cucumber.api.java.After;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import ninjaStore.ui.pages.HeaderPage;
import ninjaStore.ui.pages.LoginPage;
import ninjaStore.ui.pages.PageTransporter;
import ninjaStore.utils.NinjaStoreConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Hooks class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class Hooks {
    private WebDriver driver;
    private LoginPage loginPage;
    private HeaderPage headerPage;

    /**
     * Initializes getting the web driver from web driver manager.
     */
    public Hooks() {
        driver = WebDriverManager.getInstance().getWebDriver();
    }

    /**
     * Logout from the session account.
     */
    @After("@Login")
    public void logout() {
        headerPage = new HeaderPage();
        headerPage.logout();
    }

    /**
     * Takes screenshot after the scenario if it has failed.
     *
     * @param scenario - Scenario to test.
     */
    @After
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

    /**
     * Log in to the user account getting the credentials from properties file.
     */
    @Before("@CheckLogin")
    public void checkLogin() {
        PageTransporter.goToPage("home");
        headerPage = new HeaderPage();
        headerPage.dropDownAccountMenu();
        try {
            System.out.println("intenta");
            System.out.println(headerPage.getLoginText());
            if("Login".equals(headerPage.getLoginText())) {
                System.out.println("tiene que hacer login");
                headerPage.pressLogin();
                loginPage = new LoginPage();
                loginPage.enterCredentials(NinjaStoreConfig.getInstance().getCredentials("email"),
                        NinjaStoreConfig.getInstance().getCredentials("password"));
            }
        } catch (Exception e) {
            System.out.println("no necesita hacer login");
        }
    }
}
