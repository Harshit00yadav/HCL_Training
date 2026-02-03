package com.hcl.bdd.hooks;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import com.hcl.bdd.sharedcontext.SeleniumContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class SeleniumHook {
	SeleniumContext context;
	public SeleniumHook(SeleniumContext context) {
		this.context = context;
	}
	@Before
	public void seleniumSetup(Scenario scenario) {
		this.context.driver = new ChromeDriver();
		this.context.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		scenario.log("Chrome dirver initialized");
	}
	@After
	public void seleniumTeardown(Scenario scenario) {
		if (context.driver != null) {
			context.driver.quit();
			scenario.log("Chrome dirver quited");
		}
	}
}
