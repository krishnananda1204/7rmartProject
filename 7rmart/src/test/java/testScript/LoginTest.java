package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base{
	HomePage homepage;
	@Test(groups={"regression"},description="Verifying User is able to login with Valid Credentials")   //for grouping
	public void verifyTheUserIsAbleToLoginUsingValidCreadentials() throws IOException
	{
	  // String username="admin"; //credentials
	  // String password="admin"; //credentials
	  String username=ExcelUtilities.getStringData(1, 0, "loginpage"); //first two parameter is the position of datas in excel and last parameter is the sheet name
	  String password=ExcelUtilities.getStringData(1, 1, "loginpage");
	  LoginPage loginpage=new LoginPage(driver);	//object create
	  loginpage.enterUsename(username).enterPassword(password);
	  //loginpage.enterPassword(password);
	  homepage=loginpage.clickSignInButton();
	  boolean isHomePageAvailable=loginpage.isDashboardDisplayed();
	  Assert.assertTrue(isHomePageAvailable,Constants.LOGIN_VALID_CREDENTIALS);
	  
	}
   
@Test(description="Verifying User is unable to login with Invalid username and Valid password")
   public void verifyTheUserIsUnableToLoginWithInvalidUsernameAndValidPassword() throws IOException
   {
	   String username=ExcelUtilities.getStringData(2, 0, "loginpage"); 
		String password=ExcelUtilities.getStringData(2, 1, "loginpage");
		 LoginPage loginpage=new LoginPage(driver);	
		  loginpage.enterUsename(username).enterPassword(password);
		  //loginpage.enterPassword(password);
		  homepage=loginpage.clickSignInButton();
		  boolean isHomePageNotAvailable=loginpage.isRedAlertDisplayed();
		  Assert.assertTrue(isHomePageNotAvailable,Constants.LOGIN_INVALID_USERNAME);
   }
  @Test(description="Verifying User is unable to login with Valid username and Invalid password")
    public void verifyTheUserIsUnableToLoginWithValidUsernameAndInvalidPassword() throws IOException
      {
	   String username=ExcelUtilities.getStringData(3, 0, "loginpage"); 
		String password=ExcelUtilities.getStringData(3, 1, "loginpage");
		 LoginPage loginpage=new LoginPage(driver);	
		  loginpage.enterUsename(username).enterPassword(password);
		  //loginpage.enterPassword(password);
		  homepage=loginpage.clickSignInButton();
		  boolean isHomePageNotAvailable=loginpage.isRedAlertDisplayed();
		  Assert.assertTrue(isHomePageNotAvailable,Constants.LOGIN_INVALID_PASSWORD);
     }
   

   @Test(dataProvider ="LoginProvider",description="Verifying User is unable to login with Invalid username and Invalid password")
    public void verifyTheUserIsUnableToLoginWithInvalidUsernameAndInvalidPassword(String username,String password) throws IOException
     {
	   //String username=ExcelUtilities.getStringData(4, 0, "loginpage"); 
		//String password=ExcelUtilities.getStringData(4, 1, "loginpage");
		 LoginPage loginpage=new LoginPage(driver);	
		  loginpage.enterUsename(username).enterPassword(password);
		  //loginpage.enterPassword(password);
		  homepage=loginpage.clickSignInButton();
		  boolean isHomePageNotAvailable=loginpage.isRedAlertDisplayed();
		  Assert.assertTrue(isHomePageNotAvailable,Constants.LOGIN_INVALID_USERNAME_AND_INVALID_PASSWORD);
    }
 
   @DataProvider(name="LoginProvider")
	public Object[][] getDataFromTestData() throws IOException{
		return new Object[][] {{ExcelUtilities.getStringData(4, 0,"loginpage"),ExcelUtilities.getStringData(4,1,"loginpage")}};
		
	
   }
		
	
	
	}
	


