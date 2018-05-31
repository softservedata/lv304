package com.softserve.edu.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class AHeaderComponent {

	public enum HeaderLanguage {
		UKRAINIAN("українська"),
		RUSSIAN("русский"),
		ENGLISH("english");
		
		private String language;
		
		private HeaderLanguage(String language) {
			this.language = language;
		}

		public String getLanguage() {
			return language;
		}
	}
	
	// - - - - - - - - - -
	
	protected final String VALUE_ATTRIBUTE = "value";
	protected final String SRC_ATTRIBUTE = "src";
	//
	protected WebDriver driver;
	//
	private WebElement applicationLabel;
	private Select selectLanguage;
	
	public AHeaderComponent(WebDriver driver) {
		this.driver = driver;
		initWebElements();
	}

	private void initWebElements() {
		applicationLabel = driver.findElement(By.cssSelector(".col-md-7.col-xs-12"));
		selectLanguage = new Select(driver.findElement(By.id("changeLanguage")));
	}
	
	// getters
	
	public WebElement getApplicationLabel() {
		return applicationLabel;
	}

	public Select getSelectLanguage() {
		return selectLanguage;
	}

	public WebElement getSelectLanguageWebElement() {
		return getSelectLanguage().getFirstSelectedOption();
	}

	// functional
	
	public String getApplicationLabelText() {
		return getApplicationLabel().getText();
	}
	
	public String getSelectLanguageText() {
		return getSelectLanguageWebElement().getText();
	}

	public HeaderLanguage getSelectLanguageHeader() {
		HeaderLanguage resultLanguage = HeaderLanguage.ENGLISH;
		for (HeaderLanguage current : HeaderLanguage.values()) {
			if (current.getLanguage().equals(getSelectLanguageText())) {
				resultLanguage = current;
				break;
			}
		}
		return resultLanguage;
	}

	// setters

	public void clickApplicationLabel() {
		getApplicationLabel().click();
	}
	
	public void clickSelectLanguage() {
		getSelectLanguageWebElement().click();
	}
	
	// business

	public void chooseSelectLanguage(HeaderLanguage language) {
		getSelectLanguage().selectByVisibleText(language.getLanguage());
	}

}
