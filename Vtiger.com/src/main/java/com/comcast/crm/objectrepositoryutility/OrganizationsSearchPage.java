package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.generic.webdriverutility.WebdriverUtility;

public class OrganizationsSearchPage {
	WebDriver driver=null;

	public OrganizationsSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	this.driver=driver;	
	}
	
	@FindBy(name = "search_text")
	private WebElement searchArea;
	
	@FindBy(name = "search")
	private WebElement searchBtn;

	public WebElement getSearchArea() {
		return searchArea;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public void searchOrgname(String orgname) {
		searchArea.sendKeys(orgname);
		searchBtn.click();
		
	}
	

}
