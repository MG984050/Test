package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyHooks {
	WebDriver driver;

	@Before
	public void setUp() {
		DriverFactory.intializeBrowser("chrome");
		driver = DriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
	}

	@After
	public void tearDown() {
		driver.quit();

	}
}
