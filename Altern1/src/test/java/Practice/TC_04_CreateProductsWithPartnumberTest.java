package Practice;

import java.util.List;

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

public class TC_04_CreateProductsWithPartnumberTest {
	WebDriver driver;
	@Test

public void createProductsWithPartnumberTest() throws Throwable{
	


JSONFileUtility jsLib=new JSONFileUtility();
JavaUtility jLib =new JavaUtility();
WebDriverUtility wLib= new WebDriverUtility();
ExcelFileUtility eLib = new ExcelFileUtility();

String BROWSER = jsLib.readData("browser");
String URL = jsLib.readData("url");
String USERNAME = jsLib.readData("username");
String PASSWORD = jsLib.readData("password");


String proName = eLib.getExcelData("Sheet1", 1, 3);
String partNumber = eLib.getExcelData("Sheet1", 1, 4)+jLib.getRandomNum();

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

driver.findElement(By.partialLinkText("Products")).click();
driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
driver.findElement(By.name("productname")).sendKeys(proName);
driver.findElement(By.name("productcode")).sendKeys(partNumber);
driver.findElement(By.xpath("//input[@type='submit']")).click();

driver.findElement(By.partialLinkText("Products")).click();
Thread.sleep(5000);

String expectedResult = driver.findElement(By.xpath("//td[contains(text(),'PR')]")).getText();

WebElement partnum = driver.findElement(By.id("bas_searchfield"));

wLib.select(partnum, "Part Number");
Thread.sleep(5000);
driver.findElement(By.name("search_text")).sendKeys(partNumber);
driver.findElement(By.name("submit")).click();

List<WebElement> chkbox = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]"));



for(WebElement e:chkbox)
{
String actualResult=e.getText();
System.out.println(actualResult);
if(expectedResult.contains(actualResult))
{
	System.out.println("true");
}
	

}
Thread.sleep(4000);
WebElement ele2 = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));

wLib.mouseHover(driver, ele2);
Thread.sleep(3000);
driver.findElement(By.linkText("Sign Out")).click();
driver.close();
}
}
