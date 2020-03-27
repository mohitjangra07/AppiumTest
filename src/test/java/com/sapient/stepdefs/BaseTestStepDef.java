package com.sapient.stepdefs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sapient.utils.AppiumServerJava;
import com.sapient.utils.Config;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseTestStepDef {

	public static String userName = System.getProperty("userName", "mohitjangra1");
	public static String accessKey = System.getProperty("accessKey", "LN5FKp8Coeq36KJffq3q");
	public static String server = System.getProperty("server", "cloud");

	public static AppiumDriver<WebElement> driver;
	static DesiredCapabilities caps;

	@SuppressWarnings("unchecked")
	public static void SetupEnv(String server) throws MalformedURLException {

		caps = new DesiredCapabilities((Map<String, String>) Config.allCaps().get(server));

		if (server.equalsIgnoreCase("cloud")) {
			driver = new AppiumDriver<WebElement>(
					new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);
		} 
		else 
			if (server.equalsIgnoreCase("local")) {
			AppiumServerJava.appiumServer();
			driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		}
		
		launchAppURL();
		getWebviewContext();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static WebDriver getDriverInstance() {
		return driver;
	}

	public static void launchAppURL() {
		driver.get("https://www.wikipedia.org");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void getWebviewContext() {
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			if (contextName.contains("WEBVIEW")) {
				driver.context(contextName);
			}
		}
	}

	@Before
	public void beforeMethod() {
		try {
			SetupEnv(server);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@After
	public void afterMethod(Scenario scenario) {

		// Capture screenshot on failure
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png", "Failure Page Screenshot");
		}
	}
}
