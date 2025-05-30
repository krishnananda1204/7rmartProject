package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {
	public WebDriver driver;
	  public ManageNewsPage(WebDriver driver) {
			this.driver=driver; 
			PageFactory.initElements(driver, this );
		}

		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']") WebElement manageNewsMoreInfo;
		@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
		@FindBy(xpath="//textarea[@id='news']") WebElement newsField;
		@FindBy(xpath="//button[@name='create']") WebElement saveButton;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;	
		
		public void clickManageNewsMoreInfo()
		{
			manageNewsMoreInfo.click();
		}
		public void clickNewButton()
		{
			newButton.click();
		}
		public void enterNews(String news)
		{
			newsField.sendKeys(news);
		}
		public void clickSaveButton()
		{
			WaitUtility waitutility=new WaitUtility();
			waitutility.waitForElementToBeClickable(driver, saveButton);
			saveButton.click();
		}
		public boolean isAlertDisplayed()  
		{
			 return alert.isDisplayed();
		}
}
