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

public class Assignment2_Medium_ELTC_0040_POM {
private WebDriver driver; 
	
	public Assignment2_Medium_ELTC_0040_POM(WebDriver driver) {
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
	
	//Locating projects icon
	@FindBy(id="istooldesc_12014")
	private WebElement projecticon; 
	
		//Locating New project icon on new screen
	@FindBy(xpath="//div[@class='actions']//a//img")
	private WebElement newprojecticon;
	
	//Locating title textbox
	@FindBy(id="add_blog_blog_name")
	private WebElement projecttitletextbox;
	
	//Locating subtitle textbox
	@FindBy(id="add_blog_blog_subtitle")
	private WebElement projectsubtitle;
	
	//Locating subtitle textbox
	@FindBy(xpath="//button[@id='add_blog_submit']")
	private WebElement saveblogbutton;
	
	
	//Locating project updated text for assertion
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement updatetext;
	
	//Locating new task link
	@FindBy(xpath="//a[2]//img[1]")
	 private WebElement newtasklink;
	
	//locating title textbox
    @FindBy(id="add_post_title")
	 private WebElement titletextbox;
		
    @FindBy(id="add_post_save")
	 private WebElement savebutton;
    
  //Locating project updated text for new task
  	@FindBy(xpath="//div[@class='alert alert-success']")
  	private WebElement updatetask;
	
  //Locating role mgmt link
  	@FindBy(xpath="//a[3]//img[1]")
  	 private WebElement rolemgmtlink;
  	
  	
    //Locating New role link
  	@FindBy(xpath="//a[contains(text(),'Add a new role')]")
  	 private WebElement newrolelink;
  	
   //locating new role title textbox
     @FindBy(xpath="//input[@name='task_name']")
  	 private WebElement newroletitle;
  		
    //locating new role save button 
      @FindBy(xpath="//button[@name='Submit']")
  	  private WebElement newrolesavebutton;
      
    //Locating project updated text for new role
      @FindBy(xpath="//div[@class='alert alert-success']")
      private WebElement updatenewrole;
    	
    	
    //Locating assign new role
      @FindBy(xpath="//a[contains(text(),'Assign roles')]")
      private WebElement assignnewrole;
    		
    //locating user dropdown
  	@FindBy(xpath="//select[@id='assign_task_task_user_id']")
  	private WebElement userdropdown;
  	
  	//Locating validate button
  	@FindBy(xpath="//button[@id='assign_task_submit']")
	private WebElement validatebutton;
  	
  	 //Locating project updated text for assign role
    @FindBy(xpath="//div[@class='alert alert-success']")
    private WebElement updateassignrole;
    
    //Locating user mgmt link
    @FindBy(xpath="//a[4]//img[1]")
    private WebElement usermgmt;
    
  //locating user checkbox
  	@FindBy(xpath="//table/tbody/tr[2]/td[1]")
  	private WebElement usercheckbox;
  	
  	//locating register button
  	@FindBy(xpath="//tr[2]//td[5]//a[1]")
  	private WebElement registerbutton;
  	
  //Locating project updated text for user mgmt
    @FindBy(xpath="//div[@class='alert alert-success']")
    private WebElement usermgmttext;
    
	
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
	//clicking project icon
	public void clickProjectIcon()
	{
		this.projecticon.click();
	}
   //clicking Description icon on new page
	public void clickNewProjectIcon()
	{
		this.newprojecticon.click();
	}
	//entering title
	public void sendProjectTitle(String title)
	{
		this.projectname=title;
		this.projecttitletextbox.clear();
		this.projecttitletextbox.sendKeys(title);
		
	}
	
	//Entering subtitle
	public void sendProjectSubTitle(String title)
	{
		this.projectsubtitle.clear();
		this.projectsubtitle.sendKeys(title);
		
	}
	
	//click on saveblog button
	public void clickSaveBlogButton()
	{
		this.saveblogbutton.click();
	}
	
	public void assertingupdates()
	{
		String actual=this.updatetext.getText();
		String expected ="The project has been added.";
		Assert.assertEquals(actual, expected);
		System.out.println("project is added successfully passed");
	}
	//searching for project created in above steps and 
	//processing the same project using all the below functions
	public void clickProjectLink()
	{
		int rowcount=driver.findElements(By.xpath("//tbody[1]/tr")).size();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		System.out.println("row count is"+rowcount);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		System.out.println(projectname);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
		String before="//tbody[1]/tr[";
		String after="]/td[1]/a[1]";
		for(int i=2;i<rowcount;i++)
		{
			String pname=driver.findElement(By.xpath(before+ i+after)).getText();
			System.out.println(i + pname);
			if (pname.equalsIgnoreCase(projectname))
			{
				WebElement projectlink=driver.findElement(By.xpath(before+ i+after));
				projectlink.click();
				break;
			}
		}
	}
	
	//click on New task link
		public void clickNewTask()
		{
			this.newtasklink.click();
		}
		
	//Entering title in title textbox
		public void sendTitle(String title)
		{
			this.titletextbox.clear();
			this.titletextbox.sendKeys(title);
			
		}
		
		//click on save button
		public void clickSave()
		{
			this.savebutton.click();
		}
		
		//asserting the task creation updates
		public void assertingtaskupdates()
		{
			String actual=this.updatetask.getText();
			String expected ="The article has been added.";
			Assert.assertEquals(actual, expected);
			System.out.println("task is added successfully");
		}
		
		//click on role mgmt link
		public void clickRoleMgmt()
		{
			this.rolemgmtlink.click();
		}
		
		//click on new role link
		public void clickNewRole()
		{
			this.newrolelink.click();
		}
				
		//Entering title in title textbox
		public void sendNewRoleTitle(String title)
		{
			this.newroletitle.clear();
			this.newroletitle.sendKeys(title);
					
		}
				
		//click on save button
		public void clickNewRoleSave()
		{
			this.newrolesavebutton.click();
		}
		
		//asserting new role updates
		public void assertingNewRoleupdates()
		{
			 String actual=this.updatenewrole.getText();
			String expected ="The task has been created";
			Assert.assertEquals(actual, expected);
			System.out.println("new role is added successfully");
		}
		
		//click on  assign new role link
		public void clickAssignNewRole()
		{
			this.assignnewrole.click();
		}
		
		//selecting user value from user dropdown
		public void selectUser(String username)
		{
			Select select=new Select(userdropdown);
			select.selectByVisibleText(username);;
		}
		
	//clicking on validate link
	public void clickValidate()
	{
			this.validatebutton.click();
	}
	
	//asserting new role updates
		public void assertingassignRoleupdates()
		{
			String actual=this.updateassignrole.getText();
			String expected ="The task has been assigned.";
			Assert.assertEquals(actual, expected);
			System.out.println("user has been assigned successfully");
		}
	
	//click on usermgmt  button
	public void clickUserMgmt()
	{
		this.usermgmt.click();
	}
	
	//selecting user to subscribe
		public void SelectUserToSubscribe()
		{
			this.usercheckbox.click();
		}
	
	//selecting user to subscribe
		public void clickRegisterButton()
		{
			this.registerbutton.click();
		}
		
	//asserting the updation
	public void assertinusermgmtupdates()
	{
		String actual=this.usermgmttext.getText();
		String expected ="The description has been updated";
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion passed");
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

