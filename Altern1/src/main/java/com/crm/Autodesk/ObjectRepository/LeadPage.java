package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.Altern.GenericUtilities.WebDriverUtility;

public class LeadPage extends WebDriverUtility{
	public LeadPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this );
	}

	@FindBy(partialLinkText = "Leads")
	private WebElement Leadbtn;

	public WebElement getLeadbtn() {
		return Leadbtn;
	}
	
	public void Leadbtnclik()
	{
		Leadbtn.click();
	}
	
}
