package com.hcl.bdd.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InventoryPage {
	WebDriver driver;
	By logoutbtn = By.id("logout_sidebar_link");
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}
	public void validateLogin() {
		Assert.assertTrue(driver.findElements(logoutbtn).size() == 1);
	}
}
