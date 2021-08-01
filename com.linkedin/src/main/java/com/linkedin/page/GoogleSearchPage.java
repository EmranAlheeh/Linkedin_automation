package com.linkedin.page;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import com.linkedin.utility.CsvReadAndWrite;
import com.linkedin.utility.GoogleLocators;
import com.opencsv.exceptions.CsvValidationException;

public class GoogleSearchPage extends BasePage {
	WebDriver driver;
	CsvReadAndWrite csv;

	public GoogleSearchPage(WebDriver driver) {
		super(driver);
		csv = new CsvReadAndWrite();
	}

	public ArrayList<String> searchOnGoogle() throws IOException, CsvValidationException {

		String linkedIn = "linkedin.com";
		// search formula
		String searchContent = (csv.getDataForSearch() + " " + csv.getTypeOfSearch() + " " + linkedIn);

		waiteElement(GoogleLocators.searchInput);
		// search about this data
		sendKeysForInputAndClickEnter(GoogleLocators.searchInput, searchContent);

		// wait until the google page shows the result

		ArrayList<String> hrefOfGoogle = getListHrefOfElements(GoogleLocators.resultElements);
		return hrefOfGoogle;

	}

}
