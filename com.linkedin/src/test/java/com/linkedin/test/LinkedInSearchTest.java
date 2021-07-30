package com.linkedin.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.linkedin.page.LinkedInSearchPage;
import com.linkedin.utility.ConfigReader;
import com.opencsv.exceptions.CsvValidationException;

public class LinkedInSearchTest extends BaseTest {
	WebDriver driver;

	ConfigReader config = new ConfigReader();
	LinkedInSearchPage search;

	@Parameters({ "username", "password" })
	@Test
	public void Login(String username, String password) throws CsvValidationException, IOException {
		driver = new ChromeDriver();
		driver.get(config.getLinkedInUrl());
		search = new LinkedInSearchPage(driver);
		search.enterEmail(username);
		search.enterPassword(password);
		search.clickOnSignin();
		search.searchOnLinkedin();
		// driver.close();
	}
}
