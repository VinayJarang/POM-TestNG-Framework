package com.spicejet.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.spicejet.qa.base.TestBase;

public class BookingPage extends TestBase{
	
	@FindBy(xpath = "//label[text()='One Way' and @class='select-label']")
	WebElement oneWayLabel;
	
	@FindBy(xpath = "//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")
	WebElement departureCity;
	
	@FindBy(xpath = "//a[text()=' Bengaluru (BLR)']")
	WebElement bengaluru;
	
	@FindBy(xpath = "//a[text()=' Delhi (DEL)']")
	WebElement delhi;
	
	@FindBy(linkText = "31")
	WebElement date;
	
	@FindBy(linkText = "//div[@class='paxinfo']")
	WebElement passengerSelect;
	
	@FindBy(xpath = "//select[@id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT']")
	WebElement adultDropDown;
	
	@FindBy(xpath = "//*[@id=\'CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_DropDownListTitle_0\']")
	WebElement titlee;
	
	@FindBy(xpath = "//*[@id=\'CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_TextBoxFirstName_0\']")
	WebElement firstNamee;
	
	@FindBy(xpath = "//*[@id=\'CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_TextBoxLastName_0\']")
	WebElement lastNamee;
	
	@FindBy(xpath = "//*[@id=\'CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_TextBoxEmailMobile_0\']")
	WebElement mobileNumbere;
	
	@FindBy(xpath = "//span[@class='button-continue-text']")
	WebElement continueNext;
	
	public BookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyOneWayLabel() {
		return oneWayLabel.isDisplayed();
	}
	
	public void createBooking() throws Exception {
		fillBookingDetails();
		Thread.sleep(9000);
		System.out.println("IN 60");
		driver.findElement(By.xpath("//*[@id=\"ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT\"]")).click();
		driver.findElement(By.xpath("//a[text()=' Bengaluru (BLR)']")).click();
		driver.findElement(By.xpath("//a[text()=' Delhi (DEL)']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[text()='31']")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\'ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit\']")).click();
		driver.findElement(By.xpath("//*[@id=\'continue-to-contact-page\']")).click();
	}
	public void fillBookingDetails() throws InterruptedException {
		departureCity.click();
		bengaluru.click();
		delhi.click();
		date.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_btn_FindFlights\']")).click();
	}
	
	public void fillPassengerDetails(String title, String firstName, String lastName, String mobileNumber) throws InterruptedException {
		fillBookingDetails();
		
		Thread.sleep(9000);
		System.out.println("IN 60");
		driver.findElement(By.xpath("//*[@id=\"ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT\"]")).click();
		driver.findElement(By.xpath("//a[text()=' Bengaluru (BLR)']")).click();
		driver.findElement(By.xpath("//a[text()=' Delhi (DEL)']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[text()='31']")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\'ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit\']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='continue-to-contact-page']")).click();
		Thread.sleep(10000);
		Select select = new Select(titlee);
		select.selectByVisibleText(title);
		
		firstNamee.sendKeys(firstName);
		lastNamee.sendKeys(lastName);
		mobileNumbere.sendKeys(mobileNumber);
		continueNext.click();
	}
}
