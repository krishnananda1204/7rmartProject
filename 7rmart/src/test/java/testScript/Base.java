package testScript;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.WaitUtility;

public class Base {

	public WebDriver driver;
	 public FileInputStream fs;
	 public Properties pr;
	 @Parameters("browser")
	 @BeforeMethod(alwaysRun=true)
	 
	 /* public void initializeBrowser(String browser) throws Exception    
	 {
		 try {
			 pr=new Properties();
			 fs=new FileInputStream(Constants.CONFIGFILE);
			 pr.load(fs); 
		 }
		 catch(Exception e)
		 {
			 System.out.println("Invalid");
			 
		 }
		 //driver=new ChromeDriver();
		if(browser.equalsIgnoreCase("chrome"))
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
		 */
	   public void initializeBrowser() {
		 driver=new ChromeDriver();
		 driver.get("https://groceryapp.uniqassosiates.com/admin");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT)); //from wait Utility
		 driver.manage().window().maximize();
		 
	 }
	 @AfterMethod(alwaysRun=true)
	 public void driverQuitAndClose()
	 {
		 //driver.quit();
	 }
	 
	 /* public void driverQuitAndClose(ITestResult iTestResult) throws IOException
	 {
		 if (iTestResult.getStatus() == ITestResult.FAILURE) {  //fetch console and take result.when the status failure then only body execute
				scrshot = new ScreenshotUtility();
				scrshot.getScreenShot(driver, iTestResult.getName()); //getScreenShot method is instance method so create the object for particular class
			}
		// driver.quit(); //after run screenshot is taken
	 }  */
}
