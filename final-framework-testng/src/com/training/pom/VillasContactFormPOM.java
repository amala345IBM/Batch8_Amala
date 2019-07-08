package com.training.pom;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class VillasContactFormPOM {
private WebDriver driver; 
	
	public VillasContactFormPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//for Villas
	@FindBy(linkText="VILLAS")
	private WebElement Villas;
	
	//for address
	@FindBy(name="keyword_search")
	private WebElement Enteraddress;
	
	//for property type
	@FindBy(xpath="//a[@class='chosen-single chosen-default']")
	private WebElement  propertyselection;
	
	//for Region type
	@FindBy(xpath="//a[@class='chosen-single chosen-default']")
	private WebElement AnyRegions;
	
	//for search
	@FindBy(xpath="//button[text()='Search']")
	private WebElement search;
	
	//for drop us a line
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
	
	//for send button
	@FindBy(xpath="//input[@value='Send']")
	private WebElement contactformsend;
	
	//for msg displayed
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement contactformsearchmsg;
	
	
	
	//Method for clicking on villas
	public void clickvillas()
	{
		this.Villas.click();
	}
	
	
	//Method for Entering address
	public void sendenteraddress(String Enteraddress){
		this.Enteraddress.clear();
		this.Enteraddress.sendKeys(Enteraddress);
		
	}
	
	
	
	//Method for selecting property type as villas
	public void selectpropertytype()
	{   
		
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
		    .moveToElement(propertyselection).click()
			.sendKeys(Keys.ARROW_DOWN)
		    .sendKeys(Keys.ARROW_DOWN)
		    .sendKeys(Keys.ENTER)
			.build();
			
		seriesOfActions.perform() ;
		
	}
	
	
	//Method for selecting regiontype
	public void selectanyregion() 
	{   
		
		
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(AnyRegions)
			.click()
			.sendKeys(Keys.ARROW_DOWN)
		    .sendKeys(Keys.ENTER)
			.build();
			
		seriesOfActions.perform() ;
		
	  }
	
	
	//Method for clicking on search button
	public void clicksearch() {
		this.search.click(); 
	}

    //Method for clicking on drop as a line link
	public void clickdropusaline() {
		this.Dropusaline.click(); 
	}
	
	//Method for entering name in contact form
	public void sendname(String name) {
		this.contactformname.clear();
		this.contactformname.sendKeys(name);
	}
	
	//method for entering email in contact form
	public void sendemail(String email) {
		this.contactformemail.clear();
		this.contactformemail.sendKeys(email);
	}
	
	//method for entering subject in contact form
	public void sendsubject(String subject) {
		this.contactformsubject.clear();
		this.contactformsubject.sendKeys(subject);
	}
	
	//method for entering message in contact form
	public void sendemessage(String message) {
		this.contactformmessage.clear();
		this.contactformmessage.sendKeys(message);
	}
	
	//method for clicking on send button in contact form
	public void clicksend() {
		this.contactformsend.click(); 
	}
	
	
	//method for getting text msg displayed after clicking on send in contact form message
	public String getcontactformsearchmsg() {
		
		String S1=this.contactformsearchmsg.getText();
		
		return S1;
	}
	
	
	
}
	

