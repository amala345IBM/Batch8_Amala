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
//import com.training.pom.LoginPOM;
import com.training.pom.NewLaunchPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC8 {

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private NewLaunchPOM newlaunchPOM;
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
		newlaunchPOM= new NewLaunchPOM(driver);
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
	public void validLoginTest() {
		//loginPOM.sendUserName("amalamallavarapu@gmail.com");
		//loginPOM.sendPassword("summer@123");
		//loginPOM.clickLoginBtn(); 
		
		
		//screenShot.captureScreenShot("MyProfile");
		newlaunchPOM.clicknewLaunch();
		newlaunchPOM.clickdonecQuis();
		newlaunchPOM.sendSalePrice("400000");
		newlaunchPOM.senddownpayment("20000");
		newlaunchPOM.sendloantermyears("20");
		newlaunchPOM.sendinterestrate("7.25");
		
		newlaunchPOM.clickcalculate();
		screenShot.captureScreenShot("MortgageCalculator");
		String expected="Monthly Payment: 3003.43 Rs.";
		String actual= newlaunchPOM.captureMortgageCalculationMsg();
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		
	}
}

