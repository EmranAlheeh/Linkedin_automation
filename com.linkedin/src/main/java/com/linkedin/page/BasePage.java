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

	public void waiteElement(By locator) {
//		@SuppressWarnings("deprecation")
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		// driver= new ChromeDriver();
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

	public void getHrefOfNumberOfElements(By locator) {
		waiteElement(locator);

		ArrayList<WebElement> findElements = (ArrayList<WebElement>) driver.findElements(locator);

		// this are all the links you like to visit
		for (int i = 0; i < findElements.size(); i++) {
			WebElement webElement = findElements.get(i);
			System.out.println(webElement.getAttribute("href"));

		}

	}

	public void closeChrome() {

		driver.close();
	}
}
