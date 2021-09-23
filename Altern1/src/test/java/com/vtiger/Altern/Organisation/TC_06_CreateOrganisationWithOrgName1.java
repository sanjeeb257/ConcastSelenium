package com.vtiger.Altern.Organisation;

import org.testng.annotations.Test;

import com.crm.Autodesk.ObjectRepository.CreateOrganisation;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.OrganisationPage;
import com.vtiger.Altern.GenericUtilities.BaseClass;

public class TC_06_CreateOrganisationWithOrgName1 extends BaseClass {
	@Test
	
	public void CreateOrganisationWithRatingDrpDnTest() throws Throwable{
		
	

	
    HomePage hp = new HomePage(driver);
	hp.OrganisationClick();
	
	OrganisationPage og = new OrganisationPage(driver);
	og.OrgPage();
	
	CreateOrganisation co=new CreateOrganisation(driver);
	co.mouseoverOnWorldClock(driver);
	
}
}
