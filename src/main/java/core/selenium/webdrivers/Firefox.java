/*
 * @(#) Firefox.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package core.selenium.webdrivers;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class sets de Firefox driver.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class Firefox implements IBrowser {

    /**
     * Initializes Firefox driver.
     *
     * @return - New firefox driver.
     */
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver();
    }
}
