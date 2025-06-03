package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtilities;

public class ManageFooterTextTest extends Base{

	ManageFooterTextPage managefootertextpage;
	HomePage homepage;
	@Test(description="Verifying whether the user can Edit Footer Text details in the Manage Footer Text section")
	public void verifyUserCanEditFooterTextDetailsSuccessfullyInManageFooterTextPage() throws IOException
	{
		
	
	      String username=ExcelUtilities.getStringData(1, 0, "loginpage"); 
	      String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		  LoginPage loginpage=new LoginPage(driver);	
		  loginpage.enterUsename(username).enterPassword(password);
		  //loginpage.enterPassword(password);
		  homepage=loginpage.clickSignInButton();
		
		  String address=ExcelUtilities.getStringData(2, 0, "managefootertextpage");
		  String email=ExcelUtilities.getStringData(2, 1, "managefootertextpage");
		  String phone=ExcelUtilities.getLongData(2, 2, "managefootertextpage");
		  //ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		  //managefootertextpage.clickManageFooterTextMoreInfo();
		  managefootertextpage=homepage.clickManageFooterTextMoreInfo();
		  managefootertextpage.clickEditButton().clearAllField().enterAddressField(address).enterEmailField(email).enterPhoneField(phone).clickUpdateButton();
		  //managefootertextpage.clearAllField();
		  //managefootertextpage.enterAddressField(address);
		  //managefootertextpage.enterEmailField(email);
		  //managefootertextpage.enterPhoneField(phone);
		  //managefootertextpage.clickUpdateButton();
		
		  boolean isFooterTextPageAvailable=managefootertextpage.isAlertDisplayed();  
		  Assert.assertTrue(isFooterTextPageAvailable,Constants.EDIT_FOOTERTEXT); 
		
	}
	@Test(description="Verifying whether the Update Button is displayed in the Edit Footer Text section")
	public void verifyUpdateButtonIsDisplayedSuccessfullyInTheEditFooterTextSection() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage"); 
	      String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		  LoginPage loginpage=new LoginPage(driver);
		  loginpage.enterUsename(username).enterPassword(password);
		  //loginpage.enterPassword(password);
		  homepage=loginpage.clickSignInButton();
		  
		  //ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		  //managefootertextpage.clickManageFooterTextMoreInfo();
		  managefootertextpage=homepage.clickManageFooterTextMoreInfo();
		  managefootertextpage.clickEditButton();
		  boolean isUpdateButtonAvailable=managefootertextpage.isUpdateButtonDisplayed();
		  Assert.assertTrue(isUpdateButtonAvailable,Constants.UPDATE_BUTTON);
	}
}
