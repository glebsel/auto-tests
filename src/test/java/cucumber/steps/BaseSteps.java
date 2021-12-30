package cucumber.steps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Headers;

import static cucumber.utils.RestUtils.createDefaultHeaders;
import static cucumber.utils.RestUtils.httpPost;

public class BaseSteps {
    @When("^Привет$")
    public void hello() throws InterruptedException {
        httpPost("",
                "https://jsonplaceholder.typicode.com/todos/1",
                "",
                createDefaultHeaders());
    }

    @Then("^Проверка \"([^\"]*)\"$")
    public void check(String a) throws InterruptedException {

    }
}
