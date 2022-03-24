package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;


//No olvidar de colocar para Cucumber ^ al principio del Step y $ al final
// Con esto le decimos a Cucumber (\d+) que vamos a colocar un valor integer ahí

public class APISteps {

    private static RequestSpecification request;

    @Given("^I send a GET request to the endpoint$")
    public void sendGETRequest(){
       System.out.println("Marto");
        request = given().baseUri("https://api.github.com").contentType(ContentType.JSON);

    }

    @Then("^I get a (\\d+) status code$") //Empezamos la próxima clase con rest assured ya
    public void expectedStatusCode(int expectedStatusCode){
        Response response = request
                .when()
                .get("/users/TheFreeRangeTester/repos");

        ValidatableResponse json = response.then().statusCode(expectedStatusCode);
    }
}
