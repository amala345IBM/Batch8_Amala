package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BlogContactFormPOM {
private WebDriver driver; 
	
	public BlogContactFormPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//for Blog
	@FindBy(linkText="BLOG")
	private WebElement blog; 
	
	//for Drop us a line
	@FindBy(xpath="//a[@href='/contact/']")
	private WebElement Dropusaline;
	
	//for name
	@FindBy(name="name")
	private WebElement contactformname;
	
	//for email
	@FindBy(name="email")
	private WebElement contactformemail;
	
	//for subject
	@FindBy(name="subject")
	private WebElement contactformsubject;
	
	//for message
	@FindBy(name="id:comments")
	private WebElement contactformmessage;
	
	//for send
	@FindBy(xpath="//input[@value='Send']")
	private WebElement contactformsend;
	
	//for message displayed after clicking on send
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement contactformsearchmsg;
	
	
	//Method for clicking on Blog
	public void clickblog() {
		this.blog.click(); 
	}
	
	//Method for clicking on drop us a line
	public void clickdropusaline() {
		this.Dropusaline.click(); 
	}
	
	//Method for Entering name
	public void sendname(String name) {
		this.contactformname.clear();
		this.contactformname.sendKeys(name);
	}
	
	//Method for Entering email
	public void sendemail(String email) {
		this.contactformemail.clear();
		this.contactformemail.sendKeys(email);
	}
	
	//Method for Entering subject
	public void sendsubject(String subject) {
		this.contactformsubject.clear();
		this.contactformsubject.sendKeys(subject);
	}
	
	//Method for Entering message
	public void sendmessage(String message) {
		this.contactformmessage.clear();
		this.contactformmessage.sendKeys(message);
	}
	
	//Method for clicking on send button
	public void clicksend() {
		this.contactformsend.click(); 
	}
	
	//Method for getting message displayed after clicking on  send button in contact form
	public String getcontactformsearchmsg() {
		
		String S1=this.contactformsearchmsg.getText();
		
		return S1;
	}
	
	
	
}
	
