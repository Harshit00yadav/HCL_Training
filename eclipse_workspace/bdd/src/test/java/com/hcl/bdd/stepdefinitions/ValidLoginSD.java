package com.hcl.bdd.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hcl.bdd.pageobjects.InventoryPage;
import com.hcl.bdd.pageobjects.LoginPage;

import io.cucumber.java.en.*;

public class ValidLoginSD {
	WebDriver driver;
	LoginPage loginpage;
	InventoryPage inventorypage;

	@Given("user is on login page")
	public void userOnLogin() {
		this.driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginpage = new LoginPage(driver);
		inventorypage = new InventoryPage(driver);
		loginpage.navigateTo();
	}
	@When("user enter valid {string} and {string}")
	public void enterCredentials(String username, String password) {
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
	}
	@And("click on login button")
	public void userClickLoginButton() {
		loginpage.clickLogin();
	}
	@Then("user is navigated to the inventory page")
	public void isOnInventoryPage() {
		inventorypage.validateLogin();
		driver.close();
		driver.quit();
	}
	@When("user enter locked out {string} and {string}")
	public void enterLockedCredentials(String username, String password) {
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
	}
	@Then("user should see error message")
	public void errorMessage() {
		loginpage.validateErrorMessage();
		driver.close();
		driver.quit();
	}
}
