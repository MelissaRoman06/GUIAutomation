/*
 * @(#) StoreCredentialsConfig.java Copyright (c) 2019 Jala Foundation.
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
 * StoreCredentialsConfig class is charge of reading account credentials.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CredentialsReader {
    private Properties properties;
    private static CredentialsReader configInstance;
    private static Logger logger;

    /**
     * Constructor StoreCredentialsConfig.
     */
    protected CredentialsReader() {
        properties = PropertiesReader.getProperties("ninjaStoreCredentials.properties");
        logger = Logger.getLogger(WebDriverConfig.class.getName());
    }

    /**
     * Gets the instance of StoreCredentialsConfig.
     *
     * @return configInstance.
     */
    public static CredentialsReader getInstance() {
        if (configInstance == null) {
            configInstance = new CredentialsReader();
        }
        return configInstance;
    }

    /**
     * Allows to get required URL according to input.
     *
     * @param property - Required property name.
     * @return URL.
     */
    public String getCredentials(final String property) {
        return properties.getProperty(property);
    }
}
