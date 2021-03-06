package com.spicejet.qa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spicejet.qa.base.TestBase;
import com.spicejet.qa.util.TestUtil;

public class DealsPage extends TestBase {

	@FindBy(id = "proceed-button")
	WebElement proceedBtm;

	@FindBy(xpath="//span[contains(text(),'Mobikwi')]//following-sibling::div//child::span[@class='deal-promo-label']//following-sibling::span[contains(text(),'Copy')]")
	WebElement copyAndBook;
	
	@FindBy(linkText = "Hotels")
	WebElement hotels;
	
	@FindBy(linkText = "Packages")
	WebElement packages;
	
	@FindBy(linkText = "Flight")
	WebElement flight;
	
	@FindBy(xpath = "//span[contains(text(),'Mobikwi') or contains(text(),'MOBIKWIK')]//following-sibling::div//child::span[@class='deal-promo-label']//descendant::span")
	List<WebElement> mobikwik;
	
	@FindBy(id = "proceed-button")
	WebElement sendAnyway;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnProceed() {
		//ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		System.out.println("TABS : "+tabs2);
		driver.switchTo().window(tabs2.get(1));
	    
		sendAnyway.click();
		driver.navigate().refresh();

		/*
		 * driver.findElement(By.id("proceed-button")).click();
		 * driver.navigate().refresh();
		 */
	}

	public BookingPage bookMobikwikOffer() {
		clickOnProceed();
		copyAndBook.click();
		
		return new BookingPage();
	}
	
	public ArrayList<String> getListOfMobiKwikOffer() {
		clickOnProceed();
		ArrayList<String> listOfMobikwikOffers = new ArrayList<>();
		hotels.click();
		packages.click();
		flight.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*
		 * List<WebElement> mobikwik = driver.findElements(By.xpath(
		 * "//span[contains(text(),'Mobikwi') or contains(text(),'MOBIKWIK')]//following-sibling::div//child::span[@class='deal-promo-label']//descendant::span"
		 * ));
		 */
		for (WebElement mobiElement : mobikwik) {
			listOfMobikwikOffers.add(mobiElement.getText());
		}
		return listOfMobikwikOffers;
	}
}
