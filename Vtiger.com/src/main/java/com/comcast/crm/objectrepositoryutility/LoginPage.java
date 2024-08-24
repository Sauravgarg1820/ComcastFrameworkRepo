package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.generic.webdriverutility.WebdriverUtility;

import io.reactivex.rxjava3.internal.operators.maybe.MaybeContains;

/**
 * login to application based on username, password, url arguments
 * @author Sauravgarg
 * contains login page element @business lib like login()
 */

public class LoginPage extends WebdriverUtility{	

	WebDriver driver;
	//constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;

	}
	
	
	// object created and intialize the object with private keyword
	 @FindBy(name="user_name")
	 private WebElement usernameEdt;
	 
	 @FindBy(name="user_password")
	 private WebElement userpasswordEdt;
	 
	 @FindBy(id="submitButton")
	 private WebElement loginBtn;

	 
	 //object encapsulation
	 
	 public WebElement getUsernameEdt() {
			return usernameEdt;
		}

	 public WebElement getUserpasswordEdt() {
			return userpasswordEdt;
		}

	 public WebElement getLoginBtn() {
			return loginBtn;
		}
	 /**
	  * 
	  * @param username
	  * @param password
	  * @throws Throwable
	  */
	 
	 public void loginToApp(String username , String password) throws Throwable {
		 waitForPageToload(driver);
		 driver.manage().window().maximize();
		 usernameEdt.sendKeys(username);
		 userpasswordEdt.sendKeys(password);
		 loginBtn.click(); 
		 
	 }
	 
	 public void loginToApp(String url,String username , String password) throws Throwable {
		 waitForPageToload(driver);
		 driver.manage().window().maximize();
		 driver.get(url);
		 usernameEdt.sendKeys(username);
		 userpasswordEdt.sendKeys(password);
		 loginBtn.click(); 
		 
	 }
	 
	 
}
