package Steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

//Import statics para poder utilizar el metodo donde quiera
import java.io.File;

import static io.restassured.RestAssured.given;

public class BraveNewCoinAPISteps {

    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;

    @Given("^I have a valid API Key for the (.+) URI$")
    public void iSetTheRequestParams(String URI){
        request = given()
                .header("X-RapidAPI-Key", "f96cdd1539msh67750a467473abdp17db1djsn851b39d29434")
                .header("X-RapidAPI-Host", "bravenewcoin.p.rapidapi.com")
                .contentType(ContentType.JSON)
                .baseUri(URI)
                .log().all(); //Ver todos los request con esto.
    }

    @When("^I send a POST request with the (.+) payload to the (.+) endpoint$")
    public void sendPOSTRequest(String payload ,String endpoint){
        //Vemos por consola el JSON que hicimos para la requestBody
        System.out.println("{\n" + " \"audience\": \"https://api.bravenewcoin.com\", \n"
                + " \"client_id\": \"oCdQoZoI96ERE9HY3sQ7JmbACfBf55RY\", \n"
                + " \"grant_type\": \"client_credentials\"\n" + "}");

        //Con este objeto de Java creamos un objeto File y le pasamos el path del json que queremos
        File requestBody = new File("src/test/resources/Payloads/"+ payload +".json");
        response = request.when().body(requestBody).post(endpoint)
                          .prettyPeek(); //Esto nos imprime la response
    }

    @Then("^I can validate I receive a valid token in the response$")
    public void validateTheToke(){

    }

}
