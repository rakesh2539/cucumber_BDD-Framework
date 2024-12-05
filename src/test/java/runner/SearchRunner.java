package runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@io.cucumber.testng.CucumberOptions( features = "src\\test\\resources\\FeatureFiles\\Search.feature",
                   glue = {"stepdefinitions","hooks"},
                   plugin = {"pretty", "html:target/cucumber-reports.html"},

                   dryRun = false
		
		
		
		)
@Test
public class SearchRunner extends AbstractTestNGCucumberTests{

}
