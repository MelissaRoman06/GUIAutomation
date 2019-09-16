/*
 * @(#) BrowserFactory.java Copyright (c) 2019 Jala Foundation.
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

import java.util.HashMap;
import java.util.Map;

/**
 * This class returns the required IBrowser.
 *
 * @author Melissa Román
 * @version 1.0
 */
public abstract class BrowserFactory {
    private static Map<String, IBrowser> browsers = new HashMap<>();

    /**
     * The map has the corresponding browser to the key.
     */
    static {
        browsers.put("chrome", new Chrome());
        browsers.put("firefox", new Firefox());
    }

    /**
     * Returns an IBrowser according to input.
     *
     * @param browserName - Required browser.
     * @return - The instance of required browser.
     */
    public static IBrowser getBrowser(final String browserName) {
        return browsers.get(browserName);
    }
}
