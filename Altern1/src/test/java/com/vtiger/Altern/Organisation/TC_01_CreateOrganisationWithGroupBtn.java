package com.vtiger.Altern.Organisation;




import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Autodesk.ObjectRepository.CreateOrganisation;
import com.crm.Autodesk.ObjectRepository.HomePage;

import com.crm.Autodesk.ObjectRepository.OrganisationCreatedPage;
import com.crm.Autodesk.ObjectRepository.OrganisationPage;
import com.vtiger.Altern.GenericUtilities.BaseClass;


@Listeners(com.vtiger.Altern.GenericUtilities.Listners.class)
public class TC_01_CreateOrganisationWithGroupBtn  extends BaseClass{
	

@Test//(groups="SmokeSuite",retryAnalyzer=com.vtiger.Altern.GenericUtilities.RetryAnalyzer.class )
	
	public void CreateOrganisationWithGroupBtnTest() throws Throwable{
		
	
	
	String orgName = eLib.getExcelData("sheet1", 1, 1)+jLib.getRandomNum();
	HomePage hp=new HomePage(driver);
	hp.OrganisationClick();
	
	OrganisationPage og = new OrganisationPage(driver);
	og.OrgPage();
	
	CreateOrganisation co = new CreateOrganisation(driver);
	co.CreateOrganisationPagewithGrpBtn(orgName);
	
	String expectedTitle="Organization Information";
	
	OrganisationCreatedPage org = new OrganisationCreatedPage(driver);
	String actualTitle = org.getHeaderText().getText();
	
	Assert.assertTrue(actualTitle.contains(expectedTitle));
	System.out.println("Organisation Information   Updated today");
	Assert.assertTrue(true);
	
	
	driver.close();	
	
}
}
