package com.hcl.bdd.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import com.hcl.bdd.pageobjects.InventoryPage;
import com.hcl.bdd.pageobjects.LoginPage;

import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class InventorySD {
	WebDriver driver;
	LoginPage loginpage;
	InventoryPage inventorypage;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginpage = new LoginPage(driver);
		inventorypage = new InventoryPage(driver);
	}

	@After
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Given("User is already on login page")
	public void userOnLoginPage() {
		loginpage.navigateTo();
	}
	@When("User enters valid username and password")
	public void loginWithCreds() {
		loginpage.enterUsername("standard_user");
		loginpage.enterPassword("secret_sauce");
		loginpage.clickLogin();
	}
	@Then("User is navigated to inventory page")
	public void checkValidLogin() {
		inventorypage.validateLogin();
	}
	@When("User click add to cart button")
	public void clickAddToCart() {
		inventorypage.addAllItemsToCart();
	}
	@Then("Item is added to the cart")
	public void verifyAddToCart() {
	}
	@When("User click on logout button")
	public void user_click_on_logout_button() {
	}
	@Then("User is navigated to login page")
	public void user_is_navigated_to_login_page() {
	}
}
