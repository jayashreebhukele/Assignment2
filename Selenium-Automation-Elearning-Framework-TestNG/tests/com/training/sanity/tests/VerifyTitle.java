package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyTitle {
	ExtentReports report;
    ExtentTest test;
	@BeforeClass
	
	public void startTest()
	{
	
	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	
	test = report.startTest("ExtentDemo");
	
	}

	@Test
	
	public void extentReportsDemo()
	
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\JayashreeBhukele\\SeleniumBrowsers\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.google.co.in");
	
	if(driver.getTitle().equals("Google"))
	
	{
	
	test.log(LogStatus.PASS, "Navigated to the specified URL");

	}

	else
	
	{
	
	test.log(LogStatus.FAIL, "Test Failed");

	}

	}
	
	@AfterClass
	
	public void endTest()
	
	{
	
	report.endTest(test);
	
	report.flush();
	
	}
	 
	 
	}

