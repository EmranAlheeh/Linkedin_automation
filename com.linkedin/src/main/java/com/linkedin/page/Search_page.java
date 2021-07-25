package com.linkedin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.linkedin.locators.Search_locatores;

 
public class Search_page {
	WebDriver driver;

	public Search_page(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void enterEmail(String arg) {
 		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Search_locatores.email));
		driver.findElement(Search_locatores.email).sendKeys(arg);
	}
	public void enterPassword(String arg1) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Search_locatores.password));
		driver.findElement(Search_locatores.password).sendKeys(arg1);

	}
 public void clickOnSignin() {
	 @SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait (driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Search_locatores.signin));
		driver.findElement(Search_locatores.signin).click();
 }
}
