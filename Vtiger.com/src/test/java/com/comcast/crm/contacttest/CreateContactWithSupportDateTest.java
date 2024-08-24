package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.comcast.generic.webdriverutility.JavaUtility;
import com.comcast.generic.webdriverutility.WebdriverUtility;

public class CreateContactWithSupportDateTest extends BaseClass
{

	@Test
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
	}}