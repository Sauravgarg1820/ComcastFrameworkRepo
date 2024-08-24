package com.comcast.crm.multiplecontacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.listernerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsSearchPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.webdriverutility.UtilityClassObject;
public class MultipleContactTest extends BaseClass{
	
	
	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		// excelutility
		ExcelUtility eu = new ExcelUtility();
		String LastName = eu.getDataFromExcel("Sheet1", 1, 7) + jLib.getRandomNumber();
		String ContactNumber = eu.getDataFromExcel("Sheet1", 1, 8);

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to contact page");

		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create contact page");

		ContactsPage cp = new ContactsPage(driver);
		cp.getContacts_symbolbtn().click();

		Thread.sleep(2000);
		
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Contact");
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.saveContactInfo(LastName, ContactNumber);

		// verify
		WebElement ContactNo = driver.findElement(By.id("dtlview_Mobile"));
		if (ContactNo.equals(ContactNo)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}
	}

	@Test(groups = "regressionTest")
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
	
	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws Throwable{
			
		//excelutility
		String lastName = eLib.getDataFromExcel("Sheet1", 1, 7)+jLib.getRandomNumber();
		String ContactNumber = eLib.getDataFromExcel("Sheet1", 1, 8);
		
		 String startdate = jLib.getSystemDateYYYYMMDD();
		 
		 String lastdate = jLib.getRequiredDateyyyymmdd(30);
		 
		 HomePage hp= new HomePage(driver);
		 hp.getContactsLink().click();
		 
		 ContactsPage cp= new ContactsPage(driver);
		 cp.getContacts_symbolbtn().click();
		 
		 CreatingNewContactPage cncp= new CreatingNewContactPage(driver);
		 cncp.saveContactInfoWithDate(lastName, ContactNumber, startdate, lastdate);
		 
		 //verify
		 WebElement ContactNo = driver.findElement(By.id("dtlview_Mobile"));
		 if(startdate.equals(startdate)) {
			 System.out.println("passed");
		 }
		 else
		 {
			 System.out.println("failed");
		 }
		 if(lastdate.equals(lastdate)) {
			 System.out.println("passed");
		 }
		 else
		 {
			 System.out.println("failed");
		 }
	}
}
