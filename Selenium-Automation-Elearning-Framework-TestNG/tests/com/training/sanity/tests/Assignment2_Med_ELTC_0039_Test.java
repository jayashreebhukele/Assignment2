package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.Assignment2_Med_ELTC_0039_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Assignment2_Med_ELTC_0039_Test {
	private WebDriver driver;
	private String baseUrl;
	private Assignment2_Med_ELTC_0039_POM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;  
	JavascriptExecutor js;
	int i=0;
	ExtentReports report;
    ExtentTest logger,logger2;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new Assignment2_Med_ELTC_0039_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		js=(JavascriptExecutor)driver;
		report = new ExtentReports(System.getProperty("user.dir")+"\\Log\\ResultofELTC0039.html");
	}

	
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		//driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() throws InterruptedException, IOException {
		logger= report.startTest("Reporting module Testing");
		loginPOM.sendUserName("jayashree");
		loginPOM.sendPassword("jayashree@123");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		//Adding to report
		logger.log(LogStatus.INFO,"Login to Manipal elearning site");
		logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "Login Test passed");
	
	}
	@Test(priority=2)
	public void reportingTest() throws IOException
	{		
		//clicking course icon created by user
		loginPOM.clickReportingTab();
		js.executeScript("window.scrollBy(0,350)");
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0039"+i);
		i++;
		
		//Clicking on followed student link
		loginPOM.clickFollowedStudent();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0039"+i);
		i++;
		
		//Entering student name in keyword textbox
		js.executeScript("window.scrollBy(0,350)");
		loginPOM.sendStudentName("Jayashree");
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0039"+i);
		i++;
		
		//click on search button
		loginPOM.clickSearchButton();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0039"+i);
		i++;
		
		//click on >> icon
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loginPOM.clickOnArrow();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0039"+i);
		i++;
		
		//click on arrow icon on new page
		js.executeScript("window.scrollBy(0,450)");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loginPOM.clickOnArrow2();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0039"+i);
		i++; 
		
		//clicking in the test link uder test section
		js.executeScript("window.scrollBy(0,document.body.scrollheight)");
		loginPOM.clickTestIcon();
		
		
		//checking sendemail checkbox
		js.executeScript("window.scrollBy(0,document.body.scrollheight)");
        
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loginPOM.clickSendEmailCheckbox();
		
		//clicking on correct button
		loginPOM.clickCorrectButton();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0039"+i);
		i++;
		
		//Adding to report
		logger.log(LogStatus.INFO,"Reporting");
		logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "grade reported to user passed");
			
	}
	
	@Test(priority=3)
	public void returnToCourse() throws IOException
	{
		//clicking on course link
		loginPOM.clickCourseLink();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0039"+i);
		i++; 
		//Adding to report
		logger.log(LogStatus.INFO,"Return to course selected");
		logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "Returned to course successfully");
		report.flush();	
	}
				
}
