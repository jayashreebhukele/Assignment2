package com.training.sanity.tests;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

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
import com.training.generics.ScreenShot;
import com.training.pom.Assignment2_Med_ELTC_0038_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Assignment2_Med_ELTC_0038_Test {
	private WebDriver driver;
	private String baseUrl;
	private Assignment2_Med_ELTC_0038_POM loginPOM;
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
		loginPOM = new Assignment2_Med_ELTC_0038_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		js=(JavascriptExecutor)driver;
		report=new ExtentReports(System.getProperty("user.dir")+"\\Log\\Resultoftestcase38_Test.html");
	}

	
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		//driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() throws InterruptedException, IOException {
		logger=report.startTest("Create and update Group Demo");
		//Login to the application
		loginPOM.sendUserName("jayashree");
		loginPOM.sendPassword("jayashree@123");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		loginPOM.clickLoginBtn();
		logger.log(LogStatus.INFO,"Login to Manipal elearning site");
		
	    logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "Login passed");
	    screenShot.captureScreenShot("Assignment2_Medium_ELTC_0038"+i);
		i++;
	}
	@Test(priority=2)
	public void createGroupTest() throws IOException
	{	
		      
		//clicking course icon created by user
		loginPOM.clickcourseIcon();
		js.executeScript("window.scrollBy(0,650)");
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		//clicking on group icon tab
		js.executeScript("window.scrollBy(0,450)");
		loginPOM.clickGroupIcon();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0038"+i);
		i++;
		
		//Clicking on new group icon
		loginPOM.clickNewGroupIcon();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0038"+i);
		i++;
		
		//Entering numbers of group
		loginPOM.SendNumberOfGroup("1");
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0038"+i);
		i++;
		
		//click on proceed button
		loginPOM.clickProceedButton();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0038"+i);
		i++;
		
		//entering group name
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loginPOM.sendGroupName("Group2");
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0038"+i);
		i++;
		
		//click on create group button
		loginPOM.clickCreateGroupButton();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0038"+i);
		i++; 
		
		
		//asserting group created
		loginPOM.assertGroupCreationUpdates();
		
		//adding to log
        logger.log(LogStatus.INFO,"Creation of new Group");
		logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "Group Created successfully");
	}
	
	@Test(priority=3)
	public void groupMember() throws IOException
	{
		//clicking on group member
		js.executeScript("window.scrollBy(0,350)");
		loginPOM.clickGroupMemberIcon();
		
		
		//Selecting group member
		
		loginPOM.selectGroupMember(1);
		//clicking on left arrow button
		loginPOM.clickLeftArrow();
		
		//Selecting group member
		loginPOM.selectGroupMember(2);
		
		//clicking on left arrow button
		loginPOM.clickLeftArrow();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0038"+i);
		i++;
		
		//clicking on save setting button
		loginPOM.clickSaveSettingButton();
	
		logger.log(LogStatus.INFO,"Adding member to Group");
		logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "Group member added successfully");		
	}
	
	@Test(priority=4)
	public void editGroupSetting() throws IOException
	{
		//clicking on edit setting
		loginPOM.clickEditButton();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0038"+i);
		i++; 
		
		//checking the self register and unregister checkboxes
		js.executeScript("window.scrollBy(0,350)");
		loginPOM.selectCheckboxes();
		
		js.executeScript("window.scrollBy(0,document.body.scrollheight)");
		loginPOM.clickSaveSetting1();
		
		loginPOM.assertupdates();
		
		//adding to log
		logger.log(LogStatus.INFO,"Editing Group Details");
		logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "Group updated successfully");
		report.flush();
	}
				
}
