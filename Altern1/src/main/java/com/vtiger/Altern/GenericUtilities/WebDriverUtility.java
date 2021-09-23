package com.vtiger.Altern.GenericUtilities;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * Here we are waiting implicitly  for the element to be displayed
	 */
	public void waitForPageLoad (WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * Here we are explicitly waiting the text to be visible
	 */
public void waitForElementToBeVisible(WebDriver driver, WebElement element)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOf(element));
	
}
/**
 * Here we are maximize the window
 */
public void maximize(WebDriver driver)
{
	driver.manage().window().maximize();
}
/**
 * here we handle the dropdown with index
 * @param element
 * @param index
 */
public void select(WebElement element, int index)
{
	Select sel = new Select(element);
	sel.selectByIndex(index);
}
/**
 * here we handle dropdown by visible text
 */
public void select(WebElement element, String index)
{
	Select sel = new Select(element);
	sel.selectByVisibleText(index);
}
/**
 * getoptions of dropdown
 * @param driver
 * @return 
 */
public List<WebElement> getOption(WebElement element)
{
	Select sel = new Select(element);
	List<WebElement> option = sel.getOptions();
	return option;
}

/**
 * MouseHover
 */
public void mouseHover(WebDriver driver, WebElement element)
{
	Actions act= new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * Right Click
 */
public void contextClick(WebDriver driver,WebElement element) {
	Actions act= new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * DoubleClick
 */
public void doubleClick(WebDriver driver, WebElement element)
{
	Actions act= new Actions(driver);
	act.doubleClick(element).perform();
	
}

/**
 * draganddrop
 */
public void draganddrop(WebDriver driver , WebElement element)
{
	Actions act= new Actions(driver);
	act.dragAndDrop(element, element).perform();
	
}
/**
 * Accept Alert popups
 */

public void acceptAlertPopUps(WebDriver driver)
{
	driver.switchTo().alert().accept();
	
}

/**
 * Dismiss alert popoups
 */
public void dismissAlertPopups(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * Switch to frame by Frameid
 */
public void switchtoFrame(WebDriver driver,int index)
{
	
	driver.switchTo().frame(index);
}
/**
 * Switch to frame by Frame name
 */
public void SwitchtoFrame(WebDriver driver, String name)
{
	driver.switchTo().frame(name);
}
/**
 * Swich to frame by Frame by useing element 
 * 
 */
public void switchtoFrame (WebDriver driver, String frameElement)
{
	driver.switchTo().frame(frameElement);
}
/**
 * switch to element useing partial window title
 */
public void switchToWindow (WebDriver driver ,WebElement frameElement)
{
	Set<String> windowhandles = driver.getWindowHandles();
	Iterator<String> iterator = windowhandles.iterator();
	while (iterator.hasNext())
	{
		driver.switchTo().frame(frameElement);
	}
}
/**
 * switch to element useing partial window title
 */
public void switchToWindow (WebDriver driver ,String partialWinTitle)
{

	Set<String> windowhandles = driver.getWindowHandles();
	Iterator<String> iterator = windowhandles.iterator();
	while (iterator.hasNext())
	{
		String winID = iterator.next();
		String actTitle=driver.switchTo().window(winID).getTitle();
		
		if(actTitle.contains(partialWinTitle))
		{
			driver.switchTo().window(actTitle);
		}
	}
	
}

}
