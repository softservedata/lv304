package com.softserve.edu.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AProfileComponent extends AHeaderComponent {

	private class DropdownToggleComponent {

		private WebElement changePasswordLink;
		private WebElement resetPasswordLink;
		private WebElement logoutLink;
		
		public DropdownToggleComponent() {
			//changePasswordLink = driver.findElement(By.cssSelector("a[href*='change_password']"));
			changePasswordLink = driver.findElement(By.cssSelector(".change-password"));
			resetPasswordLink = driver.findElement(By.cssSelector(".reset-my-password"));
			logoutLink = driver.findElement(By.cssSelector("a[href*='logout']"));
		}

		// getters
		
		public WebElement getChangePasswordLink() {
			return changePasswordLink;
		}

		public WebElement getResetPasswordLink() {
			return resetPasswordLink;
		}

		public WebElement getLogoutLink() {
			return logoutLink;
		}

	}
	
	// - - - - - - - - - -

	private WebElement userLabel;
	private WebElement dropdownToggle;
	private DropdownToggleComponent dropdownToggleComponent;

	public AProfileComponent(WebDriver driver) {
		super(driver);
		initWebElements();
	}

	private void initWebElements() {
		userLabel = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm:not(.dropdown-toggle)"));
		dropdownToggle  = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle"));
	}

	// getters
	
	public WebElement getUserLabel() {
		return userLabel;
	}

	public WebElement getDropdownToggle() {
		return dropdownToggle;
	}

	public DropdownToggleComponent getDropdownToggleComponent() {
		clickDropdownToggle();
		return dropdownToggleComponent;
	}

	public WebElement getChangePasswordLink() {
		return getDropdownToggleComponent().getChangePasswordLink();
	}

	public WebElement getResetPasswordLink() {
		return getDropdownToggleComponent().getResetPasswordLink();
	}

	public WebElement getLogoutLink() {
		return getDropdownToggleComponent().getLogoutLink();
	}

	// functional
	
	public String getUserLabelText() {
		return getUserLabel().getText();
	}

	public String getChangePasswordLinkText() {
		return getChangePasswordLink().getText();
	}

	public String getResetPasswordLinkText() {
		return getResetPasswordLink().getText();
	}

	public String getLogoutLinkText() {
		return getLogoutLink().getText();
	}

	// setters

	public void clickUserLabel() {
		getUserLabel().click();
	}

	public void clickDropdownToggle() {
		clickUserLabel();
		getDropdownToggle().click();
		dropdownToggleComponent = new DropdownToggleComponent();
	}

	public void clickLogoutLink() {
		//clickDropdownToggle();
		//dropdownToggleComponent.getLogoutLink().click();
		getLogoutLink().click();
	}

	// business

}
