package com.spicejet.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.spicejet.qa.util.TestUtil;
import com.spicejet.qa.util.WebEventListener;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver event_driver;
	public static WebEventListener eventListner;
	
	public TestBase() {
		
		/*
		 * try { prop = new Properties(); String path =
		 * "\bPageObjectModel/src/main/java/com/spicejet/qa/config/config.properties";
		 * path.trim(); FileInputStream ip = new FileInputStream(path); prop.load(ip); }
		 * catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
		 * e) { e.printStackTrace(); }
		 */
	}
	
	public static void initialization(/* String browserName */) {
		String browserName = "chrome";
		if(browserName.equals("chrome")) {
			System.out.println("In CHROME 1");
			System.setProperty("webdriver.chrome.driver","\\"+"//PageObjectModel//src//resources//chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if(browserName.equals("firefox")) {
			System.out.println("In FIREFOX 1 ");
			System.setProperty("webdriver.gecko.driver", "C:\\PageObjectModel-Workspace\\PageObjectModel\\src\\resources\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		/*
		 * event_driver = new EventFiringWebDriver(driver); eventListner = new
		 * WebEventListener(); event_driver.register(eventListner); driver =
		 * event_driver;
		 */
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
