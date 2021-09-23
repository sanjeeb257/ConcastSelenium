package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.Altern.GenericUtilities.JSONFileUtility;

public class OrganisationTable {
	@Test
	public void organisationTable() throws Throwable
	{
	JSONFileUtility j =new JSONFileUtility();
	String browser = j.readData("browser");
	String url = j.readData("url");
	String username = j.readData("username");
	String password = j.readData("password");
WebDriver driver=null;
if(browser.equals("chrome"))
{
	driver=new ChromeDriver();
}
else if (browser.equals("firefox"))
{
	driver=new FirefoxDriver();
}
else
	System.out.println("invalid browser");
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.partialLinkText("Leads")).click();
	
	//for unselect the last one

	/*List<WebElement> f = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
for(WebElement wb:f) {
	wb.click();
}
f.get(f.size()-1).click();*/

	//select one particular
	/*for (int i=1;i<f.size();i++)
 {
	 if(i==1)
		 f.get(i).click();
	 
 }*/
	
	//print all
	
	/*List<WebElement> f = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Leads']"));
	for(WebElement wb:f)
	{
		String s = wb.getText();
		System.out.println(s);
		
	}*/
	//to delete 
	
	List<WebElement> f = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
	for (int i=1;i<f.size();i++)
	 {
		 if(i==1)
			 f.get(i).click();
		 
	 }
	
	List<WebElement> f1 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[10]/a[text()='del']"));
	for (int i=1;i<f.size();i++)
	 {
		 if(i==1)
		 {
			 f1.get(i).click();
		 driver.switchTo().alert().accept();
		 }
	 }
Thread.sleep(5000);
	driver.close();
	
}
}
