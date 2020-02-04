package com.training.pom;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2_Med_ELTC_0039_POM {
private WebDriver driver; 
	
	public Assignment2_Med_ELTC_0039_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	String projectname;
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	
	//locating login button
	@FindBy(xpath="//button[@id='form-login_submitAuth']")
	private WebElement loginBtn; 
	
	
	//Locating reporting tab icon
	@FindBy(linkText="Reporting")
	private WebElement reportingtab;
	
	//clcking on followed student
	@FindBy(linkText="Followed students")
	public WebElement followedstudentlink;
	
	
  	//locating keyword textbox
	@FindBy(id="search_user_keyword")
	public WebElement keywordsname;
	
	//locating search button
	@FindBy(xpath="//button[@id='search_user_submit']")
	public WebElement searchbutton;
	
	//Location arrow icon
	@FindBy(xpath="//tr[3]//td[5]//a//img")
	public WebElement arrowicon;
	
	//locating >> icon on the new page
	@FindBy(xpath="//tr[2]//td[7]//a[1]//img[1]")
	public WebElement arrowicon2;
	
	//Locating test icon under test section
	@FindBy(xpath="//tr[@class='row_odd']//td[5]//a[1]//img[1]")
	public WebElement testicon;
	
	//locating send email checkbox
	@FindBy(name="send_notification")
	public WebElement sendemailcheckbox;
	
	//locating correct button
	@FindBy(id="form-email_submit")
	public WebElement correctbutton;
	
		
    //asserting the updates
	 @FindBy(xpath="//div[@class='alert alert-info']")
	 public WebElement asserttext;	
	 
	 //locating course link
	 @FindBy(xpath="//a[contains(text(),'oracle123')]")
	 public WebElement courselink;
	 
	//entering username
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	//entering password
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	//click on login button
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	//clicking Reporting tab
	public void clickReportingTab()
	{
		this.reportingtab.click();
	}
	
	//clicking on followe student link
	public void clickFollowedStudent()
	{
		this.followedstudentlink.click();
	}
	
	//entering student name as keyword
	public void sendStudentName(String sname)
	{
		this.keywordsname.sendKeys(sname);
	}
	
    //clicking on search button
	public void clickSearchButton()
	{
		this.searchbutton.click();
	}
	
	//clicking on >> arrow
	public void clickOnArrow()
	{
		this.arrowicon.click();
	}
	
	//clicking on >> arrow on new page
	public void clickOnArrow2 ()
	{
		this.arrowicon2.click();
	}
		
		
	//clicking on test icon
	public void clickTestIcon()
	{
		this.testicon.click();
	}
		
	//clicking on test icon
		public void clickSendEmailCheckbox()
		{
			this.sendemailcheckbox.click();
		}
		
		//clicking on correct button
		public void clickCorrectButton()
		{
			this.correctbutton .click();
		}
		
		//asserting the updates
		public void assertupdates()
		{
			String actual =this.asserttext.getText();
			String expected="Message Sent";
			Assert.assertEquals(actual,expected);
			System.out.println("Message sent successfully");                               
		}
		
		//clicking on course link
		public void clickCourseLink()
		{
			this.courselink.click();
		}
		
	
		// method for log screenshots
		public String capture(WebDriver driver) throws IOException {
			
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()
			
			+ ".png");
			
			String errflpath = Dest.getAbsolutePath();
		
			FileUtils.copyFile(scrFile, Dest);
			
			return errflpath;
			
			}
}
