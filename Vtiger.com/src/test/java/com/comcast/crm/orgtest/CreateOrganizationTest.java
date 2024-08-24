package com.comcast.crm.orgtest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OragnizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(com.comcast.crm.listernerutility.ListImpClass.class)

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrganizationTest() throws Throwable {

		// excelutility
		String OrganizationNameFromExcel = eLib.getDataFromExcel("Sheet1", 1, 2) + jLib.getRandomNumber();

		// login page
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrganization().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(OrganizationNameFromExcel);

		OragnizationInfoPage oip = new OragnizationInfoPage(driver);
		String headerName = oip.getHeadermsg().getText();
		
		
		System.out.println("The Organization has been created"+headerName);

		/*
		 * if (headerName.contains(OrganizationNameFromExcel)) {
		 * System.out.println("Org Nameis Created"); } else {
		 * System.out.println("Org Name is not Created"); } // verify actual
		 * organization name is equals to organization name String
		 * actualOrganizationName =
		 * driver.findElement(By.id("dtlview_Organization Name")).getText();
		 * 
		 * if (actualOrganizationName.equals(actualOrganizationName)) {
		 * System.out.println("Org Name is Created"); } else {
		 * System.out.println("Org Name is not Created"); }
		 */

			}
}
