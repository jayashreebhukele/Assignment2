package com.training.pom;

import java.io.File;
import java.io.IOException;

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

public class Assignment2_Med_ELTC_0038_POM {
private WebDriver driver;

	
	public Assignment2_Med_ELTC_0038_POM(WebDriver driver) {
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
	@FindBy(linkText="Oracle")
	private WebElement courseicon;
		
	//Locating group icon
	@FindBy(linkText="Groups")
	private WebElement groupsicon;
	
	//clcking on new group icon
	@FindBy(xpath="//div[@id='toolbar-groups']//a[1]//img[1]")
	public WebElement newgroupicon;
	
	//Storing the name of group which user has created
	String groupname;
	
	
  	//locating number of groups to create textbox
	@FindBy(id="create_groups_number_of_groups")
	public WebElement numberofgrouptextbox;
	
	//locating proceed button
	@FindBy(xpath="//button[@id='create_groups_submit']")
	public WebElement proceedbutton;
	
	//Location group name textbox
	@FindBy(xpath="//input[@name='group_0_name']")
	public WebElement groupnametextbox;
	
	//locating creategroup button
	@FindBy(id="create_groups_step2_submit")
	public WebElement creategroupbutton;
	
	//Locating the group created stmt
	@FindBy(xpath="//div[@class='alert alert-info']")
	public WebElement assertgroupcreationtext;
	
	//locating group member icon
	@FindBy(xpath="//tbody[1]/tr[2]/td[5]/a[3]/img[1]")
	public WebElement groupmembericon;
	
	//locating group member dropdown
	@FindBy(xpath="//select[@id='group_members']")
	public WebElement groupmemberdropdown;
	
		
    //locating left dropdown
	 @FindBy(xpath="//em[@class='fa fa-arrow-right']")
	 public WebElement leftarrow;	
	 
	 //locating save setting button
	 @FindBy(xpath="//button[@id='group_edit_submit']")
	 public WebElement savesettingbutton;
	 
	 //locating edit group button
	 @FindBy(xpath="//tbody[1]/tr[2]/td[5]/a[1]/img[1]")
	 public WebElement editbutton;
	 
	//locating self register checkbox 
	 @FindBy(name="self_registration_allowed")
	 public WebElement checkbox1;
		 
	//locating self unregister checkbox 
	 @FindBy(name="self_unregistration_allowed")
	  public WebElement checkbox2;
	 
	 //locating ssave setting button
	 @FindBy(name="submit")
	  public WebElement savesetting1;
	 
	//locating assert text
	@FindBy(xpath="//div[@class='alert alert-success']")
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
	//clicking Reporting tab
	public void clickGroupIcon()
	{
		this.groupsicon.click();
	}
	
	//clicking on followe student link
	public void clickNewGroupIcon()
	{
		this.newgroupicon.click();
	}
	
	//entering number of groupsd
	public void SendNumberOfGroup(String number)
	{
		this.numberofgrouptextbox.clear();
		this.numberofgrouptextbox.sendKeys(number);
	}
	
    //clicking on search button
	public void clickProceedButton()
	{
		this.proceedbutton.click();
	}
	
	//entering group name
	public void sendGroupName(String groupname)
	{
		this.groupname=groupname;
		this.groupnametextbox.clear();
		this.groupnametextbox.sendKeys(groupname);
	} 
	
	//clicking on create group button
	public void clickCreateGroupButton()
	{
		this.creategroupbutton.click();
	}
		
	//ASSERTING GROUP CRATION
	public void assertGroupCreationUpdates()
	{
		String actual =this.assertgroupcreationtext.getText();
		String expected="group(s) has (have) been added";
		Assert.assertEquals(actual,expected);
		System.out.println("Group created successfully");                               
	}
		
	//clicking on groupmember icon
	public void clickGroupMemberIcon()
	{
		String before="//tbody[1]/tr[";
		String after="]/td[2]/a[1]";
		int rowcount=driver.findElements(By.xpath("//tbody[1]/tr")).size();
		for(int i=2;i<rowcount;i++)
		{
			String gname=driver.findElement(By.xpath(before+i+after)).getText();
			if(groupname.equalsIgnoreCase(gname))
			{
				//added this stmt for just to check wheather correct project name is getting selected
			 System.out.println("matched");
			 System.out.println(gname);
		     driver.findElement(By.xpath(before+i+"]/td[5]/a[3]/img[1]")).click();
		     break;
		    }
		}
	}
		
	//clicking on test icon
	public void selectGroupMember(int v1)
	{
	   Select select=new Select(groupmemberdropdown);
	   select.selectByIndex(v1);
	   //select.selectByIndex(v2);
	}
		
	//clicking on correct button
	public void clickLeftArrow()
	{
		this.leftarrow.click();
	}
		
	//clicking on save setting button
	public void clickSaveSettingButton()
	{
		this.savesettingbutton.click();
	}
		
		
	//clicking on edit setting button
	public void clickEditButton()
	{
		String before="//tbody[1]/tr[";
		String after="]/td[2]/a[1]";
		int rowcount=driver.findElements(By.xpath("//tbody[1]/tr")).size();
		for(int i=2;i<rowcount;i++)
		{
			String gname=driver.findElement(By.xpath(before+i+after)).getText();
			if(groupname.equalsIgnoreCase(gname))
			{
			 System.out.println("matched");
			 System.out.println(gname);
		     driver.findElement(By.xpath(before+i+"]/td[5]/a[1]/img[1]")).click();
		     break;
		    }
		}
	}
		//checking checkboxes -self register and unregister
	public void selectCheckboxes()
	{
	   this.checkbox1.click();
	   this.checkbox2.click();
	}
		
	public void clickSaveSetting1()
	{
	   this.savesetting1.click();
	 
	}
		//asserting the updates
		public void assertupdates()
		{
			String actual =this.asserttext.getText();
			String expected="Group settings modified";
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
