package com.linkedin.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.linkedin.utility.ConfigReader;

public class BaseTest {
	WebDriver driver;
	ConfigReader config = new ConfigReader();

	@BeforeTest
	public void runDriver() {
		System.setProperty(config.getWebDriver(), config.getChromeDriver());
	}

}
