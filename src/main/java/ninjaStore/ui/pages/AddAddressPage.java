/*
 * @(#) AddAddressPage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package ninjaStore.ui.pages;

import ninjaStore.entities.Address;
import ninjaStore.ui.BasePage;
import ninjaStore.utils.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * AddAddressPage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class AddAddressPage extends BasePage {
    private By inputCountry = By.id("input-country");
    private By inputRegion = By.id("input-zone");

    /**
     * First name text box.
     */
    @FindBy(id = "input-firstname")
    private WebElement firstNameTextBox;

    /**
     * Last name text box.
     */
    @FindBy(id = "input-lastname")
    private WebElement lastNameTextBox;

    /**
     * Address 1 text box.
     */
    @FindBy(id = "input-address-1")
    private WebElement address1TextBox;

    /**
     * City text box.
     */
    @FindBy(id = "input-city")
    private WebElement cityTextBox;

    /**
     * Post Code text box.
     */
    @FindBy(id = "input-postcode")
    private WebElement postCodeTextBox;

    /**
     * Country combo box.
     */
    @FindBy(id = "input-country")
    private WebElement countryComboBox;

    /**
     * Region/State combo box.
     */
    @FindBy(id = "input-zone")
    private WebElement regionStateComboBox;

    /**
     * Continue button.
     */
    @FindBy(xpath = "//div[@id='content']/form/div/div[2]/input")
    private WebElement continueButton;

    /**
     * Fills form with data saved in given address.
     *
     * @param address - Address from which the data will be retrieved to fill the form.
     */
    public void fillForm(final Address address) {
        WebDriverHelper.enterKeys(firstNameTextBox, address.getFirstName());
        WebDriverHelper.enterKeys(lastNameTextBox, address.getLastName());
        WebDriverHelper.enterKeys(address1TextBox, address.getAddress1());
        WebDriverHelper.enterKeys(cityTextBox, address.getCity());
        WebDriverHelper.enterKeys(postCodeTextBox, address.getPostCode());
        WebElement dropdownCountry = driver.findElement(inputCountry);
        String xpathCountry = String.format("//option[. = '%s']", address.getCountry());
        dropdownCountry.findElement(By.xpath(xpathCountry)).click();
        WebElement dropdownRegion = driver.findElement(inputRegion);
        String xpathRegion = String.format("//option[. = '%s']", address.getRegionState());
        dropdownRegion.findElement(By.xpath(xpathRegion)).click();
        continueButton.click();
    }
}
