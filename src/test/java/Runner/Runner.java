package Runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/APITest.feature, src/test/resources/features/BraveNewCoin.feature",
    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports.json"},
    tags = "@APISimple, @BraveNewCoin",
    glue = "Steps"
)


public class Runner {
    
}
