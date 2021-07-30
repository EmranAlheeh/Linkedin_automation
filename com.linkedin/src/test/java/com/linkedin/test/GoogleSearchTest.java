package com.linkedin.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.linkedin.page.GoogleSearchPage;
import com.linkedin.utility.ConfigReader;
import com.opencsv.exceptions.CsvValidationException;

public class GoogleSearchTest extends BaseTest {
	WebDriver driver;
	ConfigReader config = new ConfigReader();
	GoogleSearchPage googlePage;

	@Test
	public void search() throws CsvValidationException, IOException {
		driver = new ChromeDriver();
		driver.get(config.getGoogleUrl());
		googlePage = new GoogleSearchPage(driver);
		googlePage.searchOnGoogle();
		// googlePage.closeChrome();
		// driver.quit();

	}

}
