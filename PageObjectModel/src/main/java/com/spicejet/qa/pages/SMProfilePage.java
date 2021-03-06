package com.spicejet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spicejet.qa.base.TestBase;

public class SMProfilePage extends TestBase{
	
	@FindBy(xpath="//h2//child::span[text()='Vinay kumar']")
	WebElement userName;
	
	@FindBy(xpath="//a[contains(text(),'My Profile') and @class='member-my-profile mm-kyc-warning arrow-on']")
	WebElement myProfile;
	
	@FindBy(xpath="//a[contains(text(),'DEALS')]")
	WebElement deals;
	
	//Intializing PageObjects
	public SMProfilePage() {
		PageFactory.initElements(driver, this);//PageFactory.initElements(driver, LoginPage.class);
	}
	
	
	//Actions:
	public String verifySMProfilePageTitle() {
		return driver.getTitle();
	}
	
	public String getUsernameDisplay() {
		return userName.getText();
	}
	
	public MyProfilePage clickOnMyProfile() {
		myProfile.click();
		return new MyProfilePage();
	}
	
	public DealsPage clickOnDeals() {
		deals.click();
		return new DealsPage();
	}
}
