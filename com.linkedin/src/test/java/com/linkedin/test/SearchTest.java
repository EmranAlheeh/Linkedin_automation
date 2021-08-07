package com.linkedin.test;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.linkedin.page.GoogleSearchPage;
import com.linkedin.page.LinkedInSearchPage;
import com.linkedin.utility.ConfigReader;
import com.opencsv.exceptions.CsvValidationException;

public class SearchTest extends BaseTest {
	WebDriver driver;
	ConfigReader config = new ConfigReader();
	GoogleSearchPage googlePage;
	LinkedInSearchPage search;

	@Parameters({ "username", "password" })
	@Test
	public void searchTest(String username, String password) throws CsvValidationException, IOException {
		driver = new ChromeDriver();
		driver.get(config.getLinkedInUrl());
		search = new LinkedInSearchPage(driver);
		search.enterEmail(username);
		search.enterPassword(password);
		search.clickOnSignin();
		ArrayList<String>hrefOfLinkedIn= search.searchOnLinkedinAndReturnResults();
		driver.get(config.getGoogleUrl());
		googlePage = new GoogleSearchPage(driver);
		ArrayList<String>hrefOfGoogle=googlePage.searchOnGoogleAndReturnHrefOfResults();
		Assert.assertNotEquals(hrefOfLinkedIn, hrefOfGoogle);
	}

}
