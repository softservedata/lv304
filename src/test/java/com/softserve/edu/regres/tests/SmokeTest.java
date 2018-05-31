package com.softserve.edu.regres.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.regres.data.users.IUser;
import com.softserve.edu.regres.data.users.UserRepository;
import com.softserve.edu.regres.pages.UserPage;
import com.softserve.edu.regres.pages.LoginPage;

public class SmokeTest extends TestRunner {

	@DataProvider
	public Object[][] userCredentionals() {
		return new Object[][] {
			//{ "work", "qwerty" }
			{ UserRepository.get().userWork() }
		};
	}
	
	@Test(dataProvider = "userCredentionals")
	public void verifyAdminLogin(IUser user) throws Exception {
		UserPage userPage = loadApplication()
			.successUserLogin(user);
		Assert.assertEquals(userPage.getUserLabelText(), user.getLogin());
		Thread.sleep(2000);
		//
		LoginPage loginPage = userPage.successLogout();
		Assert.assertTrue(loginPage.getLoginLogoPictureName()
				.contains(LoginPage.PICTURE_NAME));
		Thread.sleep(2000);
	}
}
