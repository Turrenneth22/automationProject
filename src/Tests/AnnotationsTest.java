package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Pages.LoginPage;
import Pages.MenuPage;
import Pages.RegisterPage;

public class AnnotationsTest {

	WebDriver webDriver;
	MenuPage menuPage;
	LoginPage loginPage;
	RegisterPage registerPage;
	
	@DataProvider(name = "InvalidCredentials")
	public static Object [][] InvalidCredentials() {
	return new Object[][] { 
		{"Kenneth22", "123456abC", "Your login attempt was not successful. Please try again." }};
	
	}
	
	@DataProvider(name = "PasswordsMismach")
	public static Object [][] PasswordsMismach() {
	return new Object[][] { 
		{"Kenneth", "Alvarado", "copetilla_22@hotmail.com", "Turrenneth", "123456abC#", "123456", "Color favorito", "Azul", "The password and confirmation password must match."}};
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("Starting Execution");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Executing class: AnnotationsTest");
	}
	
	@BeforeMethod
	public void setUp(){
		System.out.println("Creating Driver");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\kalvarado-as\\workspace\\AutomationStages\\Driver\\geckodriver.exe");
		webDriver = new FirefoxDriver();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.get("http://qa-trainingw7:86/");
	}
	
	@Test(dataProvider = "InvalidCredentials")
	public void Test01(String username, String password, String expectedErrorMessage){
		System.out.println("Test 01");
		menuPage = new MenuPage(webDriver);
		loginPage = menuPage.goToLogin();
		loginPage.IncorrectLogin(username, password, expectedErrorMessage);
		
		String message = loginPage.getErrorMessage();
		  
		Assert.assertTrue(message.contains(expectedErrorMessage), "The app throws an unexpected message" + message);
		
	}
	
	@Test(dataProvider = "PasswordsMismach")
	public void Test02(String firstName, String lastName, String email, String userName, String password, String confirmPassword, String question, String answer, String expectedErrorMessage){
		menuPage = new MenuPage(webDriver);
		registerPage = menuPage.goToRegister();	
		registerPage.Register(firstName, lastName, email, userName, password, confirmPassword, question, answer, expectedErrorMessage);
		
		String message = registerPage.getPasswordsMismachMessage();
		  
		Assert.assertTrue(message.contains(expectedErrorMessage), "The app throws an unexpected message" + message);
	}
	
	@AfterMethod
	public void beforeMethod(){
		System.out.println("Deleting Driver");
		webDriver.quit();
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("Completing execution class: AnnotationsTest");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("After Test");
	}
	
}
