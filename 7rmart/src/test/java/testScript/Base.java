package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base {

	public WebDriver driver;
	 public FileInputStream fs;
	 public Properties pr;
	 public ScreenshotUtility scrshot;
	 @Parameters("browser")
	 @BeforeMethod(alwaysRun=true)  //for grouping
	 
	   public void initializeBrowser(String browser) throws Exception {  
		 
		 try {
			 pr=new Properties();
			 fs=new FileInputStream(Constants.CONFIGFILE);
			 pr.load(fs); 
		 }
		 catch(Exception e)
		 {
			 System.out.println("Invalid URL");
			 
		 }
		 
		 //driver=new ChromeDriver();
		 if(browser.equalsIgnoreCase("chrome"))   //used for different browsers
		 {
			 driver=new ChromeDriver();
		 }
		 else if(browser.equalsIgnoreCase("edge"))
		 {
			 driver=new EdgeDriver();
		 }
		 else if(browser.equalsIgnoreCase("firefox"))
		 {
			 driver=new FirefoxDriver();
		 }
		 else
		 {
			 throw new Exception("invalid");
		 }
		 //driver.get("https://groceryapp.uniqassosiates.com/admin");
		 driver.get(pr.getProperty("url"));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT)); //from wait Utility
		 driver.manage().window().maximize();
		 
	 }
	 @AfterMethod(alwaysRun=true)
	 
	  public void driverQuitAndClose(ITestResult iTestResult) throws IOException  //for screenshot
	 {
		 if (iTestResult.getStatus() == ITestResult.FAILURE) {  
				scrshot = new ScreenshotUtility();
				scrshot.getScreenShot(driver, iTestResult.getName()); 
			}
		// driver.quit(); //after run screenshot is taken
	 }  
}
