package com.spicejet.ExtentReportListner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.spicejet.qa.base.TestBase;


public class HandleMultipleBrowsers extends TestBase{
	
	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\resources\\chromedriver.exe");
			System.out.println("In CHROME");
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.out.println("In FIREFOX");
			System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	@Test
	public void openGoogle() {
		driver.get("https:://www.google.com");
	}
}
