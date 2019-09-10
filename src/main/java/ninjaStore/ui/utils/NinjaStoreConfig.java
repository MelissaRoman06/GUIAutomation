/*
 * @(#) NinjaStoreConfig.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package ninjaStore.ui.utils;

import ninjaStore.utils.EventLogger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * NinjaStoreConfig class is charge of reading account credentials.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class NinjaStoreConfig {
    private String baseURL;
    private String loginURL;
    private String email;
    private String password;
    private static NinjaStoreConfig ninjaStoreConfigInstance;

    /**
     * Constructor NinjaStoreConfig.
     */
    protected NinjaStoreConfig() {
        readProperties();
    }

    /**
     * Gets the instance of NinjaStoreConfig.
     *
     * @return configInstance.
     */
    public static NinjaStoreConfig getInstance() {
        if (ninjaStoreConfigInstance == null) {
            ninjaStoreConfigInstance = new NinjaStoreConfig();
        }
        return ninjaStoreConfigInstance;
    }

    /**
     * Reads properties file for Ninja Store config.
     */
    public void readProperties() {
        try (InputStream input = new FileInputStream("ninjaStore.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            baseURL = properties.getProperty("baseURL");
            loginURL = properties.getProperty("loginURL");
            email = properties.getProperty("email");
            password = properties.getProperty("password");
        } catch (IOException ex) {
            ex.printStackTrace();
            EventLogger.error("Data for URL and account couldn't be retrieved from properties file", ex);
        }
    }

    /**
     * Allows to get properties login page URL.
     *
     * @return - Properties login page URL.
     */
    public String getLoginURL() {
        return loginURL;
    }

    /**
     * Allows to get properties base URL.
     *
     * @return - Properties base URL.
     */
    public String getBaseURL() {
        return baseURL;
    }

    /**
     * Allows to get properties email.
     *
     * @return - Properties email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Allows to get properties password.
     *
     * @return - Properties password.
     */
    public String getPassword() {
        return password;
    }
}
