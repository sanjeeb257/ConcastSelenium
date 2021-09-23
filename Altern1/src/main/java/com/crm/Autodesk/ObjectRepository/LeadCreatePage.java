package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.Altern.GenericUtilities.WebDriverUtility;

public class LeadCreatePage extends WebDriverUtility {
	
public LeadCreatePage (WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

@FindBy (xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement createLeadbtn;

public WebElement getCreateLeadbtn() {
	return createLeadbtn;
}

public void setCreateLeadbtn(WebElement createLeadbtn) {
	this.createLeadbtn = createLeadbtn;
}




}
