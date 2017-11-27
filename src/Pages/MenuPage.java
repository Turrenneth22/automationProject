package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class MenuPage extends BasePage{
	
	@FindBy(xpath = "//a[@id='ctl00_LoginView_LoginLink']")
	WebElement loginButton;
	
	@FindBy(xpath = "//div[@id='nav_login']")
	WebElement welcomeMessage;
	
	@FindBy(xpath = "//a[@id='ctl00_LoginView_RegisterLink']")
	WebElement registerButton;
	
	public MenuPage(WebDriver driver){
		super(driver); 
		PageFactory.initElements(driver, this);
		
	}
    
    public void clickLoginButton(){
    	waitForElementEnabled(loginButton);
    	clickOnElement(loginButton);
    }
    
    public void clickRegisterButton(){
    	clickOnElement(registerButton);
    }
    
    public String getWelcomeMessage(){
    	return getTextFromElement(welcomeMessage);
    }
    
    public LoginPage goToLogin(){
    	clickLoginButton();
    	return new LoginPage(driver);
    }
    
    public RegisterPage goToRegister(){
    	clickRegisterButton();
		return new RegisterPage(driver);
    }
    
}

