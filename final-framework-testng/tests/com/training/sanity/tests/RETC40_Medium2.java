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
import com.training.pom.AdminAddPostsCategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC40_Medium2 {

	private WebDriver driver;
	private String baseUrl;
	private AdminAddPostsCategoryPOM admin_add_posts_categoryPOM;
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
		admin_add_posts_categoryPOM = new AdminAddPostsCategoryPOM(driver); 
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
	public void validLoginTest() throws InterruptedException  {
		admin_add_posts_categoryPOM.sendUserName("admin");
		admin_add_posts_categoryPOM.sendPassword("adminuser@12345");
		admin_add_posts_categoryPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("AdminProfile");
		admin_add_posts_categoryPOM.clickPosts();
		admin_add_posts_categoryPOM.clickCategories();
		admin_add_posts_categoryPOM.sendname("New Launches");
		admin_add_posts_categoryPOM.sendslugname("launch");
		admin_add_posts_categoryPOM.senddescription("New Launches of villas, apartments, flats");
		admin_add_posts_categoryPOM.clickAddNewcategory();
		admin_add_posts_categoryPOM.clickPosts();
		admin_add_posts_categoryPOM.clickAll_Posts();
		admin_add_posts_categoryPOM.clickAddNew();
		admin_add_posts_categoryPOM.enterTitle("New Launches");
		admin_add_posts_categoryPOM.enterbodytext("New Launch in Home");
		admin_add_posts_categoryPOM.selectingcheckbox();
		admin_add_posts_categoryPOM.clickpublish();
		String Expected="View Post";
		String Actual=admin_add_posts_categoryPOM.getmsg();
		System.out.println(Actual);
		System.out.println(Expected);
		Assert.assertEquals(Actual,Expected);
		admin_add_posts_categoryPOM.clickviewpost();
		String Expected1="New Launches";
		String Actual1=admin_add_posts_categoryPOM.getblogmsg();
		System.out.println(Actual1);
		System.out.println(Expected1);
		Assert.assertEquals(Actual1,Expected1);
		
	}
}
