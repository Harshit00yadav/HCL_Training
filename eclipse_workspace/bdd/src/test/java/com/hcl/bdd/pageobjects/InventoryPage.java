package com.hcl.bdd.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InventoryPage {
	WebDriver driver;
	By logoutbtn = By.id("logout_sidebar_link");
	By inventoryItemsBtn = By.xpath("//div[@class='inventory_item']//button");
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}
	public void validateLogin() {
		Assert.assertTrue(driver.findElements(logoutbtn).size() == 1);
	}
	public void addAllItemsToCart() {
		driver.findElements(inventoryItemsBtn).stream().forEach(elem -> elem.click());
	}
}
