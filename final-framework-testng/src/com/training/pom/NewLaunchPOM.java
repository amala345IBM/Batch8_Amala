package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLaunchPOM {
	
private WebDriver driver; 
	
	public NewLaunchPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='http://realestatem1.upskills.in/region/new-launch-in-bangalore/']")
	private WebElement newLaunch; 
	
	@FindBy(xpath="//a[@href='http://realestatem1.upskills.in/donec-quis/']")
	private WebElement donecQuis;
	
	@FindBy(name="your-name")
	private WebElement yourname;
	
	@FindBy(name="your-email")
	private WebElement youremail;
	
	@FindBy(name="your-subject")
	private WebElement yoursubject;
	
	@FindBy(name="your-message")
	private WebElement yourmessage;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement send;
	
	////*[contains(text(),'There was an error trying to send your message. Please try again later.')]
	
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement actual;
	
	@FindBy(name="amount")
	private WebElement saleprice;
	
	@FindBy(id="downpayment")
	private WebElement downpayment;
	
	@FindBy(id="years")
	private WebElement loantermyears;
	
	@FindBy(id="interest")
	private WebElement interestrate;
	
	
	//calculate button
	@FindBy(xpath="//button[@class='button calc-button']")
	private WebElement calculate;
	
	//message after calculation
	@FindBy(xpath="//div[@class='notification success']")
	private WebElement Mortgagecalculationmsg;
	
	
	public void clicknewLaunch() {
		this.newLaunch.click(); 
	}
	
	public void clickdonecQuis() {
		this.donecQuis.click(); 
	}
	
	public void sendyourname(String yourname) {
		this.yourname.clear();
		this.yourname.sendKeys(yourname);
	}
	
	public void sendyouremail(String youremail) {
		this.youremail.clear();
		this.youremail.sendKeys(youremail);
	}
	
	public void sendyoursubject(String yoursubject) {
		this.yoursubject.clear();
		this.yoursubject.sendKeys(yoursubject);
}
	
	public void sendyourmessage(String yourmessage) {
		this.yourmessage.clear();
		this.yourmessage.sendKeys(yourmessage);
	
}
	
	public void clickonsend() {
		this.send.click();
}
	
	public String getenquirymessage() {
		
		String s1=actual.getText();
		return s1;
	}
	
	public void sendSalePrice(String saleprice) {
		this.saleprice.clear();
		this.saleprice.sendKeys(saleprice);
	}
	
	public void senddownpayment(String downpayment) {
		this.downpayment.clear();
		this.downpayment.sendKeys(downpayment);
	}
	
	public void sendloantermyears(String loantermyears) {
		this.loantermyears.clear();
		this.loantermyears.sendKeys(loantermyears);
	}
	
	public void sendinterestrate(String interestrate) {
		this.interestrate.clear();
		this.interestrate.sendKeys(interestrate);
	}
	
	public void clickcalculate() {
		this.calculate.click(); 
	}
	
	public String captureMortgageCalculationMsg()
	{
		String msg=Mortgagecalculationmsg.getText();
		return msg;
	}
	
	
	public void scrolldown()
	{
		//WebDriver driver = new ChromeDriver();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement w1=driver.findElement(By.name("your-message"));
		//jse.executeScript("window.scrollBy(0,250)", "W1");
		jse.executeScript("arguments[0].scrollIntoView(true);",w1);
	}
}



