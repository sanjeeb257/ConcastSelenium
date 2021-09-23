package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.Altern.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "Organizations")
	private WebElement OrganisationBtn;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement admistratorbtn;

	@FindBy(partialLinkText = "Sign Out")
	private WebElement signOutBtn;
	
	public WebElement getOrganisationBtn() {
		return OrganisationBtn;
	}

	public WebElement getAdmistratorbtn() {
		return admistratorbtn;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}

	public void OrganisationClick ()
	{
		OrganisationBtn.click();
	}

	
	public void signOut(WebDriver driver)
	{
		mouseHover(driver, getAdmistratorbtn());
		signOutBtn.click();
	}
}
