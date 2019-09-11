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
package ninjaStore.utils;

import core.selenium.WebDriverConfig;
import org.apache.log4j.Logger;

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
    private String loginURL;
    private String homeURL;
    private String shoppingCartURL;
    private String email;
    private String password;
    private static NinjaStoreConfig ninjaStoreConfigInstance;
    private static Logger logger;

    /**
     * Constructor NinjaStoreConfig.
     */
    protected NinjaStoreConfig() {
        readProperties();
        logger = Logger.getLogger(WebDriverConfig.class.getName());
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
            loginURL = properties.getProperty("loginURL");
            homeURL = properties.getProperty("homeURL");
            shoppingCartURL = properties.getProperty("shoppingCartURL");
            email = properties.getProperty("email");
            password = properties.getProperty("password");
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.error("Data for URL and account couldn't be retrieved from properties file", ex);
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
     * Allows to get properties home URL.
     *
     * @return - Properties home URL.
     */
    public String getHomeURL() {
        return homeURL;
    }

    /**
     * Allows to get properties home URL.
     *
     * @return - Properties home URL.
     */
    public String getShoppingCartURL() {
        return shoppingCartURL;
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
