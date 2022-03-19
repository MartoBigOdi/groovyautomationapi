package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src\test\resources\features", 
    glue = "Steps"
)


public class Runner {
    
}
