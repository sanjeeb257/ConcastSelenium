package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lenskart {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lenskart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		driver.findElement(By.name("q")).click();
		List<WebElement> p = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']"));
		
		for (WebElement ele:p)
		{
			System.out.println(ele.getText());
		}
		driver.close();
		

	}

}
