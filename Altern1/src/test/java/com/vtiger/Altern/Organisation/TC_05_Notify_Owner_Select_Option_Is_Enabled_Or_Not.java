package com.vtiger.Altern.Organisation;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Autodesk.ObjectRepository.CreateOrganisation;
import com.crm.Autodesk.ObjectRepository.HomePage;

import com.crm.Autodesk.ObjectRepository.OrganisationPage;
import com.vtiger.Altern.GenericUtilities.BaseClass;

public class TC_05_Notify_Owner_Select_Option_Is_Enabled_Or_Not extends BaseClass {

	
	@Test(groups="RegressionSuite")
		
		public void TC_05_Notify_Owner_Select_Option_Is_Enabled_Or_NotTest() throws Throwable{
			
		
		
		String orgName = eLib.getExcelData("sheet1", 1, 1)+jLib.getRandomNum();
		
		
		
		
		HomePage hp=new HomePage(driver);
		hp.OrganisationClick();
		
		OrganisationPage og = new OrganisationPage(driver);
		og.OrgPage();
		
		CreateOrganisation co = new CreateOrganisation(driver);
		co.CreateOrganisationPagewthNotifyOwnerbtn(orgName);
		
		Assert.assertTrue(co.getNotifyOwnerbtn().isEnabled());
		System.out.println("notify owner button is enabled");
		
}
}
