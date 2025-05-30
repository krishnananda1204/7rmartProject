package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base{
 
	@Test
	public void manageNewsTest() throws IOException
	{
		 
	      String username=ExcelUtilities.getStringData(1, 0, "loginpage"); 
	      String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		  LoginPage loginpage=new LoginPage(driver);	
		  loginpage.enterUsename(username);
		  loginpage.enterPassword(password);
		  loginpage.clickSignInButton();
		
		  String news=ExcelUtilities.getStringData(1, 0, "managenewspage");
		  ManageNewsPage managenewspage=new ManageNewsPage(driver);
		  managenewspage.clickManageNewsMoreInfo();
		  managenewspage.clickNewButton();
		  managenewspage.enterNews(news);
		  managenewspage.clickSaveButton();
		  boolean isNewsPageAvailable=managenewspage.isAlertDisplayed();  
		  Assert.assertTrue(isNewsPageAvailable); 
		
	}
}
