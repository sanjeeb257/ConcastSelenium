package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.Altern.GenericUtilities.ExcelFileUtility;
import com.vtiger.Altern.GenericUtilities.JSONFileUtility;
import com.vtiger.Altern.GenericUtilities.JavaUtility;
import com.vtiger.Altern.GenericUtilities.WebDriverUtility;

public class TC_01_CreateContactWithOrganizationTest {
	WebDriver driver;
		@Test
	
	public void createContactWthOrgTest() throws Throwable{
		
	
	
	JSONFileUtility jsLib=new JSONFileUtility();
	JavaUtility jLib =new JavaUtility();
	WebDriverUtility wLib= new WebDriverUtility();
	ExcelFileUtility eLib = new ExcelFileUtility();
	
	String BROWSER = jsLib.readData("browser");
	String URL = jsLib.readData("url");
	String USERNAME = jsLib.readData("username");
	String PASSWORD = jsLib.readData("password");
	
	String contactName = eLib.getExcelData("Sheet1", 1, 1);
	String orgName = eLib.getExcelData("Sheet1", 1, 1);
	
	
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
	
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	driver.findElement(By.name("lastname")).sendKeys(contactName);
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	
	wLib.switchToWindow(driver, "action");
	
	driver.findElement(By.id("search_txt")).sendKeys(orgName);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.linkText("CaddHouse")).click();
	
	wLib.switchToWindow(driver, "action");
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wLib.mouseHover(driver, ele);
	driver.findElement(By.linkText("Sign Out")).click();

	
	driver.close();
}
}
