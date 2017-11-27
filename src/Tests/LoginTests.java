package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BasteTest;

public class LoginTests extends BasteTest {
	String message = "";

	@DataProvider(name = "InvalidCredentials")
	public static Object[][] InvalidCredentials() {
		return new Object[][] {
				{ "Kenneth22", "123456abC", "Your login attempt was not successful. Please try again." } };
	}

	@DataProvider(name = "ValidCredentials")
	public static Object[][] ValidCredentials() {
		return new Object[][] { { "Kevin22", "123456abC#", "Welcome, Kevin22 | Logout" } };
	}

	@Test
	public void LoginTest() {
		menuPage.goToLogin();

		Assert.assertTrue(loginPage.isElementPresent(By.xpath("//h2[@class='section']")));
		Assert.assertTrue(loginPage.isElementPresent(By.xpath("//input[@id='ctl00_Main_LoginConrol_UserName']")));
		Assert.assertTrue(loginPage.isElementPresent(By.xpath("//input[@id='ctl00_Main_LoginConrol_Password']")));
		Assert.assertTrue(loginPage.isElementPresent(By.xpath("//input[@id='ctl00_Main_LoginConrol_LoginButton']")));
	}

	@Test(dataProvider = "InvalidCredentials")
	public void IncorrectLogin(String username, String password, String expectedErrorMessage) {
		message = menuPage.goToLogin().IncorrectLogin(username, password, expectedErrorMessage).getErrorMessage();

		Assert.assertTrue(message.contains(expectedErrorMessage), "The app throws an unexpected message" + message);
	}

	@Test(dataProvider = "ValidCredentials")
	public void CorrectLogin(String username, String password, String expectedErrorMessage) {
		message = menuPage.goToLogin().CorrectLogin(username, password, expectedErrorMessage).getWelcomeMessage();

		Assert.assertTrue(message.contains(expectedErrorMessage), "The app throws an unexpected message" + message);
	}

	@Test
	public void elementEnabled(WebElement logInButton) {
		menuPage.goToLogin();
	}

}