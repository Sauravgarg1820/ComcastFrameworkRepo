package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver=null;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Campaign")
	private WebElement campaignlink;
	
	@FindBy(linkText = "More")
	private WebElement morelink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminImg;
	
	@FindBy(xpath = "//a[@href=\"index.php?module=Users&action=Logout\"]")
	private WebElement signOutLink;
	
	
//getters
	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}


	public WebElement getContactsLink() {
		return contactsLink;
	}


	public WebElement getCampaignlink() {
		return campaignlink;
	}


	public WebElement getMorelink() {
		return morelink;
	}


	public WebElement getAdminImg() {
		return adminImg;
	}


	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	
	// methods 
		
	public void navigateTocampaignPage() {
		Actions action= new Actions(driver);
		action.moveToElement(morelink).perform();
		campaignlink.click();
		
	}

		public void logout() {
		Actions action= new Actions(driver);
		action.moveToElement(adminImg).perform();
		action.click(signOutLink).perform();
				
	}




	

}
