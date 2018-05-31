package com.softserve.edu.regres.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.regres.data.users.IUser;

public class LoginPage extends AHeaderComponent {

	public enum LoginPageLanguage {
		SUBMIT_BUTTON_LANGUAGE("Увійти", "Войти", "Sign in");
		
		private Map<HeaderLanguage, String> allLanguages;
		
		private LoginPageLanguage(String... languages) {
			allLanguages = new HashMap<>();
			initLanguages(languages);
		}
		
		private void initLanguages(String... languages) {
			int i = 0;
			for (HeaderLanguage current : HeaderLanguage.values()) {
				if ((languages != null) 
						&& (languages[i] != null) 
						&& (!languages[i].isEmpty())) {
					allLanguages.put(current, languages[i]);
				}
				i = i + 1;
			}
		}
		
		public String getLocalization(HeaderLanguage language) {
			return allLanguages.get(language);
		}
	}

	// - - - - - - - - - -
	
	public static final String PICTURE_NAME = "ukraine_logo2.gif";
	//
	private WebElement loginField;
	private WebElement passwordField;
	private WebElement submitButton;
	private WebElement loginLogo;

	public LoginPage(WebDriver driver) {
		super(driver);
		initWebElements();
	}

	private void initWebElements() {
		loginField = driver.findElement(By.id("login"));
		passwordField = driver.findElement(By.id("password"));
		submitButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
		loginLogo = driver.findElement(By.cssSelector(".login_logo"));
	}

	// getters
	
	public WebElement getLoginField() {
		return loginField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getLoginLogo() {
		return loginLogo;
	}

	// functional
	
	public String getLoginFieldText() {
		return getLoginField().getAttribute(VALUE_ATTRIBUTE);
	}

	public String getPasswordFieldText() {
		return getPasswordField().getAttribute(VALUE_ATTRIBUTE);
	}

	public String getSubmitButtonText() {
		return getSubmitButton().getText();
	}

	public String getLoginLogoPictureName() {
		return getLoginLogo().getAttribute(SRC_ATTRIBUTE);
	}
	// setters

	public void clearLoginField() {
		getLoginField().clear();
	}

	public void clearPasswordField() {
		getPasswordField().clear();
	}

	public void clickLoginField() {
		getLoginField().click();
	}

	public void clickPasswordField() {
		getPasswordField().click();
	}

	public void clickSubmitButton() {
		getSubmitButton().click();
	}

	public void sendKeysLoginField(String login) {
		getLoginField().sendKeys(login);
	}

	public void sendKeysPasswordField(String password) {
		getPasswordField().sendKeys(password);
	}

	// business

	public LoginPage chooseLanguage(HeaderLanguage language) {
		chooseSelectLanguage(language);
		return new LoginPage(driver);
	}

	//private void loginUser(String login, String password) {
	private void loginUser(IUser user) {
		clickLoginField();
		clearLoginField();
		//sendKeysLoginField(login);
		sendKeysLoginField(user.getLogin());
		clickPasswordField();
		clearPasswordField();
		//sendKeysPasswordField(password);
		sendKeysPasswordField(user.getPassword());
		clickSubmitButton();
	}
	
    //public AdminPage successAdminLogin(String login, String password) {
	public UserPage successUserLogin(IUser user) {
    	//loginUser(login, password);
		loginUser(user);
    	return new UserPage(driver);
    }

    //public AdminPage successAdminLogin(String login, String password) {}

    //public LoginPage unsuccessLogin(String login, String password) {}

}
