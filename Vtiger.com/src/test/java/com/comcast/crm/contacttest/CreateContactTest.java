package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.generic.fileutility.ExcelUtility;

public class CreateContactTest extends BaseClass {

	@Test
	public void createContactTest() throws Throwable {

		// excelutility
		ExcelUtility eu = new ExcelUtility();
		String LastName = eu.getDataFromExcel("Sheet1", 1, 7) + jLib.getRandomNumber();
		String ContactNumber = eu.getDataFromExcel("Sheet1", 1, 8);

		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getContacts_symbolbtn().click();

		Thread.sleep(2000);

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
}