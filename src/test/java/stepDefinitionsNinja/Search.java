package stepDefinitionsNinja;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;

public class Search {
	WebDriver driver;
	
	@Given("User opens the application")
	public void user_opens_the_application() {
		DriverFactory.getDriver();

	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {
		driver.findElement(By.name("search")).sendKeys(validProductText);

	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
	  
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());

	}

	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String inValidProductText) {
		driver.findElement(By.name("search")).sendKeys(inValidProductText);

	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
	Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());

	}

	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		
		// intentionally kept blank 
		

	}

}
