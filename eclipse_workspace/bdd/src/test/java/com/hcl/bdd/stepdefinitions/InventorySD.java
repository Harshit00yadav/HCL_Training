package com.hcl.bdd.stepdefinitions;

import com.hcl.bdd.pageobjects.InventoryPage;
import com.hcl.bdd.pageobjects.LoginPage;
import com.hcl.bdd.sharedcontext.SeleniumContext;

import io.cucumber.java.en.*;

public class InventorySD {
	SeleniumContext context;
	LoginPage loginpage;
	InventoryPage inventorypage;

	public InventorySD(SeleniumContext context) {
		this.context = context;
	}

	@Given("User is already on login page")
	public void userOnLoginPage() {
		loginpage = new LoginPage(context.driver);
		inventorypage = new InventoryPage(context.driver);
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
