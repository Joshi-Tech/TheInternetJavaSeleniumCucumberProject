package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/homePage.feature", // Path to your .feature file
        glue = "steps", // Package containing your step definitions
        plugin = {
                "pretty", // Outputs a readable format to the console
                "html:target/cucumber-reports.html", // HTML report
                "json:target/cucumber-reports/Cucumber.json" // JSON report for integrations like Allure
        }/*,
         monochrome = false,                        // Cleaner console output
        tags = "@test"  */                    // Optional: Run scenarios with specific tags
)
public class TestRunner {
}

