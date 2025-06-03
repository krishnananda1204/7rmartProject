package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {

	public WebDriver driver;
	   PageUtility pageutility=new PageUtility();  
		public AdminUsersPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement adminUsersMore_info_btn;
		@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement new_btn;
		@FindBy(xpath="//input[@id='username']") WebElement userName_txt;
		@FindBy(xpath="//input[@id='password']") WebElement password_txt;
		@FindBy(xpath="//select[@id='user_type']") WebElement userType_dropdown;
		@FindBy(xpath="//button[@name='Create']") WebElement save_button;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert_box;
		

		/* public void clickAdminUsersMoreInfo()
		{
			adminUsersMore_info_btn.click();
		} */
		
		public AdminUsersPage clickNewButton()
		{
			new_btn.click();
			return this;
		}
		
		public AdminUsersPage enterUsername(String username)
		{
			userName_txt.sendKeys(username);
			return this;
		}
		
		public AdminUsersPage enterPassword(String password)
		{
			password_txt.sendKeys(password);
			return this;
		}
		
		public AdminUsersPage selectUserTypeDropdown(String value)
		{
			//Select select=new Select(userTypeDropdown);
			//select.selectByValue("Staff");
			//Select select=new Select(userType_dropdown);
			//select.selectByIndex(1);
			//Select select=new Select(userTypeDropdown);
		    //select.selectByVisibleText(dropdown);
			
			//PageUtility pageutility=new PageUtility();
			pageutility.selectByVisibleText(userType_dropdown, value);
			//pageutility.selectByIndex(userTypeDropdown, 2);
			//pageutility.selectByValue(userTypeDropdown, "Staff");
			return this;
		}
		public AdminUsersPage clickSaveButton()
		{
			save_button.click();
			return this;
		}
		public boolean isAlertDisplayed()  
		{
			 return alert_box.isDisplayed();
		}
		

		
}
