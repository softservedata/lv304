package com.softserve.edu.regres.pages;

import org.openqa.selenium.WebDriver;

public class UserPage extends AAdminMenu {

	public UserPage(WebDriver driver) {
		super(driver);
	}
	
	// getters

	// functional
	
	// setters
	
	// business

	public LoginPage successLogout() {
		clickLogoutLink();
		return new LoginPage(driver);
	}
}
