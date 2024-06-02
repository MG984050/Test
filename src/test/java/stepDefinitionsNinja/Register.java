package stepDefinitionsNinja;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Register {
	WebDriver driver;

	@Given("User navigates to Register Account Page")
	public void user_navigates_to_register_account_page() {
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("First Name"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("Last Name"));
		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("E-Mail"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("Telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("Password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("Password"));

	}

	@When("User select the privacy policy")
	public void user_select_the_privacy_policy() {

		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
	}

	@When("User click on Continue button")
	public void user_click_on_continue_button() {
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	}

	@Then("User account should be created successfully")
	public void user_account_should_be_created_successfully() {
		Assert.assertEquals("Your Account Has Been Created!",
				driver.findElement(By.xpath("//div[@id='content']/h1")).getText());

	}

	@When("User select Yes for newsletter")
	public void user_select_yes_for_newsletter() {
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();

	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText()
				.contains("Warning: E-Mail Address is already registered!"));

	}

	@When("User dont enters any details to the below fields")
	public void user_dont_enters_any_details_to_the_below_fields() {
		// intentionally keep it blank

	}

	@Then("User should get a proper warning message for every fields")
	public void user_should_get_a_proper_warning_message_for_every_fields() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText()
				.contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']"))
						.getText().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']"))
				.getText().contains("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='E-Mail Address does not appear to be valid!']"))
				.getText().contains("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Telephone must be between 3 and 32 characters!']"))
				.getText().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Password must be between 4 and 20 characters!']"))
				.getText().contains("Password must be between 4 and 20 characters!"));

	}

}
