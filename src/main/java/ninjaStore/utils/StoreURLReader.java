/*
 * @(#) StoreURLConfig.java Copyright (c) 2019 Jala Foundation.
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

import core.selenium.WebDriverConfig;
import org.apache.log4j.Logger;

import java.util.Properties;

/**
 * StoreURLConfig class is charge of reading account credentials.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class StoreURLReader {
    private Properties properties;
    private static StoreURLReader configInstance;
    private static Logger logger;

    /**
     * Constructor NinjaStoreConfig.
     */
    protected StoreURLReader() {
        properties = PropertiesReader.getProperties("ninjaStoreURL.properties");
        logger = Logger.getLogger(WebDriverConfig.class.getName());
    }

    /**
     * Gets the instance of StoreURLConfig.
     *
     * @return configInstance.
     */
    public static StoreURLReader getInstance() {
        if (configInstance == null) {
            configInstance = new StoreURLReader();
        }
        return configInstance;
    }

    /**
     * Allows to get required URL according to input.
     *
     * @param property - Required property name.
     * @return URL.
     */
    public String getURL(final String property) {
        return properties.getProperty(property);
    }
}
