package Base;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
	
	protected WebDriver driver;
	WebDriverWait wait;
	
	
	
	public BasePage(WebDriver otherDriver) {
		driver = otherDriver;
		wait = new WebDriverWait(driver, 5);
		
		}

	public boolean typeOnElement(WebElement element, String text)
	{
		try {
			element.clear();
			element.sendKeys(text);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	 
	public String getTextFromElement(WebElement element)
	{
		try {
			return element.getText();
		} catch (Exception e) {
			return null;
		}
	}
	 
	public boolean clickOnElement(WebElement element)
	{
		try {
			element.click();
			return true;
		} catch (Exception e) {
			return false;	
		}
	}
	
	public boolean waitForElementVisible(WebElement element)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;	
		}
	}
	 
	public boolean waitForElementEnabled(WebElement element)
	{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;	
		}
	}
	 
	public boolean waitForElementNotVisible(WebElement element)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return false;
		} catch (Exception e) {
			return true;	
		}
	}
	
	public boolean isElementPresent(By by) {
	     try {
	         driver.findElement(by);
	         return true;
	     } catch (NoSuchElementException e) {
	         return false;
	     }
	 }		


}


