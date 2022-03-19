Feature: Ejemplo de Request

@APIs
Scenario: Prueba GET al endpoint.
Given I send a GET request to the endpoint
Then I get a list of 10 users
