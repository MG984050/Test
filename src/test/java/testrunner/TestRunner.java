package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "C:\\Users\\a829197\\YouTube\\SDET\\CucumberHybridFramework\\src\\test\\java\\feature",
glue = {"stepDefinitionsNinja","hooks"}, 
dryRun = false)




public class TestRunner {

}
