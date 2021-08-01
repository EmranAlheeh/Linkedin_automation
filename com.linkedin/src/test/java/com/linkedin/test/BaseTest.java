package com.linkedin.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import com.linkedin.utility.ConfigReader;

public class BaseTest {
	WebDriver driver;
	ConfigReader config = new ConfigReader();

	@BeforeSuite
	public void runDriver() {
		System.setProperty(config.getWebDriver(), config.getChromeDriver());
	}

}
