/*
 * @(#) CalculadorPage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package theNinjaStore.ui.pages;

import theNinjaStore.ui.utils.Operations;
import theNinjaStore.ui.utils.OperatorXPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * CalculadoraPage class models theNinjaStore.org.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CalculadoraPage extends BasePage {
    private OperatorXPath operatorXPath;

    /**
     * Finds clear key by link text.
     */
    @FindBy(linkText = "C")
    WebElement clearKey;

    /**
     * Finds equal key by link text.
     */
    @FindBy(linkText = "=")
    WebElement equalKey;

    /**
     * Finds result text box key by name.
     */
    @FindBy(name = "expr")
    WebElement resultTextBox;

    /**
     * Finds decimal point key by xpath.
     */
    @FindBy(xpath = "(//a[contains(@href, '#')])[16]")
    WebElement pointKey;

    /**
     * Constructs the page asking for a web driver to web driver manager.
     */
    public CalculadoraPage() {
        super();
        this.driver.get("https://www.calculadora.org/");
        operatorXPath = new OperatorXPath();
    }

    /**
     * Allows to get the result from result text box.
     *
     * @return - Result of the performed operation.
     */
    public String getResult() {
        return resultTextBox.getAttribute("value");
    }

    /**
     * Presses the key according to string input.
     *
     * @param key - Key to be pressed.
     */
    public void pressKey(String key) {
        driver.findElement(By.linkText(key)).click();
    }

    /**
     * Presses the operator key according to operation enum input.
     *
     * @param operation - Operation key to be pressed.
     */
    public void pressOperator(Operations operation) {
        driver.findElement(By.xpath(operatorXPath.getKeyXPath(operation))).click();
    }

    /**
     * Clears the result from result text box by pressing C key.
     */
    public void clearResult() {
        clearKey.click();
    }

    /**
     * Presses equal key.
     */
    public void pressEqual() {
        equalKey.click();
    }

    /**
     * Enters the given number.
     *
     * @param number - Number to be entered.
     */
    public void enterNumber(double number) {
        String numberString = Double.toString(number);
        int numberLength = numberString.length();
        for (int index = 0; index < numberLength; index++) {
            char digitIndex = numberString.charAt(index);
            if (digitIndex == '.') {
                pointKey.click();
            } else {
                pressKey(Character.toString(digitIndex));
            }
        }
    }

    /**
     * Perform the given operation using the given numbers.
     *
     * @param number1   - First number to be entered.
     * @param number2   - Second number to be entered.
     * @param operation - Operation to be performed between the given numbers.
     */
    public void operation(double number1, double number2, Operations operation) {
        clearResult();
        enterNumber(number1);
        pressOperator(operation);
        enterNumber(number2);
        pressEqual();
    }
}
