package com.hcl.bdd.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	By usernameField = By.id("user-name");
	By passwordField = By.id("password");
	By loginButton = By.id("login-button");
	By errorMsg = By.xpath("//h3[@data-test='error']");
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void navigateTo() {
		driver.get("https://www.saucedemo.com/");
	}
	public void enterUsername(String user) {
		driver.findElement(usernameField).sendKeys(user);
	}
	public void enterPassword(String pass) {
		driver.findElement(passwordField).sendKeys(pass);
	}
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	public void validateErrorMessage() {
		Assert.assertTrue(driver.findElements(errorMsg).size() != 0);
	}
}
