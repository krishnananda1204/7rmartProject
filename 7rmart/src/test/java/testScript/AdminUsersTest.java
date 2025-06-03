package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	AdminUsersPage adminuserspage;
	HomePage homepage;
	@Test(retryAnalyzer=retry.Retry.class,description="Verifying Admin user can add new user Successfully on the Admin Users Page") //testcase fail avumbol re execute avan
	public void verifyAddNewUsersSuccessfullyInNewAdminusersPage() throws IOException
	{
		   //String username="admin"; //credentials
		  // String password="admin"; //credentials
	    String username=ExcelUtilities.getStringData(1, 0, "loginpage");
	     String password=ExcelUtilities.getStringData(1, 1, "loginpage");
	     LoginPage loginpage=new LoginPage(driver);	//object create
		  loginpage.enterUsename(username).enterPassword(password);
		  //loginpage.enterPassword(password);
		  homepage=loginpage.clickSignInButton();
		  
		 //String username_AdminUserTest=ExcelUtilities.getStringData(1, 0, "adminuserspage");
		 //String password_AdminUserTest=ExcelUtilities.getStringData(1, 1, "adminuserspage");
		    FakerUtility fakerutility=new FakerUtility();
		    String username_AdminUserTest= fakerutility.creatARandomFirstName();
		    String password_AdminUserTest= fakerutility.creatARandomLastName();
	     String userType=ExcelUtilities.getStringData(2,2, "adminuserspage");
		//AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		//adminuserspage.clickAdminUsersMoreInfo();
	     adminuserspage=homepage.clickAdminUsersMoreInfo();
		adminuserspage.clickNewButton().enterUsername(username_AdminUserTest).enterPassword(password_AdminUserTest).selectUserTypeDropdown(userType).clickSaveButton();
		//adminuserspage.enterUsername(username_AdminUserTest);
		//adminuserspage.enterPassword(password_AdminUserTest);
		//adminuserspage.selectUserTypeDropdown(userType);
		//adminuserspage.clickSaveButton();
		boolean isAdminUsersPageAvailable=adminuserspage.isAlertDisplayed(); 
		Assert.assertTrue(isAdminUsersPageAvailable,Constants.ADD_ADMINUSER);
		
	}
}
