package Steps;

import io.cucumber.java.en.*;
//No olvidar de colocar para Cucumber ^ al principio del Step y $ al final
// Con esto le decimos a Cucumber (\d+) que vamos a colocar un valor integer ahí

public class APISteps {

    @Given("^I send a GET request to the endpoint$")
    public void sendGETRequest(){

        System.out.println("Hola Marto");
    }

    @Then("^I get a list of (\\d+) users$") //Empezamos la próxima clase con rest assured ya
    public void validateListOfUser(int expectedUserSize){

    }
}
