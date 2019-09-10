/*
 * @(#) RunCukesTest.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import ninjaStore.report.ReportGenerator;
import ninjaStore.ui.pages.PageTransporter;
import org.testng.annotations.AfterTest;

/**
 * RunCukesTest class.
 *
 * @author Melissa Román
 * @version 1.0
 */
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-pretty",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"},
        glue = {"steps", "hooks"},
        features = {"src/test/resources/features/"},
        monochrome = true)
public class RunCukesTest extends AbstractTestNGCucumberTests {

    /**
     * Generates de report after the test execution. Also quits from the browser.
     */
    @AfterTest
    public void afterExecution() {
        ReportGenerator.generateReport();
        PageTransporter.getInstance().quit();
    }
}

