package com.comcast.crm.multipleorgtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.listernerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OragnizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.generic.webdriverutility.UtilityClassObject;
@Listeners(com.comcast.crm.listernerutility.ListImpClass.class)


public class MultipleOrganizationTest extends BaseClass {
	
	@Test(groups = "smokeTest")
	public void createOrganizationTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");


		// excelutility
		String OrganizationNameFromExcel = eLib.getDataFromExcel("Sheet1", 1, 2) + jLib.getRandomNumber();

		// login page
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org Page");

		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Create a New Org Page");

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrganization().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Create a Org Page");

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(OrganizationNameFromExcel);
		
		UtilityClassObject.getTest().log(Status.INFO, OrganizationNameFromExcel+"===>>create a new org");
		OragnizationInfoPage oip = new OragnizationInfoPage(driver);
		String headerName = oip.getHeadermsg().getText();
		
		Assert.assertTrue(headerName.contains(OrganizationNameFromExcel));
		
		Assert.assertEquals(OrganizationNameFromExcel, OrganizationNameFromExcel);
		

		

	}

	@Test(groups = "regressionTest")
	public void createOrganizationWithIndustriesTest() throws Throwable {

		// excelutility
		//String lastName = eLib.getDataFromExcel("Sheet1", 1, 7) + jLib.getRandomNumber();
		String OrganizationName = eLib.getDataFromExcel("Sheet1", 1, 2) + jLib.getRandomNumber();
		String Industry = eLib.getDataFromExcel("Sheet1", 1, 4);
		String Industrytype = eLib.getDataFromExcel("Sheet1", 1, 5);

		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrganization().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrgWithIndustry(OrganizationName, Industry, Industrytype);
       Thread.sleep(2000);
	}

	@Test(groups = "regressionTest")
	public void deleteOraganizationTest() throws Throwable {

		// excelutility
		String OrganizationNameFromExcel = eLib.getDataFromExcel("Sheet1", 10, 2) + jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrganization().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(OrganizationNameFromExcel);

		OragnizationInfoPage oip = new OragnizationInfoPage(driver);
		String headerName = oip.getHeadermsg().getText();

		if (headerName.contains(OrganizationNameFromExcel)) {
			System.out.println("Org Nameis Created");
		} else {
			System.out.println("Org Name is not Created");
		}
		// verify actual organization name is equals to organization name
		String actualOrganizationName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		if (actualOrganizationName.equals(actualOrganizationName)) {
			System.out.println("Org Name is Created");
		} else {
			System.out.println("Org Name is not Created");
		}

		// go back to organizations page

		hp.getOrganizationsLink().click();

		// search for organization
		op.getSearchEdt().sendKeys(OrganizationNameFromExcel);
		wLib.selectbyvisibletext(op.getSearchDD(), "Organization Name");
		op.getSerachbtn().click();

		// In dynamic webtable select & delete Organization
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//a[text()='" + OrganizationNameFromExcel + "'])[2]/../..//a[text()='del']"))
				.click();
		wLib.switchToalertAndAccept(driver);
	}
}
