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
import com.training.pom.BlogContactFormPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC10 {

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private BlogContactFormPOM newBlogContactFormPOM;
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
		newBlogContactFormPOM= new BlogContactFormPOM(driver);
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
		newBlogContactFormPOM.clickblog();
		newBlogContactFormPOM.clickdropusaline();
		newBlogContactFormPOM.sendname("manzoor");
		newBlogContactFormPOM.sendemail("manzoor@gmail.com");
		newBlogContactFormPOM.sendsubject("Apartments");
		newBlogContactFormPOM.sendemessage("Looking For Apartments");
		newBlogContactFormPOM.clicksend();
		String Expected="Thank you for your message. It has been sent.";
		String Actual=newBlogContactFormPOM.getcontactformsearchmsg();
		screenShot.captureScreenShot("Search");
		
		System.out.println(Expected);
		System.out.println(Actual);
		Assert.assertEquals(Actual, Expected);
		
		}
}



