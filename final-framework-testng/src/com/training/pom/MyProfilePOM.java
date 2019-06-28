package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePOM {
private WebDriver driver; 
	
	public MyProfilePOM(WebDriver driver) {
		this.driver = driver;
		//driver.findElement(By.linkText(linkText))
		PageFactory.initElements(driver, this);
	}
	
	/*@FindBy(css="user-name")
	private WebElement userHyperLink; */
	
	@FindBy(xpath="//*[@id=\'post-133\']/div[1]/div/div/ul[2]/li[2]/a")
	private WebElement userHyperLink;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	
	@FindBy(linkText="Log Out")
	private WebElement logoutLink;
	
	
	
	
	public void clickUserHyperLink() {
		this.userHyperLink.click(); 
	
	}
	
	public void clickLogOutLink() {
		this.logoutLink.click(); 
	
	}
	
	

}
