package com.vtiger.Altern.Organisation;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Autodesk.ObjectRepository.CreateOrganisation;
import com.crm.Autodesk.ObjectRepository.HomePage;

import com.crm.Autodesk.ObjectRepository.OrganisationCreatedPage;
import com.crm.Autodesk.ObjectRepository.OrganisationPage;
import com.vtiger.Altern.GenericUtilities.BaseClass;

public class TC_04_CreateOrganisationWithNotifyOwner extends BaseClass {

	
	@Test(groups="SmokeSuite")
		
		public void CreateOrganisationWithNotifyOwnerTest() throws Throwable{
			
		String orgName = eLib.getExcelData("sheet1", 1, 1)+jLib.getRandomNum();
        HomePage hp=new HomePage(driver);
		hp.OrganisationClick();
		
		OrganisationPage og = new OrganisationPage(driver);
		og.OrgPage();
		
		CreateOrganisation co = new CreateOrganisation(driver);
		co.CreateOrganisationPagewithNotifyOwnerbtn(orgName);
		
		String expectedTitle="Organization Information";
		OrganisationCreatedPage org = new OrganisationCreatedPage(driver);
		String actualTitle = org.getHeaderText().getText();
		Assert.assertTrue(actualTitle.contains(expectedTitle));
		System.out.println("Organisation Information   Updated today");
		
		
		
}
}