package com.linkedin.test;

import org.testng.annotations.Test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.linkedin.page.LinkedInSearchPage;
import com.linkedin.utility.LinkedInLocatores;
import com.linkedin.utility.ReadExcelFile;

@Listeners(com.linkedin.test.ListenerTest.class)
public class LinkedInLoginTest extends BaseTest {
	WebDriver driver;

	LinkedInSearchPage search;

	@Test(dataProvider = "testdata")
	public void Login(String username, String password) throws Exception {

		driver = new ChromeDriver();
		driver.get(config.getLinkedInUrl());
		search = new LinkedInSearchPage(driver);
		search.enterEmail(username);
		search.enterPassword(password);
		search.clickOnSignin();
		String validLoginUrl = "https://www.linkedin.com/feed/?trk=guest_homepage-basic_nav-header-signin";
		// String inValidLoginUrl =
		// "https://www.linkedin.com/checkpoint/lg/login-submit";
		if (validLoginUrl.equals(search.getPageUrl())) {
			System.out.println("Valid login test is passed");
		} else {
			System.out.println("Invalid login test is passed");
		}
		driver.quit();
	}

	@Test
	@DataProvider(name = "testdata")
	public Object[][] testData() throws IOException {

		Object[][] arrObj = ReadExcelFile.getExcelData(LinkedInLocatores.exelPath, "sheet1");
		return arrObj;
	}

}
