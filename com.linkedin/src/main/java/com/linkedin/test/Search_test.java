package com.linkedin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.linkedin.page.Search_page;
import com.linkedin.utility.ConfigReader;

 

public class Search_test {
	WebDriver driver; 
	ConfigReader config =new ConfigReader();
	Search_page search;
	 
	@BeforeTest
	public void setup(){
 		System.setProperty(config.getWebDriver(), config.getChromeDriver());
		 driver = new ChromeDriver();
		driver.get(config.getUrl());
 		 
	}
	@Parameters({"username","password"})
	 
	@Test
	public void validLogin( String username,String password) {
		 
		search = new Search_page(driver);
		search.enterEmail(username);
		search.enterPassword(password);
		search.clickOnSignin();
		 
	}
}
