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

public class TC_05_CreateLead {
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
//create lead
driver.findElement(By.partialLinkText("Leads")).click();
driver.findElement(By.xpath("//img[@alt=\"Create Lead...\"]")).click();
WebElement namedropdown = driver.findElement(By.name("salutationtype"));
wLib.select(namedropdown, "Mr.");
driver.findElement(By.name("firstname")).sendKeys("Sanjeeb");
driver.findElement(By.name("lastname")).sendKeys("Pati");
driver.findElement(By.name("company")).sendKeys("CaddHawk");
driver.findElement(By.id("designation")).sendKeys("Engineering");
WebElement leadsource = driver.findElement(By.name("leadsource"));
wLib.select(leadsource, "Partner");
WebElement industry = driver.findElement(By.name("industry"));
wLib.select(industry, "Banking");
driver.findElement(By.name("annualrevenue")).sendKeys("500000");
driver.findElement(By.id("noofemployees")).sendKeys("30");
driver.findElement(By.name("secondaryemail")).sendKeys("sanjeeb.pati96@gmail.com");
driver.findElement(By.id("phone")).sendKeys("8249445503");
driver.findElement(By.id("mobile")).sendKeys("9938620060");
driver.findElement(By.id("fax")).sendKeys("sanjeeb");
driver.findElement(By.id("email")).sendKeys("sanjeebpatithecoolboy@gmail.com");
driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.caddhawk.com");
WebElement leadstatus = driver.findElement(By.name("leadstatus"));
wLib.select(leadstatus, "Cold");
WebElement rating = driver.findElement(By.name("rating"));
wLib.select(rating, "Active");
driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
WebElement Group = driver.findElement(By.name("assigned_group_id"));
wLib.select(Group, "Support Group");
driver.findElement(By.name("lane")).sendKeys("at/po-dolasahi");
driver.findElement(By.name("code")).sendKeys("23547");
driver.findElement(By.name("country")).sendKeys("India");
driver.findElement(By.name("pobox")).sendKeys("dolasahi");
driver.findElement(By.id("city")).sendKeys("bhubaneswar");
driver.findElement(By.id("state")).sendKeys("odisha");
driver.findElement(By.xpath("(//textarea[@class='detailedViewTextBox'])[2]")).sendKeys("Services:Engineering,drafting,Software development,");
driver.findElement(By.name("button")).click();
//edit lead

driver.findElement(By.name("Edit")).click();
driver.findElement(By.name("company")).clear();
driver.findElement(By.name("company")).sendKeys("CaddHouse");
driver.findElement(By.xpath("//input[@name='assigntype']")).click();
WebElement user = driver.findElement(By.xpath("(//select[@class='small'])[7]"));
wLib.select(user, "Administrator");
driver.findElement(By.name("button")).click();

//fetch the lead no

String expectedResult = driver.findElement(By.xpath("//td[contains(text(),'LE')]")).getText();
driver.findElement(By.partialLinkText("Leads")).click();
List<WebElement> map = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]"));
for(WebElement e:map)
{
	String Actual = e.getText();
	if(expectedResult.contains(Actual))
	{
		System.out.println("lead created Sucessfully");
	}
}
}
}
