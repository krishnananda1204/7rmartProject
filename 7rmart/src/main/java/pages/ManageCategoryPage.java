package pages;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage {

	public WebDriver driver;
	  PageUtility pageutility=new PageUtility();
	  public ManageCategoryPage(WebDriver driver) {
			this.driver=driver; 
			PageFactory.initElements(driver, this );
		}
	  
	  @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']") WebElement manageCategoryMoreInfo;
	  @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	  @FindBy(xpath="//input[@name='category']") WebElement categoryField;
	  @FindBy(xpath="//li[@id='134-selectable']") WebElement selectGroupsField;
	  @FindBy(xpath="//input[@id='main_img']") WebElement imageUpload;
	  @FindBy(xpath="//input[@name='top_menu' and @value='yes']") WebElement top_menu_radio_yes;
	  @FindBy(xpath="//input[@name='top_menu' and @value='no']") WebElement top_menu_radio_no;
	  @FindBy(xpath="//input[@name='show_home' and @value='yes']") WebElement left_menu_radio_yes;
	  @FindBy(xpath="//input[@name='show_home' and @value='no']") WebElement left_menu_radio_no;
	  @FindBy(xpath="//button[@name='create']") WebElement saveButton;
	  @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	  @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/category/delete?del=2314&page_ad=1']") WebElement deleteButton;
	 

	  public void clickManageContactMoreInfo()
		{
		  manageCategoryMoreInfo.click();
		}
	  public void clickNewButton()
		{
		  newButton.click();
		}
	  public void enterCategoryField(String category)
		{
		  categoryField.sendKeys(category);
		}
	  public void selectGroups()
		{
		  selectGroupsField.click();
		}
	  public void clickChooseFile() throws AWTException 
		{
		  //imageUpload.click();
		  //imageUpload.sendKeys(imagepath);
		  
		  FileUploadUtility fileuploadutility=new FileUploadUtility();
		  //fileuploadutility.fileuploadUsingRobertClass(imageUpload, Constants.BAGIMAGE);
		  fileuploadutility.fileUploadUsingSendKeys(imageUpload, Constants.WATCHIMAGE); 
		}
	  public void selectTopMenuRadioButton(String value) {
		  
		    if ("yes".equalsIgnoreCase(value)) {
		        
		    	pageutility.click(left_menu_radio_yes, driver);
		    } else {
		       
		    	pageutility.click(top_menu_radio_no, driver);
		    }
		}

		public void selectLeftMenuRadioButton(String value) {
		   
		    if ("yes".equalsIgnoreCase(value)) {
		       
		    	pageutility.click(left_menu_radio_yes, driver);
		    } else {
		        
		    	pageutility.click(left_menu_radio_no, driver);
		    }
		}

	  public void clickSaveButton()
		{
		  //JavascriptExecutor js = (JavascriptExecutor) driver;
		  //js.executeScript("arguments[0].click();", saveButton);
		  //saveButton.click();
		 // pageutility.clickByJs(driver, saveButton);
		  pageutility.click(saveButton, driver);
		}
	  public boolean isAlertDisplayed()  
		{
		  return alert.isDisplayed();		
		}
	  
	  public void deleteCategory()
	  {
		  deleteButton.click();
		  driver.switchTo().alert().accept();
		  //driver.switchTo().alert().dismiss();
	  }
	 
	 
}
