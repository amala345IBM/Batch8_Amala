package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.PlotsContactFormPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC37_Medium {

	private WebDriver driver;
	private String baseUrl;
	private PlotsContactFormPOM newPlotsContactFormPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		//loginPOM = new LoginPOM(driver);
		newPlotsContactFormPOM= new PlotsContactFormPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		
		newPlotsContactFormPOM.clickplots();
		newPlotsContactFormPOM.sendenteraddress("Nullam hendrerit apartment");
		newPlotsContactFormPOM.selectpropertytype();
		newPlotsContactFormPOM.selectanyregion();
		newPlotsContactFormPOM.clicksearch();
		newPlotsContactFormPOM.clickdropusaline();
		newPlotsContactFormPOM.sendname("selenium");
		newPlotsContactFormPOM.sendemail("selenium@gmail.com");
		newPlotsContactFormPOM.sendsubject("apartment");
		newPlotsContactFormPOM.sendemessage("looking for apartment");
		newPlotsContactFormPOM.clicksend();
		String Expected="Thank you for your message. It has been sent.";
		String Actual=newPlotsContactFormPOM.getcontactformsearchmsg();
		screenShot.captureScreenShot("message_display");
		
		System.out.println(Expected);
		System.out.println(Actual);
		Assert.assertEquals(Actual, Expected);
		
		}
}



