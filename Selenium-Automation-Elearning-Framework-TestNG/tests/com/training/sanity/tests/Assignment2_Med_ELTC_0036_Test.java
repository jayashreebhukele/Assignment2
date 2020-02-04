package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
//import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.Assignment2_Med_ELTC_0036_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Assignment2_Med_ELTC_0036_Test {
	private WebDriver driver;
	private String baseUrl;
	private Assignment2_Med_ELTC_0036_POM loginPOM;
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
		loginPOM = new Assignment2_Med_ELTC_0036_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		js=(JavascriptExecutor)driver;
		report = new ExtentReports(System.getProperty("user.dir")+"\\Log\\ResultofELTC0036.html");
		
		//logger= report.startTest("Login Test");
		
	}

	
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		//driver.quit();
	     report.endTest(logger);
		
		report.flush();
	}
	@Test(priority=1)
	public void validLoginTest() throws InterruptedException, IOException {
		logger= report.startTest("Test Module Testing");
		loginPOM.sendUserName("jayashree");
		loginPOM.sendPassword("jayashree@123");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		loginPOM.clickLoginBtn();
		// String title=driver.getTitle();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0038"+i);
		i++;
		logger.log(LogStatus.INFO,"Login to Manipal elearning site");
		logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "Login Test passed");
	        //Ending test
		
	      
	}
	@Test(priority=2)
	public void TestFunctionality() throws IOException
	{	
		//clicking course icon created by user
		loginPOM.clickcourseIcon();
		js.executeScript("window.scrollBy(0,650)");
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		//clicking on Test icon tab
		js.executeScript("window.scrollBy(0,450)");
		loginPOM.clickTestIcon();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0038"+i);
		i++;
		
		//Clicking on result and feed back icon
		loginPOM.clickResultFeedback();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0038"+i);
		i++;
		
		//click on grade activity button
		loginPOM.clickGradeActivity();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0038"+i);
		i++;
		
		
		js.executeScript("window.scrollBy(0,document.body.scrollheight)");
		
		
		//checking sendemail checkbox
		js.executeScript("window.scrollBy(0,document.body.scrollheight)");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    loginPOM.clickSendEmailCheckbox();
				
	    //clicking on correct button
		loginPOM.clickCorrectButton();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0039"+i);
		i++;
		
		//assering the result
		loginPOM.assertupdates();
		logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "test functionality passed");
        //Ending test
		report.flush();
	
	
	
	}
}
				