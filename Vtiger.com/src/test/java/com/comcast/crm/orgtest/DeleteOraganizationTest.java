 package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OragnizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.comcast.generic.webdriverutility.JavaUtility;
import com.comcast.generic.webdriverutility.WebdriverUtility;

public class DeleteOraganizationTest extends BaseClass {
	
	@Test
	public void deleteOraganizationTest() throws Throwable {

	//excelutility
		String OrganizationNameFromExcel = eLib.getDataFromExcel("Sheet1", 10, 2)+jLib.getRandomNumber();
		
			HomePage hp= new HomePage(driver);
			hp.getOrganizationsLink().click();
			
			OrganizationsPage op = new OrganizationsPage(driver);
			op.getCreateOrganization().click();	
			
			CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			cnop.createOrg(OrganizationNameFromExcel);		
			

		 OragnizationInfoPage oip = new OragnizationInfoPage(driver);
			String headerName = oip.getHeadermsg().getText();

		 if(headerName.contains(OrganizationNameFromExcel)) {
			 System.out.println("Org Nameis Created");
		 }
		 else {
			 System.out.println("Org Name is not Created");
		 }
		 //verify actual organization name is equals to organization name
		 String actualOrganizationName = driver.findElement(By.id("dtlview_Organization Name")).getText();
			
			
			  if(actualOrganizationName.equals(actualOrganizationName))
			  {
			  System.out.println("Org Name is Created"); 
			  } 
			  else 
			  {
			  System.out.println("Org Name is not Created"); }
			  
			  //go back to organizations page
				
			  hp.getOrganizationsLink().click();
			  
			  //search for organization
			  op.getSearchEdt().sendKeys(OrganizationNameFromExcel);
			  wLib.selectbyvisibletext(op.getSearchDD(),"Organization Name");
			  op.getSerachbtn().click();
			  
			  //In dynamic webtable select & delete Organization
			  Thread.sleep(4000);
			  driver.findElement(By.xpath("(//a[text()='"+OrganizationNameFromExcel+"'])[2]/../..//a[text()='del']")).click();
		      wLib.switchToalertAndAccept(driver);
		      
		      System.out.println("The organization is deleted");
			  //logout
			  //hp.logout();

			 // driver.quit();
}}
