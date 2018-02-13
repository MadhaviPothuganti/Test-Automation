package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory-OR
	
	//@FindBy(xpath="//td[contains(text(), User: john paul')]")
	@FindBy(xpath="/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement userNameLabel;
	
	/*@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;*/
	@FindBy(xpath="//*[@id=\"navmenu\"]/ul/li[4]/a")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="/html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[4]/ul/li[1]/a")
	WebElement newContactsLink;
	//Initializing the page objects
		public HomePage() {
			PageFactory.initElements(driver,this);
			
			}
       
		
		//Actions	
		
		public String validateHomePageTitle() {
			return driver.getTitle();
           }
		
		public boolean verifyCorrectUserName() {
			return userNameLabel.isDisplayed();
			
		}
		
		public ContactsPage clickOnContactslink() {
			
			contactsLink.click();
			return new ContactsPage();
		}
		
		public DealsPage clickOnDealslink() {
			dealsLink.click();
			return new DealsPage();
		}
        
		public TasksPage clickOnTasksLink() {
        	tasksLink.click();
        	return new TasksPage();
        }
       
        public void clickOnNewContactsLink() {
        	
        	Actions action =  new Actions(driver);
        	action.moveToElement(contactsLink).build().perform();
        	newContactsLink.click();
        }

}