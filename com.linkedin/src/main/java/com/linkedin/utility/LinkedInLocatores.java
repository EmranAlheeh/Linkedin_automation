package com.linkedin.utility;

import org.openqa.selenium.By;

public class LinkedInLocatores {
	public static final By email = By.id("username");
	public static final By password = By.id("password");
	public static final By signin = By.xpath("//*[@id=\"organic-div\"]/form/div[3]/button");
	public static final By searchInput = By
			.xpath("//input[@class='search-global-typeahead__input always-show-placeholder']");
	public static final String filterLocators = "//button[@aria-label='";
}
