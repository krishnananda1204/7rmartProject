package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	public WebDriver driver;
    public LogoutPage(WebDriver driver) {  
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@class='img-circle']") WebElement profileButton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']") WebElement logoutButton;
	@FindBy(xpath="//button[@type='submit']") WebElement signInButton;
	

	
	public void clickProfileIcon()
	{
		profileButton.click();
	}
	
	public void clickLogoutButton()
	{
		logoutButton.click();
	}

	public boolean isSignInButtonDisplayed()
	{
		return signInButton.isDisplayed();
	}
	
}
