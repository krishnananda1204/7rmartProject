package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base{
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidCreadentials() throws IOException
	{
	  // String username="admin"; //credentials
	  // String password="admin"; //credentials
	  String username=ExcelUtilities.getStringData(1, 0, "loginpage"); //first two parameter is the position of datas in excel and last parameter is the sheet name
	  String password=ExcelUtilities.getStringData(1, 1, "loginpage");
	  LoginPage loginpage=new LoginPage(driver);	//object create
	  loginpage.enterUsename(username);
	  loginpage.enterPassword(password);
	  loginpage.clickSignInButton();
	  boolean isHomePageAvailable=loginpage.isDashboardDisplayed();
	  Assert.assertTrue(isHomePageAvailable);
	  
	}
   
@Test
   public void verifyTheUserIsUnableToLoginWithInCorrectUsernameAndCorrectPassword() throws IOException
   {
	   String username=ExcelUtilities.getStringData(2, 0, "loginpage"); 
		String password=ExcelUtilities.getStringData(2, 1, "loginpage");
		 LoginPage loginpage=new LoginPage(driver);	
		  loginpage.enterUsename(username);
		  loginpage.enterPassword(password);
		  loginpage.clickSignInButton();
		  boolean isHomePageNotAvailable=loginpage.isRedAlertDisplayed();
		  Assert.assertTrue(isHomePageNotAvailable);
   }
  @Test
    public void verifyTheUserIsUnableToLoginWithCorrectUsernameAndInCorrectPassword() throws IOException
      {
	   String username=ExcelUtilities.getStringData(3, 0, "loginpage"); 
		String password=ExcelUtilities.getStringData(3, 1, "loginpage");
		 LoginPage loginpage=new LoginPage(driver);	
		  loginpage.enterUsename(username);
		  loginpage.enterPassword(password);
		  loginpage.clickSignInButton();
		  boolean isHomePageNotAvailable=loginpage.isRedAlertDisplayed();
		  Assert.assertTrue(isHomePageNotAvailable);
     }
   

   @Test
    public void verifyTheUserIsUnableToLoginWithInCorrectUsernameAndInCorrectPassword() throws IOException
     {
	   String username=ExcelUtilities.getStringData(4, 0, "loginpage"); 
		String password=ExcelUtilities.getStringData(4, 1, "loginpage");
		 LoginPage loginpage=new LoginPage(driver);	
		  loginpage.enterUsename(username);
		  loginpage.enterPassword(password);
		  loginpage.clickSignInButton();
		  boolean isHomePageNotAvailable=loginpage.isRedAlertDisplayed();
		  Assert.assertTrue(isHomePageNotAvailable);
    }
 
	
}
