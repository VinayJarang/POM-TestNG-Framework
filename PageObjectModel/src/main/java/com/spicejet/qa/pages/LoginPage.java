package com.spicejet.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spicejet.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR
	@FindBy(xpath="//input[@placeholder='Mobile Number']")
	@CacheLookup
	WebElement mobileNumber;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	
	@FindBy(xpath="//a[@class='signup-link buttonN']")
	WebElement signUp;
	
	@FindBy(xpath="//img[contains(@src,'red_sclogo')]")
	WebElement spiceClubLogo;
	
	
	//Initializing PageObjects
	public LoginPage() {
		PageFactory.initElements(driver, this);//PageFactory.initElements(driver, LoginPage.class);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateSpiceClubLogo() {
		return spiceClubLogo.isDisplayed();
	}
	
	public SMProfilePage login(String mobNum, String pwd) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(mobileNumber));
		mobileNumber.sendKeys(mobNum);
		password.sendKeys(pwd);
		login.click();
		
		return new SMProfilePage();
		
	}
}
