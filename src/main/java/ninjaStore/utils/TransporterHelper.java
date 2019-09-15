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

import java.util.HashMap;
import java.util.Map;

/**
 * TransporterHelper is in charge of helping with URL to be used by the PageTransporter class.
 *
 * @author Melissa Román
 * @version 1.0
 */
public abstract class TransporterHelper {
    private final static Map<String, String> URL_SUFFIX = new HashMap<>();

    /**
     * The map has the corresponding browser to the key.
     */
    static {
        URL_SUFFIX.put("login", "account/login");
        URL_SUFFIX.put("home", "common/home");
        URL_SUFFIX.put("cart", "checkout/cart");
    }

    /**
     * Allows to get URL according given page name.
     *
     * @param pageName - Page name from which it is required the suffix.
     * @return - Concatenated URL with the suffix.
     */
    public static String getURL(final String pageName) {
        return NinjaStoreConfig.getInstance().getCredentials("baseURL") + URL_SUFFIX.get(pageName);
    }
}
