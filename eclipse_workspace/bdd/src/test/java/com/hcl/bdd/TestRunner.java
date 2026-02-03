package com.hcl.bdd;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = "",
		features = "src/test/resources/features",
		glue = {
				"com.hcl.bdd.stepdefinitions",
				"com.hcl.bdd.hooks"
		},
		monochrome = true,
		plugin = {
				"pretty",
				"html:target/HtmlReports/Report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
