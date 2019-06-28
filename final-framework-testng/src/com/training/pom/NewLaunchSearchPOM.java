package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;


public class NewLaunchSearchPOM {
private WebDriver driver; 
	
	public NewLaunchSearchPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='http://realestatem1.upskills.in/region/new-launch-in-bangalore/']")
	private WebElement newLaunch; 
	
	@FindBy(name="keyword_search")
	private WebElement Enteraddress;
	
	@FindBy(xpath="//a[@class='chosen-single chosen-default']")
	private WebElement  propertyselection;
	
	@FindBy(xpath="//a[@class='chosen-single chosen-default']")
	private WebElement AnyRegions;
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement search;
	
	
	public void clicknewLaunch() {
		this.newLaunch.click(); 
	}
	
	public void sendenteraddress(String Enteraddress) throws InterruptedException {
		this.Enteraddress.clear();
		this.Enteraddress.sendKeys(Enteraddress);
		Thread.sleep(3000);
		this.Enteraddress.sendKeys(Keys.DOWN);
		Thread.sleep(3000);
		this.Enteraddress.sendKeys(Keys.ENTER);
	}
	
	public void selectpropertytype(String propertytype) throws InterruptedException
	{   
		/*Select propertyselection = new Select(driver.findElement(By.name("_property_type")));
		//Select property = new Select(propertyselection);
	     propertyselection.selectByVisibleText(propertytype);*/
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				 
				
		
			.moveToElement(propertyselection).click()
			
			.sendKeys(Keys.ARROW_DOWN)
		    .sendKeys(Keys.ARROW_DOWN)
		    .sendKeys(Keys.ARROW_DOWN)
		    .sendKeys(Keys.ENTER)
			.build();
			
		seriesOfActions.perform() ;
		
		Thread.sleep(3000);
	     
	}
	
	public void selectanyregion(String taxregion) throws InterruptedException
	{   
		/*Select region = new Select(AnyRegions);
	     region.selectByVisibleText(taxregion);
	 */
		
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(AnyRegions)
			.click()
			.sendKeys(Keys.ARROW_DOWN)
		    .sendKeys(Keys.ARROW_DOWN)
		    .sendKeys(Keys.ENTER)
			.build();
			
		seriesOfActions.perform() ;
		
		Thread.sleep(3000);
	  
	}
	
	
	
	
	public void clicksearch() {
		this.search.click(); 
	}


}
