package com.linkedin.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.linkedin.utility.CsvReadAndWrite;
import com.linkedin.utility.LinkedInLocatores;
import com.opencsv.exceptions.CsvValidationException;

public class LinkedInSearchPage extends BasePage {
	CsvReadAndWrite csv;

	public LinkedInSearchPage(WebDriver driver) {
		super(driver);
		csv = new CsvReadAndWrite();
	}

	public void enterEmail(String arg) {
		waiteElement(LinkedInLocatores.email);
		sendKeysForInput(LinkedInLocatores.email, arg);
	}

	public void enterPassword(String arg1) {
		waiteElement(LinkedInLocatores.password);
		sendKeysForInput(LinkedInLocatores.password, arg1);
	}

	public void clickOnSignin() {
		waiteElement(LinkedInLocatores.signin);
		clickOnElement(LinkedInLocatores.signin);
	}

	public void searchOnLinkedin() throws IOException, CsvValidationException {

		String filter = (LinkedInLocatores.filterLocators + csv.getTypeOfSearch() + "']");

		waiteElement(LinkedInLocatores.searchInput);
		sendKeysForInputAndClickEnter(LinkedInLocatores.searchInput, csv.getDataForSearch());
		waiteElement(By.xpath(filter));
		clickOnElement(By.xpath(filter));
		// wait until the google page shows the result
		// getHrefOfElements(By.className("app-aware-link"), 8);
	}
//	public void closeChrome() {
//		
//		driver.close();
//	}
}
