package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//h2[@class='section']")
	WebElement loginLabel;

	@FindBy(xpath = "//input[@id='ctl00_Main_LoginConrol_UserName']")
	WebElement usernameInput;

	@FindBy(xpath = "//input[@id='ctl00_Main_LoginConrol_Password']")
	WebElement passwordInput;

	@FindBy(xpath = "//input[@id='ctl00_Main_LoginConrol_LoginButton']")
	WebElement logInButton;

	@FindBy(xpath = "//div[@class='content_right']")
	WebElement errorMessage;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void typeUsername(String username) {
		typeOnElement(usernameInput, username);
	}

	public void typePassword(String password) {
		typeOnElement(passwordInput, password);
	}

	public void clicklogInButton() {
		clickOnElement(logInButton);
	}

	public String getErrorMessage() {
		return getTextFromElement(errorMessage);
	}

	public MenuPage goToMenu() {
		clicklogInButton();
		return new MenuPage(driver);
	}

	public void elementEnabled(WebElement element) {
		waitForElementEnabled(logInButton);
	}

	public LoginPage IncorrectLogin(String username, String password, String expectedErrorMessage) {
		typeUsername(username);
		typePassword(password);
		clicklogInButton();
		getErrorMessage();
		return new LoginPage(driver);
	}

	public MenuPage CorrectLogin(String username, String password, String expectedErrorMessage) {
		typeUsername(username);
		typePassword(password);
		goToMenu();
		return new MenuPage(driver);
	}

	public void logInButtonEnabled() {
		elementEnabled(logInButton);
	}
}
