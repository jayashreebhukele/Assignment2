package com.training.pom;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Assignment2_Med_ELTC_0036_POM {
private WebDriver driver; 
	
	public Assignment2_Med_ELTC_0036_POM(WebDriver driver) {
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
	
	//Locating course icon
	@FindBy(linkText="oracle123")
	private WebElement courseicon;
		
	//Locating tests icon
	@FindBy(linkText="Tests")
	private WebElement testicon;
	
	//Locating result and configure icon
		@FindBy(xpath="//tr[@id='exercise_list_246']//a[3]//img[1]")
		private WebElement resultfeedbackicon;
		
		
	//Locating result and configure icon
	@FindBy(xpath="//tr[@id='233']//a[1]//img[1]")
	private WebElement gradeactivityicon;
	
	
	//locating send email checkbox
		@FindBy(name="send_notification")
		public WebElement sendemailcheckbox;
		
		//locating correct button
		@FindBy(id="form-email_submit")
		public WebElement correctbutton;
		
			
	    //asserting the updates
		 @FindBy(xpath="//div[@class='alert alert-info']")
		 public WebElement asserttext;	
	
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
	
	//clicking course icon
    public void clickcourseIcon()
		{
			this.courseicon.click();
		}
	//clicking testicon tab
	public void clickTestIcon()
	{
		this.testicon.click();
	}
	
	//clicking on result and feedback icon
	public void clickResultFeedback()
	{
		this.resultfeedbackicon.click();
	}
	
	//clicking on grade activity icon
	public void clickGradeActivity()
	{
		this.gradeactivityicon.click();
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
				
	public String capture(WebDriver driver) throws IOException {
	
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()
		
		+ ".png");
		
		String errflpath = Dest.getAbsolutePath();
	
		FileUtils.copyFile(scrFile, Dest);
		
		return errflpath;
		
		}
}