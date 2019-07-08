package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAddPostsCategoryPOM {
	private WebDriver driver; 
	
	public AdminAddPostsCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//for username 
	@FindBy(id="user_login")
	private WebElement userName; 
	
	//for password
	@FindBy(id="user_pass")
	private WebElement password;
	
	//for login button
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	//for Posts link
	@FindBy(linkText="Posts")
	private WebElement Posts;
	
	//for AllPosts link
		@FindBy(linkText="All Posts")
		private WebElement All_Posts;
	
		//for Add New link
				@FindBy(linkText="Add New")
				private WebElement Add_New;
				
	//for Categories link
		@FindBy(linkText="Categories")
		private WebElement Categories;
		
	//for CategoryName
		@FindBy(name="tag-name")
		private WebElement CategoryName;
		
	//for SlugName
				@FindBy(name="slug")
				private WebElement SlugName;
	
	//for Description
				@FindBy(name="description")
				private WebElement description;
				
	//for Add new category
				@FindBy(name="submit")
				private WebElement AddNewCategoryBtn;
				
	//for enter Title
				@FindBy(name="post_title")
				private WebElement EnterTitle;
	
	//for entering Content
				@FindBy(name="content")
				private WebElement bodytext;
				
	//for checkbox next to category created
				@FindBy(id="in-category-456")
				private WebElement createdcategory;
				
	//for publish
				@FindBy(id="publish")
				private WebElement publish;
				
				//for publishedmessage
				@FindBy(xpath="//*[contains(text(),'View Post')]")
				//xpath="//*[contains(@type,'sub')] "
				private WebElement msg;
				
	//Method for entering user name
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	//Method for entering password
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	//Method for clicking on login button
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	//Method for clicking on Posts link
	public void clickPosts() {
		this.Posts.click(); 
	}

	//Method for clicking on All Posts link
		public void clickAll_Posts() {
			this.All_Posts.click(); 
		}
		//Method for clicking on Add New link
				public void clickAddNew() {
					this.Add_New.click(); 
				}
	//Method for clicking on Categories link
			public void clickCategories() {
				this.Categories.click(); 
			}
   //Method for entering name in category
			public void sendname(String CategoryName) {
				this.CategoryName.clear();
				this.CategoryName.sendKeys(CategoryName);
			}
  //Method for entering  slug name in category
			public void sendslugname(String SlugName) {
				this.SlugName.clear();
				this.SlugName.sendKeys(SlugName);
			}
			
  //Method for entering description in category
			public void senddescription(String Description) {
				this.description.clear();
				this.description.sendKeys(Description);
			}
			
  //Method for clicking on AddNewcategory Button
			public void clickAddNewcategory() {
				this.AddNewCategoryBtn.click();
			}
			
			//Method for entering Title in AddNew
			public void enterTitle(String Title) {
				this.EnterTitle.clear();
				this.EnterTitle.sendKeys(Title);
			}
			
			//Method for entering bodyText
			public void enterbodytext(String bodytext) {
				this.bodytext.clear();
				this.bodytext.sendKeys(bodytext);
			}
			
			//Method for selecting checkbox 
			
			public void selectingcheckbox()
			{
				this.createdcategory.click();
			}
			
			@FindBy(xpath="//div[@id='major-publishing-actions']")
			private WebElement publishmenu;
			
			//Method for clicking publishbutton
			public void clickpublish() throws InterruptedException 
			{
				driver.switchTo().defaultContent();
				this.publishmenu.click();
				Thread.sleep(1000);
				this.publish.click();	
			}
			
			//Method for getting publishmsg
			public String getmsg()
			{
				String s1=msg.getText();
				return s1;
			}
			
			//Method for clicking on Viewpost
			public void clickviewpost()
			{
				this.msg.click();
			}
			
			//xpath for blogmessage
			@FindBy(xpath="//div[@class='post-content']//a[contains(text(),'New Launches')]")
			private WebElement blogmsg;
			
			//Method for getting blogmsg
			public String getblogmsg()
			{
				String blog_msg=blogmsg.getText();
				return blog_msg;
			}
			
}


