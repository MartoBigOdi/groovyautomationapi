package Runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/APITest.feature",
    glue = "Steps"
)


public class Runner {
    
}
