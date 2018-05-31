package com.softserve.edu.regres.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.regres.pages.AHeaderComponent.HeaderLanguage;
import com.softserve.edu.regres.pages.LoginPage;
import com.softserve.edu.regres.pages.LoginPage.LoginPageLanguage;

public class LocalizationTest extends TestRunner {

	@DataProvider//(parallel = true)
	public Object[][] dataLanguages() {
		return new Object[][] {
			{ HeaderLanguage.ENGLISH },
			{ HeaderLanguage.RUSSIAN },
			{ HeaderLanguage.UKRAINIAN }
		};
	}
	
	@Test(dataProvider = "dataLanguages")
	public void verifyLoginLocalization(HeaderLanguage language) {
		LoginPage loginPage = loadApplication()
			.chooseLanguage(language);
		Assert.assertEquals(loginPage.getSubmitButtonText(),
				LoginPageLanguage.SUBMIT_BUTTON_LANGUAGE.getLocalization(language));
	}
	
}
