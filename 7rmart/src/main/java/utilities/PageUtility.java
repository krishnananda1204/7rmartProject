package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void selectByVisibleText(WebElement element, String visibleText) 
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void selectByIndex(WebElement element, int index) 
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByValue(WebElement element, String value) 
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	
	
	public void rightClick(WebElement element, WebDriver driver) 
	{
		Actions actions=new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	
	public void doubleClick(WebElement element, WebDriver driver) 
	{
		Actions actions=new Actions(driver);
		actions.doubleClick(element).build().perform();
	}
	
	public void mouseHover(WebElement element, WebDriver driver) 
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	public void dragAndDrop(WebElement drag,WebElement drop, WebDriver driver) 
	{
		Actions actions=new Actions(driver);
		actions.dragAndDrop(drag, drop).build().perform();
	}
	public void click(WebElement element,WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.click(element).build().perform();
	}
	
	
	public void scrollByUsingJavascriptExecutor(WebDriver driver, int x, int y)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)", "");
	}
	
	public void sentKeysByUsingJavascriptExecutor(WebDriver driver, WebElement element,String value)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='value';",element);
	}
	
	public void clickByUsingJavascriptExecutor(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
}
