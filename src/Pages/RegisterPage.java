package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;

public class RegisterPage extends BasePage {

	@FindBy(xpath = "//h2[@class='section']")
	WebElement registerLabel;
	
	@FindBy(xpath = "//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstName']")
	WebElement firstNameInput;
	
	@FindBy(xpath = "//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastName']") 
	WebElement lastNameInput;

	@FindBy(xpath = "//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Email']")
	WebElement emailInput;
	
	@FindBy(xpath = "//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserName']")
	WebElement userNameInput;
	
	@FindBy(xpath = "//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password']")
	WebElement passwordInput;
	
	@FindBy(xpath = "//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPassword']")
	WebElement confirmPasswordInput;
	
	@FindBy(xpath = "//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Question']")
	WebElement securityQuestionInput;
	
	@FindBy(xpath = "//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Answer']")
	WebElement securityAnswerInput;
	
	@FindBy(xpath = "//input[@id='ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton']")
	WebElement submitRegisterButton;
	
	@FindBy(xpath = "//span[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstNameRequired']")
	WebElement firstNameErrorMessage;

	@FindBy(xpath = "//span[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastNameRequired']")
	WebElement lastNameErrorMessage;
	
	@FindBy(xpath = "//span[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_EmailRequired']")
	WebElement emailErrorMessage;
	
	@FindBy(xpath = "//span[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserNameRequired']")
	WebElement userNameErrorMessage;
	
	@FindBy(xpath = "//span[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordRequired']")
	WebElement passwordErrorMessage;
	
	@FindBy(xpath = "//span[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPasswordRequired']")
	WebElement confirmPasswordErrorMessage;
	
	@FindBy(xpath = "//span[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_QuestionRequired']")
	WebElement questionErrorMessage;
	
	@FindBy(xpath = "//span[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_AnswerRequired']")
	WebElement answerErrorMessage;
	
	@FindBy(xpath = "//span[@id='ctl00_Main_InfoLabel']")
	WebElement usernameTakenErrorMessage;
	
	@FindBy(xpath = "//span[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordCompare']")
	WebElement passwordsMismach;
	
	public RegisterPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	
	}
	
	public void typeFirstName(String firstName){
		typeOnElement(firstNameInput, firstName);
	}
	
	public void typeLastName(String lastName){
		typeOnElement(lastNameInput, lastName);
	}
	
	public void typeEmail(String email){
		typeOnElement(emailInput, email);
	}
	
	public void typeUserName(String username){
		typeOnElement(userNameInput, username);
	}
	
	public void typePassword(String password){
		typeOnElement(passwordInput, password);
	}
	
	public void typeConfirmPassword(String confirmPassword){
		typeOnElement(confirmPasswordInput, confirmPassword);
	}
	
	public void typeSecurityQuestion(String question){
		typeOnElement(securityQuestionInput, question);
	}
	
	public void typeSecurityAnswer(String answer){
		typeOnElement(securityAnswerInput, answer);
	}
	
	public void clickSubmitRegister(){
		clickOnElement(submitRegisterButton);
	}
	
	public String getFirstNameErrorMessage(){
		return getTextFromElement(firstNameErrorMessage);
	}
	
	public String getLastNameErrorMessage(){
		return getTextFromElement(lastNameErrorMessage);	
	}
	
	public String getEmailErrorMessage(){
		return getTextFromElement(emailErrorMessage);
	}
	
	public String getUserNameErrorMessage(){
		return getTextFromElement(userNameErrorMessage);
	}
	
	public String getPasswordErrorMessage(){
		return getTextFromElement(passwordErrorMessage);
	}
	
	public String getConfirmPasswordErrorMessage(){
		return getTextFromElement(confirmPasswordErrorMessage);
	}
	
	public String getSecurityQuestionNameErrorMessage(){
		return getTextFromElement(questionErrorMessage);
	}
	
	public String getSecurityAnswerErrorMessage(){
		return getTextFromElement(answerErrorMessage);
	}
	
	public String getUserNameTakenErrorMessage(){
		return getTextFromElement(usernameTakenErrorMessage);
	}

	public String getPasswordsMismachMessage(){
		return getTextFromElement(passwordsMismach);
	}
	
	public String[] getErrorMessages() {
		  		  
		String[] webElementsList = {firstNameErrorMessage.getText(), lastNameErrorMessage.getText(), emailErrorMessage.getText(), userNameErrorMessage.getText(), passwordErrorMessage.getText(), confirmPasswordErrorMessage.getText(),
				  questionErrorMessage.getText(), answerErrorMessage.getText()};		  
		return webElementsList;
	}
	
	public void Register(String firstName, String lastName, String email, String userName, String password, String confirmPassword, String question, String answer, String message){
		typeFirstName(firstName);
		typeLastName(lastName);
		typeEmail(email);
		typeUserName(userName);
		typePassword(password);
		typeConfirmPassword(confirmPassword);
		typeSecurityQuestion(question);
		typeSecurityAnswer(answer);
		clickSubmitRegister();
	}

}
