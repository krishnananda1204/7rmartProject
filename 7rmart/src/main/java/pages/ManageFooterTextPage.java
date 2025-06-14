package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {

	public WebDriver driver;
	public ManageFooterTextPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']") WebElement manageFooterTextMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']") WebElement editButton;
	@FindBy(xpath="//textarea[@name='address']") WebElement addressField;
	@FindBy(xpath="//input[@name='email']") WebElement emailField;
	@FindBy(xpath="//input[@name='phone']") WebElement phoneField;
	@FindBy(xpath="//button[@name='Update']") WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	
	
   /* public void clickManageFooterTextMoreInfo()
	{
		manageFooterTextMoreInfo.click();
	}  */
	
	public ManageFooterTextPage clickEditButton()
	{
		editButton.click();
		return this;
	}
	public ManageFooterTextPage clearAllField()
	{
		addressField.clear();
		emailField.clear();
		phoneField.clear();
		return this;
		
	}
	public ManageFooterTextPage enterAddressField(String address)
	{
		addressField.sendKeys(address);
		return this;
	}
	public ManageFooterTextPage enterEmailField(String email)
	{
		emailField.sendKeys(email);
		return this;
	}
	public ManageFooterTextPage enterPhoneField(String phone)
	{
		phoneField.sendKeys(phone);
		return this;
	}
	public ManageFooterTextPage clickUpdateButton()
	{
		updateButton.click();
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
