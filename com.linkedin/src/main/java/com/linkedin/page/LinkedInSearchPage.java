package com.linkedin.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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

	public ArrayList<String> searchOnLinkedin() throws IOException, CsvValidationException {
		// filter locator xpath
		String filter = (LinkedInLocatores.filterLocators + csv.getTypeOfSearch() + "']");

		waiteElement(LinkedInLocatores.searchInput);
		sendKeysForInputAndClickEnter(LinkedInLocatores.searchInput, csv.getDataForSearch());
		waiteElement(By.xpath(filter));
		clickOnElement(By.xpath(filter));

		ArrayList<String> href = getListHrefOfElements(By.className("app-aware-link"));

		return href;

	}

	public ArrayList<String> GetProfileName() {
		waiteElement(By.xpath(
				"//*[@id=\"main\"]/div/div/div[2]/ul/li/div/div/div[2]/div[1]/div[1]/div/span[1]/span/a/span/span[1]"));
		ArrayList<String> name = getTextOfElementscContent(By.xpath(
				"//*[@id=\"main\"]/div/div/div[2]/ul/li/div/div/div[2]/div[1]/div[1]/div/span[1]/span/a/span/span[1]"));

		return name;
	}

	public ArrayList<String> GetProfilePosition() {
		waiteElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/ul/li/div/div/div[2]/div[1]/div[2]/div/div[1]"));
		ArrayList<String> position = getTextOfElementscContent(
				By.xpath("//*[@id=\"main\"]/div/div/div[2]/ul/li/div/div/div[2]/div[1]/div[2]/div/div[1]"));

		return position;
	}

	public ArrayList<String> GetProfileLocation() {
		waiteElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/ul/li/div/div/div[2]/div[1]/div[2]/div/div[2]"));
		ArrayList<String> location = getTextOfElementscContent(
				By.xpath("//*[@id=\"main\"]/div/div/div[2]/ul/li/div/div/div[2]/div[1]/div[2]/div/div[2]"));

		return location;
	}

	public void saveOutputsSearchInCsvFile(ArrayList<String> arrayOfName, ArrayList<String> arrayOfPosition,
			ArrayList<String> arrayOfLocation) throws IOException {
		ArrayList<String[]> output = new ArrayList<String[]>();
		for (int i = 0; i < arrayOfName.size(); i++) {
			String[] list = new String[3];
			for (int j = 0; j < arrayOfName.size(); j++) {
				list[0] = arrayOfName.get(i);
				list[1] = arrayOfPosition.get(i);
				list[2] = arrayOfLocation.get(i);

			}
			output.add(list);
		}
		for (int j = 0; j < output.size(); j++) {
			System.out.println(Arrays.toString(output.get(j)));
		}
		csv.writeOnCsv(output);

	}
}
