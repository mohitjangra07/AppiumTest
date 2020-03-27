package com.sapient.TestRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.sapient.stepdefs.BaseTestStepDef;
import com.sapient.utils.AppiumServerJava;
import com.sapient.utils.GenerateTestReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/Features",
		glue = { "com.sapient.stepdefs" },
		plugin = {"json:target/cucumber.json" },
		stepNotifications = true)

public class TestRunner {

	@AfterClass
	public static void teardown() {
		AppiumServerJava appiumServer = new AppiumServerJava();
		GenerateTestReport.generateCucumberReport();
		appiumServer.stopServer();

		// Close the driver
		if (BaseTestStepDef.driver != null) {
			BaseTestStepDef.driver.quit();
		}
	}
}
