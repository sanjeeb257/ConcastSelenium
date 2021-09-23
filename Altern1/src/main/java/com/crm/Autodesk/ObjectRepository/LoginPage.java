package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//rule 1 : Create a separate POM class for every web Page.
	
	//Rule 4: Provide a single argumented constructor for each driver is the argument and use it pagefactory class for intialize the element at the time of object creation.
	
	public LoginPage (WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}

	//rule 2: Go to all Web Pages and identify the elements useing @findBy, @findBys and @findAll
	
	@FindBy (name="user_name")
	private WebElement userNameEdt;
	
	@FindBy (name="user_password")
    private WebElement passWordEdt;
	
	@FindBy (id="submitButton")
	private WebElement loginBtn;

	//Rule 3: Declare All WebElements As private and provide getters and setters method to access them in a script. 
	
	
	public WebElement getUserName() {
		return userNameEdt;
	}

	public WebElement getPassWord() {
		return passWordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Rule 5: Use these elements with the help of getter/Bussiness Methods.
	
	public void Login (String userName, String passWord)
	{
		userNameEdt.sendKeys(userName);
		passWordEdt.sendKeys(passWord);
		loginBtn.click();
	}
	
	
	
	
}
