package com.spicejet.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.spicejet.qa.base.TestBase;
import com.spicejet.qa.pages.LoginPage;
import com.spicejet.qa.pages.SMProfilePage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	SMProfilePage aSMProfilePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	//@Parameters("browserName")
	public void setUp(/* @NoInjection String browserName */) {
		initialization(/* browserName */);
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,
				"Cheap Air Tickets Online, International Flights to India, Cheap International Flight Deals | SpiceJet Airlines");

	}
	
	@Test(priority = 2)
	public void logoTest() {
		Assert.assertTrue(loginPage.validateSpiceClubLogo());
	}
	
	@Test(priority = 3)
	public void loginTest() {
		aSMProfilePage = loginPage.login(prop.getProperty("mobileNumber"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@AfterSuite
	public void quitDrivers() {
		driver.quit();
	}
	
}
