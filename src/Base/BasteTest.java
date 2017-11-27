package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import Pages.LoginPage;
import Pages.MenuPage;
import Pages.RegisterPage;


public class BasteTest {
	
	protected static WebDriver driver;
	
	protected MenuPage menuPage;
	protected LoginPage loginPage;
	protected RegisterPage registerPage;
	
	
	@BeforeMethod
	@Parameters({ "browser", "startURL" })
	public void setup(String browser, String startURL) {
		createDriver(browser, startURL);
		menuPage = new MenuPage(driver);
		loginPage = new LoginPage(driver);

	}

	public WebDriver createDriver(String browserType, String startURL) {

		try {
			driver = null;
			if (browserType.toLowerCase().equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserType.toLowerCase().equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			driver.get(startURL);
			driver.manage().window().maximize();
			return driver;
		} catch (Exception e) {
			System.out.println(e);
			return driver;
		}
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
}
