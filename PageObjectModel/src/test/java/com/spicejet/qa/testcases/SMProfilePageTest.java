package com.spicejet.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.spicejet.qa.base.TestBase;
import com.spicejet.qa.pages.LoginPage;
import com.spicejet.qa.pages.SMProfilePage;


public class SMProfilePageTest extends TestBase{
	
	LoginPage loginPage;
	SMProfilePage SMProfilePage;
	
	public SMProfilePageTest() {
		super();
	}
	
	@BeforeMethod
	//@Parameters("browserName")
	public void setUp(/* @NoInjection String browserName */) throws InterruptedException {
		initialization(/* browserName */);
		SMProfilePage = new LoginPage().login(prop.getProperty("mobileNumber"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyUserNameTest() {
		System.out.println("In Test");
		String userName = SMProfilePage.getUsernameDisplay();
		Assert.assertEquals(userName, "VINAY KUMAR", "USER Name not matched");
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
