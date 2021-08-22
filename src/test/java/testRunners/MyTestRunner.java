package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //you can run one feature file directly by passing the path to the feature file.
        //e.g. src/test/resources/AppFeatures/AccountsPage.feature --> will run just the accountPage.feature
        features = {"src/test/resources/AppFeatures"},
        glue = {"stepdefinitions", "AppHooks"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"
        }
)
public class MyTestRunner {
}
