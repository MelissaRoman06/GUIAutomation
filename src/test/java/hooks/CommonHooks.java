/*
 * @(#) CommonHooks.java Copyright (c) 2019 Jala Foundation.
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
import ninjaStore.ui.PageTransporter;
import ninjaStore.utils.NinjaStoreConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * CommonHooks class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CommonHooks {
    private WebDriver driver;
    private LoginPage loginPage;
    private HeaderPage headerPage;

    /**
     * Initializes getting the web driver from web driver manager.
     */
    public CommonHooks() {
        driver = WebDriverManager.getInstance().getWebDriver();
    }

    /**
     * Takes screenshot after the scenario if it has failed.
     *
     * @param scenario - Scenario to test.
     */
    @After
    public void takeScreenshot(final Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

    /**
     * Checks if the user is already logged in. If not, logs in.
     */
    @Before("@CheckLogin")
    public void checkLogin() {
        PageTransporter.goToPage("home");
        headerPage = new HeaderPage();
        headerPage.dropDownAccountMenu();
        try {
            if ("Login".equals(headerPage.getLoginText())) {
                headerPage.pressLogin();
                loginPage = new LoginPage();
                loginPage.login(NinjaStoreConfig.getInstance().getCredentials("email"),
                        NinjaStoreConfig.getInstance().getCredentials("password"));
            }
        } catch (Exception e) {
        }
    }

    /**
     * Checks if the user is already logged out. If not, logs out.
     */
    @Before("@CheckLogout")
    public void checkLogout() {
        PageTransporter.goToPage("home");
        headerPage = new HeaderPage();
        headerPage.dropDownAccountMenu();
        try {
            if ("Logout".equals(headerPage.getLogoutText())) {
                headerPage.pressLogout();
            }
        } catch (Exception e) {
        }
    }
}
