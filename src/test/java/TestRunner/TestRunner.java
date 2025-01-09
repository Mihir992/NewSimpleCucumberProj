package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",  // Path to your feature files
        glue = "StepDefinitions",  // Package for your step definitions
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"},// Report formats
        monochrome = true
)
public class TestRunner {
    // This class will run the tests with Cucumber
}