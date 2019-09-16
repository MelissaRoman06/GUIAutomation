/*
 * @(#) AddressBookHooks.java Copyright (c) 2019 Jala Foundation.
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
import ninjaStore.entities.Context;
import ninjaStore.ui.pages.AddressBookPage;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;

/**
 * AddressBookHooks class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class AddressBookHooks {
    private WebDriver driver;
    private AddressBookPage addressBookPage;
    private Context context;

    /**
     * Initializes getting the web driver from web driver manager.
     *
     * @param context - Context to be set.
     */
    public AddressBookHooks(Context context) {
        driver = WebDriverManager.getInstance().getWebDriver();
        this.context = context;
    }

    /**
     * Deletes context's address from address book entries.
     */
    @After("@DeleteAddress")
    public void deleteAddress() {
        addressBookPage = new AddressBookPage();
        addressBookPage.deleteAddress(context.getAddress());
    }
}
