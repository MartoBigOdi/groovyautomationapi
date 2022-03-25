package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.util.List;

//Statics
import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;


//No olvidar de colocar para Cucumber ^ al principio del Step y $ al final.
// Con esto le decimos a Cucumber (\\d+) que vamos a colocar un valor integer ahí.

public class APISteps {

    //Para tener una instancia sola de request.
    private static RequestSpecification request;
    private static Response response;
    private ValidatableResponse json;

    /*
    * Mandamos el argumento desde el Gherkin.
    * (.+)
     */
    @Given("^I send a GET request to the (.+) URI$")
    public void sendGETRequest(String URI){
       System.out.println("Marto Reutilizando Steps");
        request = given()
                .baseUri(URI)
                .contentType(ContentType.JSON);

    }

    @Then("^I get a (\\d+) status code$") //Empezamos la próxima clase con rest assured ya.
    public void expectedStatusCode(int expectedStatusCode){
         response = request
                            .when()
                            .get("/users/TheFreeRangeTester/repos");

                    json = response
                                    .then()
                                    .statusCode(expectedStatusCode);
    }

    /*
    *Siempre respetar el orden de como estan los argumentos en el Feature para luego indicar de mismo
    * orden en el Step.
     */
    @Then("^I validate there are (\\d+) items on the (.+) endpoint$")
    public void validateSize(int expectedSize, String endpoint){
        System.out.println("Marto Validando el contenido de una response con un expected size dado por el Feature");
            response = request
                    .when()
                    .get(endpoint);

                    //Creamos una lista con la respuesta, el "$" le dice ingreso completo el contenido de la response.
                    List<String> jsonResponse = response.jsonPath().getList("$");
                    int actualSizeList = jsonResponse.size();
                    //Validamos con un assert el expected size que traemos desde el feature y el int del size de la List.
                    assertEquals(expectedSize, actualSizeList);
    }


    @Then("^I validate there is a value: (.+) in the response at (.+) endpoint$")
    public void validateValue(String expectedValue, String endpoint){
        System.out.println("Marto Validando el contenido de una response con un expected String dentro de una List");
            response = request
                    .when()
                    .get(endpoint);

        List<String> jsonResponse = response.jsonPath().getList("username");//Tomamos los username para llenar la List.
        //Mejoramos el mensaje de salida del Assert en caso de que no este el valor esperado.
        assertTrue(jsonResponse.contains(expectedValue), "El valor "+ expectedValue + " no coincide.");

    }

}
