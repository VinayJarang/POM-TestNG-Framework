package com.spicejet.qa.testcases;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.spicejet.qa.base.TestBase;
import com.spicejet.qa.pages.BookingPage;
import com.spicejet.qa.pages.DealsPage;
import com.spicejet.qa.pages.LoginPage;
import com.spicejet.qa.pages.SMProfilePage;
import com.spicejet.qa.util.TestUtil;

public class BookingPageTest extends TestBase{
	
	LoginPage loginPage;
	SMProfilePage aSMProfilePage;
	DealsPage aDealsPage;
	BookingPage aBookingPage;
	String sheetName = "Sheet1";
	
	public BookingPageTest() {
		super();
	}
	
	@BeforeMethod
	//@Parameters("browserName")
	public void setUp(/* String browserName */) throws InterruptedException {
		initialization(/* browserName */);
		/*
		 * driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 */
		loginPage = new LoginPage();
		aSMProfilePage = loginPage.login(prop.getProperty("mobileNumber"), prop.getProperty("password"));
		Thread.sleep(10000);
		aDealsPage = aSMProfilePage.clickOnDeals();
		aBookingPage = aDealsPage.bookMobikwikOffer();
		
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(windowHandles.size() - TestUtil.ONE));
	}
	
	/*
	 * @Test public void verifyOneWayLabelTest() { Assert.assertEquals(true,
	 * aBookingPage.verifyOneWayLabel());
	 * 
	 * }
	 * 
	 * @Test public void createBookingTest() throws Exception {
	 * aBookingPage.createBooking(); }
	 */
	
	/*
	 * @DataProvider public Object[][] getTestData() { Object data[][] =
	 * TestUtil.getTestData(sheetName); return data; }
	 * 
	 * @Test(priority=1, dataProvider="getTestData") public void
	 * validateFillPassengerDetails(String title, String firstName, String lastName,
	 * String mobileNumber) throws InterruptedException {
	 * aBookingPage.fillPassengerDetails(title,firstName,lastName,mobileNumber); }
	 */

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@AfterSuite
	public void quitDrivers() {
		driver.quit();
	}
}
