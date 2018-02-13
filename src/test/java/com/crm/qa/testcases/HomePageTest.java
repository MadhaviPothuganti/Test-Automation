package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super(); //this call super class constructor(TestBase) to initialize the properties
	}
	// Test cases should be separated ---independent with each other
	//before each test case-- launch browser and login
	//@test -- execute test case
	//after each test case - close the browser
	
	
	
	@BeforeMethod
	public void setup() {
		intitialization();
		loginPage = new LoginPage();
		testUtil =  new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		
		String HomePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(HomePageTitle, "CRMPRO","HomePage Title is not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLink() {
		
		testUtil.switchToFrame();
		contactsPage= homePage.clickOnContactslink();
	}
	
	
	@AfterMethod
	public void testDown() {
	
		driver.quit();
	}
	
	
}
