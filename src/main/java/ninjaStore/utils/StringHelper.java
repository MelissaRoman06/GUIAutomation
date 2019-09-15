/*
 * @(#) StringHelper.java Copyright (c) 2019 Jala Foundation.
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

/**
 * StringHelper is in charge of helping with string processing.
 *
 * @author Melissa Román
 * @version 1.0
 */
public abstract class StringHelper {

    /**
     * Allows to get string until line break.
     *
     * @param stringToBeCut - String from which is it required the text before line break.
     * @return - Cut string until line break.
     */
    public static String getUntilLineBreak(String stringToBeCut) {
        int indexOfMessageFinish = stringToBeCut.indexOf("\n");
        String cutString = stringToBeCut.substring(0, indexOfMessageFinish);
        return cutString;
    }
}
