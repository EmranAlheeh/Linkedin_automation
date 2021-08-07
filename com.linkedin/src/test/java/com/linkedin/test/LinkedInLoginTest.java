package com.linkedin.test;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import com.linkedin.page.LinkedInSearchPage;
import com.linkedin.utility.LinkedInLocatores;
import com.linkedin.utility.ReadExcelFile;

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
	}

	@DataProvider(name = "testdata")
	public Object[][] testData() throws IOException {
		 
		Object[][] arrObj = ReadExcelFile.getExcelData(LinkedInLocatores.exelPath, "sheet1");
		return arrObj;
	}

	 
}
