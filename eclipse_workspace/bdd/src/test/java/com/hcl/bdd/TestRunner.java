package com.hcl.bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = "",
		features = "src/test/resources/features",
		glue = {"com.hcl.bdd.stepdefinitions"},
		monochrome = true,
		plugin = "html:target/HtmlReports/Report.html"
)
public class TestRunner extends AbstractTestNGCucumberTests{
}
