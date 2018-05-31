package com.softserve.edu.regres.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.regres.pages.LoginPage;

public abstract class TestRunner {
    protected final int TIMEOUT_IMPICIT = 10; 
	protected WebDriver driver;

	@BeforeClass
	public void setUpBeforeClass() {
		// For Google Chrome
		System.setProperty("webdriver.chrome.driver",
				"target/test-classes/chromedriver-windows-32bit.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(TIMEOUT_IMPICIT, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDownAfterClass() {
		driver.quit();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(1000);
	}

	@AfterMethod
	public void tearDown() throws Exception {
	    // TODO logout
		System.out.println("\t@AfterMethod tearDown()");
	}

	protected LoginPage loadApplication() {
		return new LoginPage(driver);
	}
}
