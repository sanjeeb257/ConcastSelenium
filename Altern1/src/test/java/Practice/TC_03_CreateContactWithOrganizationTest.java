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

public class TC_03_CreateContactWithOrganizationTest {
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
String orgName = eLib.getExcelData("Sheet1", 2, 1);
String indName = eLib.getExcelData("Sheet1", 2, 2);


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

driver.findElement(By.partialLinkText("Organizations")).click();
driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
driver.findElement(By.name("accountname")).sendKeys(orgName+jLib.getRandomNum());
WebElement ind = driver.findElement(By.name("industry"));
wLib.select(ind,  indName);
driver.findElement(By.name("button")).click();
}
}

