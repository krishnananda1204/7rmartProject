package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;

public class ManageContactTest extends Base{

	ManageContactPage managecontactpage;
	HomePage homepage;
	@Test(description="Verifying whether the user can Edit Contact details in the Manage Contact section")
	public void verifyUserCanEditContactDetailsSuccessfullyInManageContactPage() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage"); 
	      String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		  LoginPage loginpage=new LoginPage(driver);
		  loginpage.enterUsename(username).enterPassword(password);
		  //loginpage.enterPassword(password);
		  homepage=loginpage.clickSignInButton();
		  
		  String phone=ExcelUtilities.getLongData(2,0, "managecontactpage");
		  String email=ExcelUtilities.getStringData(2,1, "managecontactpage");
		  String address=ExcelUtilities.getStringData(2,2, "managecontactpage");
		  String deliverytime=ExcelUtilities.getIntegerData(2,3, "managecontactpage");
		  String deliverychargelimit=ExcelUtilities.getIntegerData(1,4, "managecontactpage");
		  //ManageContactPage managecontactpage=new ManageContactPage(driver);
		  //managecontactpage.clickManageContactMoreInfo();
		  managecontactpage=homepage.clickManageContactMoreInfo();
		  managecontactpage.clickEditButton().clearAllField().enterPhone(phone).enterEmail(email).EnterAddress(address).enterDeliveryTime(deliverytime).enterDeliveryChargeLimit(deliverychargelimit).clickUpdateButton();
		  //managecontactpage.clearAllField();
		  //managecontactpage.enterPhone(phone);
		  //managecontactpage.enterEmail(email);
		  //managecontactpage.EnterAddress(address);
		  //managecontactpage.enterDeliveryTime(deliverytime);
		  //managecontactpage.enterDeliveryChargeLimit(deliverychargelimit);
		  //managecontactpage.clickUpdateButton();
		  boolean isContactPageAvailable=managecontactpage.isAlertDisplayed(); 
		  Assert.assertTrue(isContactPageAvailable,Constants.EDIT_CONTACT);
		  
}
	@Test(description="Verifying whether the Update Button is displayed in the Edit Contact section")
	public void verifyUpdateButtonIsDisplayedSuccessfullyInTheEditContactSection() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage"); 
	      String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		  LoginPage loginpage=new LoginPage(driver);
		  loginpage.enterUsename(username).enterPassword(password);
		  //loginpage.enterPassword(password);
		  homepage=loginpage.clickSignInButton();
		  
		  //ManageContactPage managecontactpage=new ManageContactPage(driver);
		  //managecontactpage.clickManageContactMoreInfo();
		  managecontactpage=homepage.clickManageContactMoreInfo();
		  managecontactpage.clickEditButton();
		  boolean isUpdateButtonAvailable=managecontactpage.isUpdateButtonDisplayed();
		  Assert.assertTrue(isUpdateButtonAvailable,Constants.UPDATE_BUTTON);
	}
}
