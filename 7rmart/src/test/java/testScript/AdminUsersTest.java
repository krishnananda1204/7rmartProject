package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	@Test(retryAnalyzer=retry.Retry.class) //testcase fail avumbol re execute avan
	public void adminUsersTest() throws IOException
	{
		   //String username="admin"; //credentials
		  // String password="admin"; //credentials
	    String username=ExcelUtilities.getStringData(1, 0, "loginpage");
	     String password=ExcelUtilities.getStringData(1, 1, "loginpage");
	     LoginPage loginpage=new LoginPage(driver);	//object create
		  loginpage.enterUsename(username);
		  loginpage.enterPassword(password);
		  loginpage.clickSignInButton();
		  
		 //String username_AdminUserTest=ExcelUtilities.getStringData(1, 0, "adminuserspage");
		 //String password_AdminUserTest=ExcelUtilities.getStringData(1, 1, "adminuserspage");
		    FakerUtility fakerutility=new FakerUtility();
		    String username_AdminUserTest= fakerutility.creatARandomFirstName();
		    String password_AdminUserTest= fakerutility.creatARandomLastName();
	     String userType=ExcelUtilities.getStringData(2,2, "adminuserspage");
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickAdminUsersMoreInfo();
		adminuserspage.clickNewButton();
		adminuserspage.enterUsername(username_AdminUserTest);
		adminuserspage.enterPassword(password_AdminUserTest);
		adminuserspage.selectUserTypeDropdown(userType);
		adminuserspage.clickSaveButton();
		boolean isAdminUsersPageAvailable=adminuserspage.isAlertDisplayed(); 
		Assert.assertTrue(isAdminUsersPageAvailable);
		
	}
}
