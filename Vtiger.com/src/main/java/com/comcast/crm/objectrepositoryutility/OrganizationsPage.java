package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class OrganizationsPage {
	WebDriver driver=null;

	public OrganizationsPage(WebDriver driver) {	
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	WebElement CreateOrganization;

	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(id = "bas_searchfield")
	private WebElement searchDD;
	
	@FindBy(name = "submit")
	private WebElement serachbtn;

	
	public WebElement getCreateOrganization() {
		return CreateOrganization;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSerachbtn() {
		return serachbtn;
	}
	
	
	
	
	
}
