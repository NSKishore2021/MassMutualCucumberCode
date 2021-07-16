package Runners;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Features/"},
		glue = {"StepDefinitions"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty", "html:/target/cucumber", 
				  "json:/target/cucumber.json", "html:/target/cucumber-html-report"}
				 // "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}
		)
public class MainRunner extends AbstractTestNGCucumberTests {

}

