package stepDefinitionsNinja;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	WebDriver driver;

	@Given("User navigate to login page")
	public void user_navigate_to_login_page() {
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.partialLinkText("Login")).click();

	}

	@When("User enter valid email address {string} into email address field")
	public void user_enter_valid_email_address_into_email_address_field(String emailText) {
		driver.findElement(By.id("input-email")).sendKeys(emailText);

	}

	@When("User enter valid password {string} into password field")
	public void user_enter_valid_password_into_password_field(String passwordText) {
		driver.findElement(By.id("input-password")).sendKeys(passwordText);

	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@Then("User logged in successfully")
	public void user_logged_in_successfully() {
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

	}

	@When("User enter invalid email address {string} into email address field")
	public void user_enter_invalid_email_address_into_email_address_field(String invalidEmailText) {
		driver.findElement(By.id("input-email")).sendKeys(invalidEmailText);

	}

	@When("User enter invalid password {string} into password field")
	public void user_enter_invalid_password_into_password_field(String invalidPasswordText) {
		driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText);
	}

	@Then("Error message should be displayed")
	public void error_message_should_be_displayed() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText()
				.contains("Warning: No match for E-Mail Address and/or Password."));

	}

	@When("User dont enter email address into email address field")
	public void user_dont_enter_email_address_into_email_address_field() {
		driver.findElement(By.id("input-email")).sendKeys("");

	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		driver.findElement(By.id("input-password")).sendKeys("");

	}

}
