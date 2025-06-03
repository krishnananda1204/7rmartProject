package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
    public LoginPage(WebDriver driver) {  
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']") WebElement usernameField;
	@FindBy(xpath="//input[@name='password']") WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']") WebElement signinField;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement redAlert;
	
	
	
	public LoginPage enterUsename(String username)
	{
		usernameField.sendKeys(username);
		return this;
	}
	
	public LoginPage enterPassword(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
	
	public HomePage clickSignInButton()
	{
		signinField.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardDisplayed()
	{
		return dashboard.isDisplayed();
	}
	public boolean isRedAlertDisplayed()
	{
		return redAlert.isDisplayed();
		
	}
}
