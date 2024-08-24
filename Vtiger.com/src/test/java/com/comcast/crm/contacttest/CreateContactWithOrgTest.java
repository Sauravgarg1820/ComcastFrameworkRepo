package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsSearchPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.comcast.generic.webdriverutility.JavaUtility;
import com.comcast.generic.webdriverutility.WebdriverUtility;

public class CreateContactWithOrgTest extends BaseClass{

	@Test
	public void createContactWithOrgTest() throws Throwable{
		
				
		//excelutility
		String lastName = eLib.getDataFromExcel("Sheet1", 1, 7)+jLib.getRandomNumber();
		String OrganizationName = eLib.getDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();		
		
		// create the organization
		HomePage hp= new HomePage(driver);
		hp.getOrganizationsLink().click();
		
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getCreateOrganization().click();
		
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.createOrg(OrganizationName);

		Thread.sleep(2000);
		
		hp.getContactsLink().click();
		
		ContactsPage cp= new ContactsPage(driver);
		cp.getContacts_symbolbtn().click();
		
		CreatingNewContactPage cncp= new CreatingNewContactPage(driver);
		cncp.saveContactWithOrgNameInfo(lastName);
		
		// switch the child window 
		wLib.switchToTabonUrl(driver, "module=Accounts");
		
		OrganizationsSearchPage osp= new OrganizationsSearchPage(driver);
		osp.searchOrgname(OrganizationName);
		
		driver.findElement(By.xpath("//a[text()='" + OrganizationName + "']")).click();

		
		// switch to parent window
		wLib.switchToTabonUrl(driver, "module=Contacts");

        cncp.getContact_savebtn().click();
       		
		Thread.sleep(2000);
		
		//verify
		/*
		 * String actualOrgName =
		 * driver.findElement(By.xpath("(//a[text()='"+OrganizationName+"'])[2]")).
		 * getText();
		 * 
		 * System.out.println(actualOrgName); if(actualOrgName.equals(OrganizationName))
		 * { System.out.println("pass"); } else { System.out.println("fail"); }
		 */
	}

}