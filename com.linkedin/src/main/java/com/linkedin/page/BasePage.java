package com.linkedin.page;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	@SuppressWarnings("deprecation")
	public void waiteElement(By locator) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void sendKeysForInput(By locator, String arg) {
		driver.findElement(locator).sendKeys(arg);
	}

	public void clickOnElement(By locator) {
		driver.findElement(locator).click();
	}

	public void sendKeysForInputAndClickEnter(By locator, String arg) {
		driver.findElement(locator).sendKeys(arg, Keys.ENTER);
	}

	public ArrayList<String> getListHrefOfElements(By locator) {
		ArrayList<String> array = new ArrayList<>();
		waiteElement(locator);

		ArrayList<WebElement> findElements = (ArrayList<WebElement>) driver.findElements(locator);

		// this are all the links you like to visit
		for (int i = 0; i < 7; i++) {
			WebElement webElement = findElements.get(i);
			// System.out.println(webElement.getAttribute("href"));
			array.add(webElement.getAttribute("href"));
		}
		return array;

	}

	public ArrayList<String> getTextOfElementscContent(By locator) {
		waiteElement(locator);
		ArrayList<String> array = new ArrayList<>();
		ArrayList<WebElement> findElements = (ArrayList<WebElement>) driver.findElements(locator);

		// this are all the links you like to visit
		for (int i = 0; i < 8; i++) {
			WebElement webElement = findElements.get(i);
			// System.out.println(webElement.getAttribute("href"));
			array.add(webElement.getText());
		}
		return array;

	}

	 
	 
}
