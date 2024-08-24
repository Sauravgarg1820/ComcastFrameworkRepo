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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OragnizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.comcast.generic.webdriverutility.JavaUtility;
import com.comcast.generic.webdriverutility.WebdriverUtility;

public class CreateOrganizationWithIndustriesTest extends BaseClass{

	@Test
	public void createOrganizationWithIndustriesTest() throws Throwable {
			
		//excelutility
		String lastName = eLib.getDataFromExcel("Sheet1", 1, 7)+jLib.getRandomNumber();
		String OrganizationName = eLib.getDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
		 String Industry = eLib.getDataFromExcel("Sheet1", 1, 4);
		String Industrytype =eLib.getDataFromExcel("Sheet1", 1, 5);


		HomePage hp= new HomePage(driver);
		hp.getOrganizationsLink().click();
		
		OrganizationsPage op= new OrganizationsPage(driver);
		op.getCreateOrganization().click();
		
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.createOrgWithIndustry(OrganizationName, Industry, Industrytype);
		
		OragnizationInfoPage oip = new OragnizationInfoPage(driver);
		String headerName = oip.getHeadermsg().getText();
		
		
		System.out.println("The Organization has been created"+headerName);
		 
		//verify
		 
			/*
			 * String industrytextbox =
			 * driver.findElement(By.className("dvtCellInfo")).getText();
			 * if(industrytextbox.equals(industrytextbox)) {
			 * System.out.println("Case has been passed"); } else {
			 * System.out.println("Not passed"); }
			 */
		 

		
			  
		}

}
