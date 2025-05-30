package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;

public class ManageContactTest extends Base{

	@Test
	public void manageContactTestEdit() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage"); 
	      String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		  LoginPage loginpage=new LoginPage(driver);
		  loginpage.enterUsename(username);
		  loginpage.enterPassword(password);
		  loginpage.clickSignInButton();
		  
		  String phone=ExcelUtilities.getLongData(2,0, "managecontactpage");
		  String email=ExcelUtilities.getStringData(2,1, "managecontactpage");
		  String address=ExcelUtilities.getStringData(2,2, "managecontactpage");
		  String deliverytime=ExcelUtilities.getIntegerData(2,3, "managecontactpage");
		  String deliverychargelimit=ExcelUtilities.getIntegerData(1,4, "managecontactpage");
		  ManageContactPage managecontactpage=new ManageContactPage(driver);
		  managecontactpage.clickManageContactMoreInfo();
		  managecontactpage.clickEditButton();
		  managecontactpage.clearAllField();
		  managecontactpage.enterPhone(phone);
		  managecontactpage.enterEmail(email);
		  managecontactpage.EnterAddress(address);
		  managecontactpage.enterDeliveryTime(deliverytime);
		  managecontactpage.enterDeliveryChargeLimit(deliverychargelimit);
		  managecontactpage.clickUpdateButton();
		  boolean isContactPageAvailable=managecontactpage.isAlertDisplayed(); 
		  Assert.assertTrue(isContactPageAvailable);
		  
}
	@Test
	public void manageContactUpdateButton() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage"); 
	      String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		  LoginPage loginpage=new LoginPage(driver);
		  loginpage.enterUsename(username);
		  loginpage.enterPassword(password);
		  loginpage.clickSignInButton();
		  
		  ManageContactPage managecontactpage=new ManageContactPage(driver);
		  managecontactpage.clickManageContactMoreInfo();
		  managecontactpage.clickEditButton();
		  boolean isUpdateButtonAvailable=managecontactpage.isUpdateButtonDisplayed();
		  Assert.assertTrue(isUpdateButtonAvailable);
	}
}
