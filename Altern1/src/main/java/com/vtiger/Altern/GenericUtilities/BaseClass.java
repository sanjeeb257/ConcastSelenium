package com.vtiger.Altern.GenericUtilities;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.LoginPage;

public class BaseClass {

    
	public JSONFileUtility jsLib=new JSONFileUtility();
	public JavaUtility jLib =new JavaUtility();
	public	WebDriverUtility wLib= new WebDriverUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public WebDriver driver;
	public static WebDriver staticdriver;
	
@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
public void connectDB()
{
	System.out.println("making Database Connection");
}
//@Parameters("browser")
@BeforeClass(groups={"SmokeSuite","RegressionSuite"})
public void LaunchBrowser() throws Throwable
{
	System.out.println("---Launching the Browser---");
	String BROWSER = jsLib.readData("browser");
	String URL = jsLib.readData("url");
	
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
		
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("invalid browser");
	}
	
	
	wLib.waitForPageLoad(driver);
	wLib.maximize(driver);
	driver.get(URL);
	staticdriver=driver;
}



@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})
public void Loginapp() throws Throwable
{
    String USERNAME=jsLib.readData("username");
    String PASSWORD=jsLib.readData("password");
	LoginPage lp=new LoginPage(driver);
	lp.Login(USERNAME, PASSWORD);
}

@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
public void LogoutApp()
{
	HomePage hp=new HomePage(driver);
	hp.signOut(driver);
}

@AfterClass(groups={"SmokeSuite","RegressionSuite"})
public void CloseBrowser()
{
	System.out.println("-----closed-----");
	driver.close();
}
@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
public void CloseDB()

{
	System.out.println("closed");
}

public String getscreenshot(String name) throws Throwable
{
File srcfile=((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
String destfile = System.getProperty("user.dir")+ "/Screenshots/"+name+".png";
File finaldest= new File(destfile);
FileUtils.copyFile(srcfile,finaldest);
	return destfile;
	
}
	
}
