package com.vtiger.Altern.Organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Autodesk.ObjectRepository.CreateOrganisation;
import com.crm.Autodesk.ObjectRepository.HomePage;


import com.crm.Autodesk.ObjectRepository.OrganisationPage;
import com.vtiger.Altern.GenericUtilities.BaseClass;


public class TC_03_Rating_Drop_Down_Option_Is_Working_Or_Not extends BaseClass {

	
	@Test(groups="RegressionSuite")
		
		public void Rating_Drop_Down_Option_Is_Working_Or_NotTest() throws Throwable{
			
		
		
		
		String orgName = eLib.getExcelData("sheet1", 1, 1)+jLib.getRandomNum();
		
		HomePage hp=new HomePage(driver);
		hp.OrganisationClick();
		
		OrganisationPage og = new OrganisationPage(driver);
		og.OrgPage();
		
		CreateOrganisation co = new CreateOrganisation(driver);
		co.CreateOrganisationPagewithRatingDrpDn(orgName);
		String ExpectedTitle="Market Failed";
		for(WebElement ele:co.opt)
		{
			String actualTitle = ele.getText();
			if(actualTitle.contains("Market Failed"))
			{
			Assert.assertTrue(actualTitle.equals(ExpectedTitle));
			System.out.println("Drop down table appeard");
			}
			break;
		}
		System.out.println("Drop down table appeard");
		
		
		
	
		
	}
}