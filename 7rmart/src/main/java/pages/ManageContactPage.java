package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
    
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	public ManageContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']") WebElement manageContactMoreInfo;
	@FindBy(xpath="//a[@role='button' and @class='btn btn-sm btn btn-primary btncss']") WebElement editButton;
	@FindBy(xpath="//input[@id='phone']") WebElement phoneField;
	@FindBy(xpath="//input[@id='email']") WebElement emailField;
	@FindBy(xpath="//textarea[@name='address']") WebElement addressField;
	@FindBy(xpath="//textarea[@name='del_time']") WebElement delivery_time_Field;
	@FindBy(xpath="//input[@name='del_limit']") WebElement delivery_chrg_limit_Field;
	@FindBy(xpath="//button[@name='Update']") WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	

 /* public void clickManageContactMoreInfo()
	{
		manageContactMoreInfo.click();
	}   */
	
	public ManageContactPage clickEditButton()
	{
		editButton.click();
		return this;
	}
	public ManageContactPage clearAllField()
	{
		phoneField.clear();
		emailField.clear();
		addressField.clear();
		delivery_time_Field.clear();
		delivery_chrg_limit_Field.clear();
		return this;
	}
	public ManageContactPage enterPhone(String phone)
	{
		
		phoneField.sendKeys(phone);
		return this;
	}
	public ManageContactPage enterEmail(String email)
	{
		
		emailField.sendKeys(email);
		return this;
	}
	public ManageContactPage EnterAddress(String address)
	{
		addressField.sendKeys(address);
		return this;
	}
	public ManageContactPage enterDeliveryTime(String deliverytime)
	{
		delivery_time_Field.sendKeys(deliverytime);
		return this;
	}
	public ManageContactPage enterDeliveryChargeLimit(String deliverychargelimit)
	{
		delivery_chrg_limit_Field.sendKeys(deliverychargelimit);
		return this;
	}
	/* public void clickUpdateButton()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", updateButton);
		//updateButton.click();
	
	} */
	
	public ManageContactPage clickUpdateButton() {
		
        pageutility.click(updateButton, driver);
		return this;
    }
	public boolean isAlertDisplayed()  
	{
		 return alert.isDisplayed();
	}
	public boolean isUpdateButtonDisplayed()
	{   
		return updateButton.isDisplayed();
	}
}
