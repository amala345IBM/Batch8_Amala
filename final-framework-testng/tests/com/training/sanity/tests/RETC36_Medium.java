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
import com.training.pom.NewLaunchSearchPOM;
import com.training.pom.VillasContactFormPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC36_Medium {

	private WebDriver driver;
	private String baseUrl;
	private NewLaunchSearchPOM newlaunchsearchPOM;
	private VillasContactFormPOM newVillasContactFormPOM;
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
		newVillasContactFormPOM= new VillasContactFormPOM(driver);
		newlaunchsearchPOM = new NewLaunchSearchPOM(driver);
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
		
		newVillasContactFormPOM.clickvillas();
		newVillasContactFormPOM.sendenteraddress("Nullam hendrerit apartment");
		newVillasContactFormPOM.selectpropertytype();
		newVillasContactFormPOM.selectanyregion();
		newVillasContactFormPOM.clicksearch();
		newVillasContactFormPOM.clickdropusaline();
		newVillasContactFormPOM.sendname("selenium");
		newVillasContactFormPOM.sendemail("selenium@gmail.com");
		newVillasContactFormPOM.sendsubject("apartment");
		newVillasContactFormPOM.sendemessage("looking for apartment");
		newVillasContactFormPOM.clicksend();
		String Expected="Thank you for your message. It has been sent.";
		String Actual=newVillasContactFormPOM.getcontactformsearchmsg();
		screenShot.captureScreenShot("message_display");
		
		System.out.println(Expected);
		System.out.println(Actual);
		Assert.assertEquals(Actual, Expected);
		
		}
}



