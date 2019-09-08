/*
 * @(#) OperatorXPath.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package theNinjaStore.ui.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * This class has a hash map used to parse Operations enum to corresponding key symbol.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class OperatorXPath {
    private Map<Operations, String> operators;

    /**
     * Sets hash map content.
     */
    public OperatorXPath() {
        operators = new HashMap<Operations, String>() {{
            put(Operations.ADD, "(//a[contains(@href, '#')])[18]");
            put(Operations.SUBTRACT, "(//a[contains(@href, '#')])[13]");
            put(Operations.MULTIPLY, "(//a[contains(@href, '#')])[9]");
            put(Operations.DIVIDE, "(//a[contains(@href, '#')])[4]");
        }};
    }

    /**
     * Allows to get key symbol of the requested operation.
     * @param operation - An option from Operations enum.
     * @return - Key symbol which corresponds to operation input.
     */
    public String getKeyXPath(Operations operation) {
        return operators.get(operation);
    }
}
