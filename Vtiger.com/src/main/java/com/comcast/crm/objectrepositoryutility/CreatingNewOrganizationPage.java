package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver=null;

	
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
		
		this.driver=driver;
	}
		@FindBy(name = "accountname")
		private WebElement OrganizationName;
		
		@FindBy(name = "industry")
		private WebElement IndustryText;
		
		@FindBy(name = "accounttype")
		private WebElement IndustryTypeText;
		
		@FindBy(name = "phone")
		private WebElement PhoneNumber;
		 
		@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
		private WebElement OrganizationSaveButton;

		
		public WebElement getOrganizationName() {
			return OrganizationName;
		}

		public WebElement getIndustryText() {
			return IndustryText;
		}

		public WebElement getIndustryTypeText() {
			return IndustryTypeText;
		}

		public WebElement getPhoneNumber() {
			return PhoneNumber;
		}

		public WebElement getOrganizationSaveButton() {
			return OrganizationSaveButton;
		}
		

		public void createOrg(String orgName) {
			OrganizationName.sendKeys(orgName);
			OrganizationSaveButton.click();			
		}
		
		public void createOrg(String orgName, String industrytext) {
			OrganizationName.sendKeys(orgName);
			Select select= new Select(IndustryText);
			select.selectByVisibleText(industrytext);
			OrganizationSaveButton.click();			
		}
		public void createOrgWithIndustry(String orgName, String industrytext, String industrytypetext ) {
			OrganizationName.sendKeys(orgName);
			Select select= new Select(IndustryText);
			select.selectByVisibleText(industrytext);
			
			Select select1= new Select(IndustryTypeText);
			select1.selectByVisibleText(industrytypetext);
			
			OrganizationSaveButton.click();			
		}
		
		
	}

