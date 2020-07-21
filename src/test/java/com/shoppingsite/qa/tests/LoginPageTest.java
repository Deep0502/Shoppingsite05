package com.shoppingsite.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import com.shoppingsite.qa.base.TestBase;
import com.shoppingsite.qa.pageObjects.LoginPage;
import com.shoppingsite.qa.pageObjects.SearchPage;

public class LoginPageTest extends TestBase {
 
	LoginPage loginPage;
	SearchPage searchPage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		//TestBase construct call ..
		super();
	}
	@BeforeMethod
	public void setUp() {
	  initialization();
	  loginPage = new LoginPage();
	  searchPage = new SearchPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
      String title =loginPage.validateTitle();
      Assert.assertEquals(title, "MySite");
	}
	
	@Test(priority=2)
	public void loginTest() {
	 searchPage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	 log.info("Logged in to MySite");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
