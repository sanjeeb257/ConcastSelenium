package com.crm.Autodesk.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.Altern.GenericUtilities.WebDriverUtility;


public class CreateOrganisation extends WebDriverUtility {


	public CreateOrganisation(WebDriver driver)
	{
	PageFactory.initElements( driver,this);
	}
	
	// Go to all Web Pages and identify the elements useing @findBy, @findBys and @findAll
	
	@FindBy(name="accountname")
	private WebElement organisationNameEdt;
	
	
	@FindBy (xpath="//select[@name='assigned_group_id']")
	private WebElement assignToDrpDn;
	
	@FindBy(xpath="(//input[@onclick='toggleAssignType(this.value)'])[2]")
	private WebElement grpBtn;
	
	@FindBy(name="rating")
	private WebElement ratingDrpDn;
	
	@FindBy(name="notify_owner")
	private WebElement notifyOwnerbtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement admistratorbtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Clock.gif']")
	private WebElement worldclockbtn;
	
	public WebElement getWorldclockbtn() {
		return worldclockbtn;
	}


	public WebElement getAdmistratorbtn() {
		return admistratorbtn;
	}

	@FindBy(partialLinkText = "Sign Out")
	private WebElement signOutBtn;
	
	//Declare All WebElements As private and provide getters and setters method to access them in a script.

	public WebElement getAccountNameBtn() {
		return organisationNameEdt;
	}


	public WebElement getAssignToDrpDn() {
		return assignToDrpDn;
	}

	public WebElement getGrpBtn() {
		return grpBtn;
	}

	public WebElement getRatingDrpDn() {
		return ratingDrpDn;
	}

	public WebElement getNotifyOwnerbtn() {
		return notifyOwnerbtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrganisationNameEdt() {
		return organisationNameEdt;
	}


	public WebElement getSignOutBtn() {
		return signOutBtn;
	}


	public List<WebElement> getOpt() {
		return opt;
	}
	
	//Rule 5: Use these elements with the help of getter/Bussiness Methods.
	
	public void CreateOrganisationPagewithGrpBtn (String organisationName )
	{
		organisationNameEdt.sendKeys(organisationName);
		grpBtn.click();
		select(getAssignToDrpDn(),"Marketing Group");
		saveBtn.click();
	}
	
	public List<WebElement> opt;
	public void CreateOrganisationPagewithRatingDrpDn(String organisationName)
	{
		organisationNameEdt.sendKeys(organisationName);
	 opt = getOption(getRatingDrpDn());
	 
		
		
		
	}
	
	public void CreateOrganisationPagewithRatingDpDn(String organisationName)
	{
		organisationNameEdt.sendKeys(organisationName);
		select(getRatingDrpDn(),"Active");
		saveBtn.click();
	}
	
	public void CreateOrganisationPagewithNotifyOwnerbtn(String organisationName)
	{
		organisationNameEdt.sendKeys(organisationName);
		notifyOwnerbtn.click();
		saveBtn.click();
	}
	
	public void CreateOrganisationPagewthNotifyOwnerbtn(String organisationName)
	{
		organisationNameEdt.sendKeys(organisationName);
		notifyOwnerbtn.click();
	
		
	}
	
	public void signOut(WebDriver driver)
	{
		mouseHover(driver, getAdmistratorbtn());
		signOutBtn.click();
	}

	public void mouseoverOnWorldClock(WebDriver driver)
	{
		System.out.println(worldclockbtn.getAttribute("title"));
		
	}

	
}

