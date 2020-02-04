package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.Assignment2_Medium_ELTC_0040_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Assignment2_Med_ELTC_0040_Test {
	private WebDriver driver;
	private String baseUrl;
	private Assignment2_Medium_ELTC_0040_POM loginPOM;
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
		loginPOM = new Assignment2_Medium_ELTC_0040_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		js=(JavascriptExecutor)driver;
		report = new ExtentReports(System.getProperty("user.dir")+"\\Log\\ResultofELTC0040.html");
	}

	
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		//driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() throws InterruptedException, IOException {
		logger= report.startTest("Project module Testing");
		loginPOM.sendUserName("jayashree");
		loginPOM.sendPassword("jayashree@123");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		logger.log(LogStatus.INFO,"Login to Manipal elearning site");
		logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "Login Test passed");
	}
	@Test(priority=2)
	public void updateCourseTest() throws IOException
	{		
		//clicking course icon created by user
		loginPOM.clickcourseIcon();
		js.executeScript("window.scrollBy(0,650)");
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		//clicking on project icon 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		loginPOM.clickProjectIcon();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		//clicking description icon on new page
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.clickNewProjectIcon();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		//Entering title
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.sendProjectTitle("Oracle Project5");
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		//Entering subtitle
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.sendProjectSubTitle("Basic Oracle Project");
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		//Click on save blog button
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.clickSaveBlogButton();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		//Validating that project has been added successfully
		loginPOM.assertingupdates();
		
		//adding to report
		logger.log(LogStatus.INFO,"Update the course");
		logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "Course updated successfully");
		
	}
	
	@Test(priority=3)
	public void newTaskTest() throws IOException
	{
		//clicking on the new created project link
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		js.executeScript("window.scrollBy(0,650)");
		loginPOM.clickProjectLink();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		//click on new task link
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.clickNewTask();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		//entering title
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.sendTitle("Basic project");
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		js.executeScript("window.scrollBy(0,document.body.scrollheight)");
		
		//Clicking on save button
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.clickSave();
		
		//asserting task is updated successfully
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.assertingtaskupdates();
		
		//adding to report
		logger.log(LogStatus.INFO,"Created New Task");
		logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "Task created successfully");
				
		
	}
	
	@Test(priority=4)
	public void roleMgmtTest() throws IOException
	 {
		//click on role mgmt link
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.clickRoleMgmt();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		//click on new role link
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.clickNewRole();
		
		//entering new Role title
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.sendNewRoleTitle("Project Manager");
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
				
		js.executeScript("window.scrollBy(0,250)");
				
	    //Clicking on new role save button
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.clickNewRoleSave();
				
	    //asserting new role is updated successfully
		loginPOM.assertingNewRoleupdates();
		
		//adding to report
		logger.log(LogStatus.INFO,"Role Mgmt Test");
		logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "Role managed successfully");
						
				
	 }
	
	@Test(priority=5)
	public void assignRoleTest() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		//clicking on assign new role link
		loginPOM.clickAssignNewRole();
		
		//Entering value in user dropdown
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.selectUser("Jayashree Bhukele");
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		//click on validate button
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.clickValidate();
		
		//asserting assign role
		loginPOM.assertingassignRoleupdates();
		
		//adding to report
		logger.log(LogStatus.INFO,"Assigning Roles");
		logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "Role assigned successfully");
						
				
		
	}
	
	@Test(priority=6)
	public void userMgmtTest() throws IOException
	{
		//clicking user mgmt link
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.clickUserMgmt();
		
		//Selecting user checkbox
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.SelectUserToSubscribe();
		screenShot.captureScreenShot("Assignment2_Medium_ELTC_0040"+i);
		i++;
		
		//click on register button
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		loginPOM.clickRegisterButton();
		
		//adding to report
		logger.log(LogStatus.INFO,"Register user to Project");
		logger.log(LogStatus.PASS,logger.addScreenCapture(loginPOM.capture(driver))+ "User registered successfully");
						
		report.flush();		
		
	}
	
}
