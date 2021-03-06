package com.spicejet.qa.testcases;

import org.testng.TestNG;

import com.spicejet.ExtentReportListner.ExtentReporterNG;
import com.spicejet.qa.base.TestBase;

public class TestRunner extends TestBase {

	static TestNG testNg;

	public static void main(String[] args) {

		ExtentReporterNG extent = new ExtentReporterNG();
		testNg = new TestNG();
		testNg.setTestClasses(new Class[] { LoginPageTest.class, SMProfilePageTest.class, DealsPageTest.class,
				BookingPageTest.class });
		testNg.addListener(extent);
		testNg.run();
	}
}
