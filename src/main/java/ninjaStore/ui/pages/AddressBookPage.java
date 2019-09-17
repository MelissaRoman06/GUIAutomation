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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * AddressBookPage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class AddressBookPage extends BasePage {
    private static final String ADDRESS_CELL_LOCATOR = "//td[text()='%s']"; // Used to find where address is located.
                                                                // It only finds the first appearance of the address.
    private static final String ANCESTOR_SUFFIX_TR = "/ancestor::tr"; // Used to find row from cell in table.

    private By deleteButtonLocation = By.cssSelector("a[href*='delete']"); // Used to find the delete button from
                                                                            // address row.

    /**
     * Verifies if given address is in address entries book.
     *
     * @param address - Address to find.
     * @return - True if the address is found.
     */
    public boolean isAddressInTable(final Address address) {
        WebElement addressCell = getAddressCellElementByAddress(address);
        return addressCell.getText().equals(address.getAddressString());
    }

    /**
     * Allows to get the cell web element where the address is according to its full name.
     * It only finds the first appearance of the address.
     *
     * @param address - Address to be found.
     * @return - Cell web element where the address appears.
     */
    private WebElement getAddressCellElementByAddress(final Address address) {
        return driver.findElement(By.xpath(String.format(ADDRESS_CELL_LOCATOR, address.getFullName())));
    }

    /**
     * Allows to get the row web element where the address is according to its full name.
     * It only finds the first appearance of the address.
     * Returns the ancestor of the cell where address is found.
     *
     * @param address - Address to be found.
     * @return - Row web element where the address appears.
     */
    private WebElement getAddressRowElementByAddress(final Address address) {
        return driver.findElement(By.xpath(String.format(ADDRESS_CELL_LOCATOR, address.getFullName())
                + ANCESTOR_SUFFIX_TR));
    }

    /**
     * Deletes given address from address book entries.
     *
     * @param address - Address to be deleted.
     */
    public void deleteAddress(final Address address) {
        WebElement addressRow = getAddressRowElementByAddress(address);
        WebElement deleteButton = addressRow.findElement(deleteButtonLocation);
        deleteButton.click();
    }
}
