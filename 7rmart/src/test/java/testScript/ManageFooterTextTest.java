package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtilities;

public class ManageFooterTextTest extends Base{

	@Test
	public void manageFooterTextTest() throws IOException
	{
		
	
	      String username=ExcelUtilities.getStringData(1, 0, "loginpage"); 
	      String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		  LoginPage loginpage=new LoginPage(driver);	
		  loginpage.enterUsename(username);
		  loginpage.enterPassword(password);
		  loginpage.clickSignInButton();
		
		  String address=ExcelUtilities.getStringData(2, 0, "managefootertextpage");
		  String email=ExcelUtilities.getStringData(2, 1, "managefootertextpage");
		  String phone=ExcelUtilities.getLongData(2, 2, "managefootertextpage");
		  ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		  managefootertextpage.clickManageFooterTextMoreInfo();
		  managefootertextpage.clickEditButton();
		  managefootertextpage.clearAllField();
		  managefootertextpage.enterAddressField(address);
		  managefootertextpage.enterEmailField(email);
		  managefootertextpage.enterPhoneField(phone);
		  managefootertextpage.clickUpdateButton();
		
		  boolean isFooterTextPageAvailable=managefootertextpage.isAlertDisplayed();  
		  Assert.assertTrue(isFooterTextPageAvailable); 
		
	}
	@Test
	public void manageFooterUpdateButton() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage"); 
	      String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		  LoginPage loginpage=new LoginPage(driver);
		  loginpage.enterUsename(username);
		  loginpage.enterPassword(password);
		  loginpage.clickSignInButton();
		  
		  ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		  managefootertextpage.clickManageFooterTextMoreInfo();
		  managefootertextpage.clickEditButton();
		  boolean isUpdateButtonAvailable=managefootertextpage.isUpdateButtonDisplayed();
		  Assert.assertTrue(isUpdateButtonAvailable);
	}
}
