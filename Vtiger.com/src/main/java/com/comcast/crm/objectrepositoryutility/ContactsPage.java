package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	

public class ContactsPage {
	WebDriver driver=null;

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	 this.driver= driver;
	}
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
		private WebElement Contacts_symbolbtn;

	public WebElement getContacts_symbolbtn() {
		return Contacts_symbolbtn;
	}
	

}
