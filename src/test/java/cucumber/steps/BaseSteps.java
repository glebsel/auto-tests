package cucumber.steps;
import cucumber.api.java.en.When;

public class BaseSteps {
    @When("^Привет$")
    public void hello() throws InterruptedException {
        Thread.sleep(100);
    }
}
