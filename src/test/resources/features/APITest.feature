Feature: Ejemplo de Request

@APIs
Scenario: Prueba GET al endpoint.
Given I send a GET request to the endpoint
Then I get a 400 status code
