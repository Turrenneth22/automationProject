package Tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTests extends Base.BasteTest {
	
	
	@DataProvider(name = "UsernameTaken")
	public static Object [][] UsernameTaken() {
	return new Object[][] { 
		{"Kenneth", "Alvarado", "copetilla_22@hotmail.com", "Kevin22", "123456abC#", "123456abC#", "Color favorito", "Azul", "User name already exists. Please enter a different user name."}};
	}
	
	@DataProvider(name = "PasswordsMismach")
	public static Object [][] PasswordsMismach() {
	return new Object[][] { 
		{"Kenneth", "Alvarado", "copetilla_22@hotmail.com", "Turrenneth", "123456abC#", "123456", "Color favorito", "Azul", "The password and confirmation password must match."}};
	}
	
	@Test
	public void RegisterPageDisplayed(){
		menuPage.goToRegister();	
		
		Assert.assertTrue(registerPage.isElementPresent(By.xpath("//h2[@class='section']")));
		Assert.assertTrue(registerPage.isElementPresent(By.xpath("//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstName']")));
		Assert.assertTrue(registerPage.isElementPresent(By.xpath("//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastName']")));
		Assert.assertTrue(registerPage.isElementPresent(By.xpath("//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Email']")));
		Assert.assertTrue(registerPage.isElementPresent(By.xpath("//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserName']")));
		Assert.assertTrue(registerPage.isElementPresent(By.xpath("//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password']")));
		Assert.assertTrue(registerPage.isElementPresent(By.xpath("//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPassword']")));
		Assert.assertTrue(registerPage.isElementPresent(By.xpath("//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Question']")));
		Assert.assertTrue(registerPage.isElementPresent(By.xpath("//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Answer']")));

	}
	
	@Test
	public void MandatoryFields(){
		menuPage.goToRegister();	
		registerPage.clickSubmitRegister();
		
		String[] expectedErrorMessages = {"First name is required.", "Last name is required.", "Email is required.", "User name is required.", "Password is required.",
			    "Confirm password is required.", "Security question is required.", "Security answer is required."};
			  String [] actualErrorMessages = registerPage.getErrorMessages();
			  Boolean result = true;
			  
			  
			  for (int i = 0; i < actualErrorMessages.length; i++) {
			   if(!expectedErrorMessages[i].equals(actualErrorMessages[i])){
			    result = false;
			   } 
			  }
			  
			  Assert.assertTrue(result);
	}
	
	@Test(dataProvider = "UsernameTaken")
	public void UsernameTaken(String firstName, String lastName, String email, String userName, String password, String confirmPassword, String question, String answer, String expectedErrorMessage){
		menuPage.goToRegister();	
		registerPage.Register(firstName, lastName, email, userName, password, confirmPassword, question, answer, expectedErrorMessage);
		
		String message = registerPage.getUserNameTakenErrorMessage();
		  
		Assert.assertTrue(message.contains(expectedErrorMessage), "The app throws an unexpected message" + message);
	}	
	
	@Test(dataProvider = "PasswordsMismach")
	public void PasswordsMismach(String firstName, String lastName, String email, String userName, String password, String confirmPassword, String question, String answer, String expectedErrorMessage){
		menuPage.goToRegister();	
		registerPage.Register(firstName, lastName, email, userName, password, confirmPassword, question, answer, expectedErrorMessage);
		
		String message = registerPage.getPasswordsMismachMessage();
		  
		Assert.assertTrue(message.contains(expectedErrorMessage), "The app throws an unexpected message" + message);
	}	
	
	@AfterMethod
	public void tearDown(){
	System.out.println("Completing Execution");
	driver.quit();
	
	}

}
