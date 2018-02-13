package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
  
	//Page Factory-OR
	
	@FindBy(name="username")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginButton;	
	
	@FindBy(xpath="//button[Contains(text(),'Sign Up')]")
	WebElement SignInBtn;
	
	@FindBy(xpath="//div[2]/div/div[1]/a/img[@class='img-responsive']")
	WebElement crmLogo;
	
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver,this);
		
		}

	//Actions	
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
				
	}
	
	public boolean validatecrmLogo() {
		return crmLogo.isDisplayed();
		
	}
	
	public HomePage validateLogin(String un,String pwd) {
	
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		LoginButton.submit();
		return new HomePage();
	}
	
}
