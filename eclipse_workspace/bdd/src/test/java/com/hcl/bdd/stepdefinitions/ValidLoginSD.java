package com.hcl.bdd.stepdefinitions;

import com.hcl.bdd.pageobjects.InventoryPage;
import com.hcl.bdd.pageobjects.LoginPage;
import com.hcl.bdd.sharedcontext.SeleniumContext;

import io.cucumber.java.en.*;

public class ValidLoginSD {
	SeleniumContext context;
	LoginPage loginpage;
	InventoryPage inventorypage;
	public ValidLoginSD(SeleniumContext context) {
		this.context = context;
	}

	@Given("user is on login page")
	public void userOnLogin() {
		loginpage = new LoginPage(context.driver);
		inventorypage = new InventoryPage(context.driver);
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
	}
	@When("user enter locked out {string} and {string}")
	public void enterLockedCredentials(String username, String password) {
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
	}
	@Then("user should see error message")
	public void errorMessage() {
		loginpage.validateErrorMessage();
	}
}
