package com.softserve.edu.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AAdminMenu extends AProfileComponent {

	private WebElement homeMenu;

	public AAdminMenu(WebDriver driver) {
		super(driver);
		homeMenu = driver.findElement(By.cssSelector(".glyphicon.glyphicon-home"));
	}

	// getters

	public WebElement getHomeMenu() {
		return homeMenu;
	}

	// functional

	// setters

	public void clickHomeMenu() {
		getHomeMenu().click();
	}
	
	// business
	
	public UserPage gotoUserPage() {
		clickHomeMenu();
		return new UserPage(driver);
	}
	
}
