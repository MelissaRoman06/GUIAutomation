/*
 * @(#) CommonSteps.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package steps;

import cucumber.api.java.en.When;
import ninjaStore.ui.PageTransporter;

/**
 * CommonSteps implemented all common steps.
 *
 * @author Melissa Román
 * @version 1.0
 */
public class CommonSteps {

    /**
     * Navigates to given page.
     */
    @When("the user goes to (.*) page")
    public void goToPage(String pageName) {
        PageTransporter.goToPage(pageName);
    }
}
