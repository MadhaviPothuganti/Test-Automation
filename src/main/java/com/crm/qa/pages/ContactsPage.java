package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

     //Page factory -OR
    @FindBy(xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
    WebElement contactsLable;


    //Actions
    
    public boolean verifycontactsLable() {
    	return contactsLable.isDisplayed();
    	
    }
    
    
    

}
