package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtilities;

public class ManageCategoryTest extends Base{

	ManageCategoryPage managecategorypage;
	HomePage homepage;
	@Test(description="Verifying Add new category in Manage category is working successfully")
	public void verifyAddNewCategorySuccessfullyInManageCategoryPage() throws IOException, AWTException
	{
	
	      String username=ExcelUtilities.getStringData(1, 0, "loginpage"); 
	      String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		  LoginPage loginpage=new LoginPage(driver);	
		  loginpage.enterUsename(username).enterPassword(password);
		  //loginpage.enterPassword(password);
		  homepage=loginpage.clickSignInButton();
		
		  String category=ExcelUtilities.getStringData(3, 0, "managecategorypage");
		  String topmenu=ExcelUtilities.getStringData(3,1 , "managecategorypage");
		  String leftmenu=ExcelUtilities.getStringData(3, 2, "managecategorypage");
		  //ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		  //managecategory.clickManageContactMoreInfo();
		  managecategorypage=homepage.clickManageCategoryMoreInfo();
		  managecategorypage.clickNewButton().enterCategoryField(category).selectGroups().clickChooseFile().selectTopMenuRadioButton(topmenu).selectLeftMenuRadioButton(leftmenu).clickSaveButton();
		  //managecategory.enterCategoryField(category);
		  //managecategory.selectGroups();
		  //managecategory.clickChooseFile();
		  //managecategory.selectTopMenuRadioButton(topmenu);
		  //managecategory.selectLeftMenuRadioButton(leftmenu);
		  //managecategory.clickSaveButton();
		  boolean isManageCategoryPageAvailable=managecategorypage.isAlertDisplayed(); 
		  Assert.assertTrue(isManageCategoryPageAvailable,Constants.ADD_CATEGORY); 
		
	}
	
	
	 @Test(description="Verifying delete existing category in Manage category is working successfully")
	  public void verifyDeleteExistingCategorySuccessfullyInManageCategoryPage() throws IOException, AWTException
	{
	
	      String username=ExcelUtilities.getStringData(1, 0, "loginpage"); 
	      String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		  LoginPage loginpage=new LoginPage(driver);	
		  loginpage.enterUsename(username).enterPassword(password);
		  //loginpage.enterPassword(password);
		  homepage=loginpage.clickSignInButton();
		
		  //ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		  //managecategory.clickManageCategoryMoreInfo();
		  managecategorypage=homepage.clickManageCategoryMoreInfo();
		  managecategorypage.deleteCategory();
		  boolean isManageCategoryPageAvailable=managecategorypage.isAlertDisplayed(); 
		  Assert.assertTrue(isManageCategoryPageAvailable,Constants.DELETE_CATEGORY);
	} 
}
