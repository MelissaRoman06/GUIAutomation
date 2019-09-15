/*
 * @(#) TransporterHelper.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package ninjaStore.utils;

import org.openqa.selenium.WebElement;

/**
 * WebDriverHelper is in charge of utilities common methods to interact with the we application.
 *
 * @author Melissa Román
 * @version 1.0
 */
public abstract class WebDriverHelper {

    /**
     * Enters string into given web element. This will be moved to a util class.
     *
     * @param textBox    - TextBox to enter the keys.
     * @param stringKeys - Keys to be entered.
     */
    public static void enterKeys(final WebElement textBox, final String stringKeys) {
        textBox.click();
        textBox.clear();
        textBox.sendKeys(stringKeys);
    }
}
