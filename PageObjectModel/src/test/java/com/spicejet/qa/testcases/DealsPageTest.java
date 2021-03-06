package com.spicejet.qa.testcases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;

import com.spicejet.qa.base.TestBase;
import com.spicejet.qa.pages.BookingPage;
import com.spicejet.qa.pages.DealsPage;
import com.spicejet.qa.pages.LoginPage;
import com.spicejet.qa.pages.SMProfilePage;

public class DealsPageTest extends TestBase{
	LoginPage loginPage;
	SMProfilePage aSMProfilePage;
	DealsPage aDealsPage;
	
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	//@Parameters("browserName")
	public void setUp(/* @NoInjection String browserName */) throws InterruptedException {
		initialization(/* browserName */);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loginPage = new LoginPage();
		aSMProfilePage = loginPage.login(prop.getProperty("mobileNumber"), prop.getProperty("password"));
		// Thread.sleep(20000);
		aDealsPage = aSMProfilePage.clickOnDeals();
	}
	
	@Test(priority = 1)
	public void getListOfMobiKwikOfferTest() {
		ArrayList<String> listOfOffers =  aDealsPage.getListOfMobiKwikOffer();
		Assert.assertTrue(!listOfOffers.isEmpty());
	}
	
	@Test(priority = 2)
	public void bookMobikwikOfferTest() {
		BookingPage aBookingPage = aDealsPage.bookMobikwikOffer();
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
