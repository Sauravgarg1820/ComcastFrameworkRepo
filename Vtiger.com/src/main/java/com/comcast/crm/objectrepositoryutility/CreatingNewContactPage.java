package com.comcast.crm.objectrepositoryutility;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver=null;

	public CreatingNewContactPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);	
		this.driver= driver;	
	}

		
		@FindBy(name = "lastname")
		private WebElement contact_Lastname;
		
		@FindBy(name = "mobile")
		private WebElement contact_Mobile;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement Contact_savebtn;
		
		@FindBy(xpath = "(//img[@src=\"themes/softed/images/select.gif\"])[1]")
		private WebElement orgname_symbolbtn;
		
		@FindBy(name = "support_start_date")
		private WebElement supportstartdate;
		
		@FindBy(name = "support_end_date")
		private WebElement supportenddate;


		public WebElement getContact_Lastname() {
			return contact_Lastname;
		}

		public WebElement getContact_Mobile() {
			return contact_Mobile;
		}

		public WebElement getContact_savebtn() {
			return Contact_savebtn;
		}
		public WebElement getOrgname_symbolbtn() {
			return orgname_symbolbtn;
		}
		
		public WebElement getSupportstartdate() {
			return supportstartdate;
		}

		public WebElement getSupportenddate() {
			return supportenddate;
		}

			//business logic
			public void saveContactInfo(String lastName, String contactNumber) {
			contact_Lastname.sendKeys(lastName);
			contact_Mobile.sendKeys(contactNumber);
			Contact_savebtn.click();			
		}
			public void saveContactWithOrgNameInfo(String lastName) {
				contact_Lastname.sendKeys(lastName);
				orgname_symbolbtn.click();
			}
			public void saveContactInfoWithDate(String lastName, String contactNumber, String startDate, String endDate) {
				contact_Lastname.sendKeys(lastName);
				contact_Mobile.sendKeys(contactNumber);
				supportstartdate.clear();
				supportstartdate.sendKeys(startDate);
				supportenddate.clear();
				supportenddate.sendKeys(endDate);
				
				Contact_savebtn.click();			
			}

}
