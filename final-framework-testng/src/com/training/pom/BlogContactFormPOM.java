package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BlogContactFormPOM {
private WebDriver driver; 
	
	public BlogContactFormPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='http://realestatem1.upskills.in/blog/']")
	private WebElement blog; 
	
	@FindBy(xpath="//a[@href='/contact/']")
	private WebElement Dropusaline;
	
	@FindBy(name="name")
	private WebElement contactformname;
	
	@FindBy(name="email")
	private WebElement contactformemail;
	
	@FindBy(name="subject")
	private WebElement contactformsubject;
	
	@FindBy(name="id:comments")
	private WebElement contactformmessage;
	
	@FindBy(xpath="//input[@value='Send']")
	private WebElement contactformsend;
	
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement contactformsearchmsg;
	
	
	public void clickblog() {
		this.blog.click(); 
	}
	
	public void clickdropusaline() {
		this.Dropusaline.click(); 
	}
	
	public void sendname(String name) {
		this.contactformname.clear();
		this.contactformname.sendKeys(name);
	}
	
	public void sendemail(String email) {
		this.contactformemail.clear();
		this.contactformemail.sendKeys(email);
	}
	
	public void sendsubject(String subject) {
		this.contactformsubject.clear();
		this.contactformsubject.sendKeys(subject);
	}
	public void sendemessage(String message) {
		this.contactformmessage.clear();
		this.contactformmessage.sendKeys(message);
	}
	public void clicksend() {
		this.contactformsend.click(); 
	}
	
	public String getcontactformsearchmsg() {
		
		String S1=this.contactformsearchmsg.getText();
		
		return S1;
	}
	
	
	
}
	
