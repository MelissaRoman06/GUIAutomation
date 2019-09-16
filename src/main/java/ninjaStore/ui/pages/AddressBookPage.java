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
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * AddressBookPage class models the used WebElements and actions for that page.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class AddressBookPage extends BasePage {
    private By alert = By.cssSelector(".alert");
    private By tableXpath = By.xpath("//div[@id='content']/div[1]/table/tbody/tr");

    /**
     * Gets alert message text.
     *
     * @return - Alert message text.
     */
    public String getAlertMessageText() {
        WebElement alertMessage = wait.until(ExpectedConditions
                .visibilityOfElementLocated(alert));
        return alertMessage.getText();
    }

    /**
     * Verifies if given address is in address entries book.
     *
     * @param address - Address to find.
     * @return - True if the address is found.
     */
    public boolean isAddressInTable(final Address address) {
        boolean isFound = false;
        int cantRows = driver.findElements(tableXpath).size();
        for (int index = 1; index <= cantRows; index++) {
            String xpathByIndex = String.format("//div[@id='content']/div[1]/table/tbody/tr[%d]/td[1]", index);
            if (driver.findElement(By.xpath(xpathByIndex)).getText().equals(address.getAddressString())) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    /**
     * Deletes given address from address book entries.
     *
     * @param address - Address to be deleted.
     */
    public void deleteAddress(final Address address) {
        int cantRows = driver.findElements(tableXpath).size();
        for (int index = 1; index <= cantRows; index++) {
            String xpathByIndex = String.format("//div[@id='content']/div[1]/table/tbody/tr[%d]/td[1]", index);
            if (driver.findElement(By.xpath(xpathByIndex)).getText().equals(address.getAddressString())) {
                String deleteXpath = String.format("//div[@id='content']/div[1]/table/tbody/tr[%d]/td[2] "
                        + "//a[@class='btn btn-danger']", index);
                driver.findElement(By.xpath(deleteXpath)).click();
                break;
            }
        }
    }
}
