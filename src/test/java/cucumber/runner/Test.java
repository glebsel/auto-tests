package cucumber.runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"cucumber/steps"},
        tags = {
                "@Test"
        }
)
public class Test {
}
