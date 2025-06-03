package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtilities;

public class ManageCategoryTest extends Base{

	@Test
	public void manageCategoryTest() throws IOException, AWTException
	{
	
	      String username=ExcelUtilities.getStringData(1, 0, "loginpage"); 
	      String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		  LoginPage loginpage=new LoginPage(driver);	
		  loginpage.enterUsename(username);
		  loginpage.enterPassword(password);
		  loginpage.clickSignInButton();
		
		  String category=ExcelUtilities.getStringData(2, 0, "managecategorypage");
		  String topmenu=ExcelUtilities.getStringData(2,1 , "managecategorypage");
		  String leftmenu=ExcelUtilities.getStringData(2, 2, "managecategorypage");
		  ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		  managecategory.clickManageContactMoreInfo();
		  managecategory.clickNewButton();
		  managecategory.enterCategoryField(category);
		  managecategory.selectGroups();
		  managecategory.clickChooseFile();
		  managecategory.selectTopMenuRadioButton(topmenu);
		  managecategory.selectLeftMenuRadioButton(leftmenu);
		  managecategory.clickSaveButton();
		  boolean isAddCategoryPageAvailable=managecategory.isAlertDisplayed(); 
		  Assert.assertTrue(isAddCategoryPageAvailable); 
		
	}
	
	
	/* @Test
	  public void deleteManageCategory() throws IOException, AWTException
	{
	
	      String username=ExcelUtilities.getStringData(1, 0, "loginpage"); 
	      String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		  LoginPage loginpage=new LoginPage(driver);	
		  loginpage.enterUsename(username);
		  loginpage.enterPassword(password);
		  loginpage.clickSignInButton();
		
		  ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		  managecategory.clickManageContactMoreInfo();
		  managecategory.deleteCategory();
		
	} */
}
