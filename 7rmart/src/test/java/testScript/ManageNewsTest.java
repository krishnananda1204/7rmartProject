package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base{
 
	ManageNewsPage managenewspage;
	HomePage homepage;
	@Test(description="Verifying whether user can Add new News in Manage News section")
	public void verifyUserCanAddNewNewsSuccessfullyInManageNewsPage() throws IOException
	{
		 
	      String username=ExcelUtilities.getStringData(1, 0, "loginpage"); 
	      String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		  LoginPage loginpage=new LoginPage(driver);	
		  loginpage.enterUsename(username).enterPassword(password);
		  //loginpage.enterPassword(password);
		  homepage=loginpage.clickSignInButton();
		
		  String news=ExcelUtilities.getStringData(1, 0, "managenewspage");
		  //ManageNewsPage managenewspage=new ManageNewsPage(driver);
		  //managenewspage.clickManageNewsMoreInfo();
		  managenewspage=homepage.clickManageNewsMoreInfo();
		  managenewspage.clickNewButton().enterNews(news).clickSaveButton();
		  //managenewspage.enterNews(news);
		  //managenewspage.clickSaveButton();
		  boolean isManageNewsPageAvailable=managenewspage.isAlertDisplayed();  
		  Assert.assertTrue(isManageNewsPageAvailable,Constants.ADD_NEWS); 
		
	}
}
