package com.linkedin.page;

import org.openqa.selenium.WebDriver;

import com.linkedin.utility.LinkedInLocatores;

public class LoginLinkedInPage extends BasePage {

	public LoginLinkedInPage(WebDriver driver) {
		super(driver);

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
}
