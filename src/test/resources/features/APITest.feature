Feature: Ejercicios de Request

  @API
Scenario: Prueba GET al endpoint.
  Given I send a GET request to the https://api.github.com URI
  Then I get a 200 status code

  @APISimple
Scenario: Validar la cantidad de entradas en la respuesta.
  Given I send a GET request to the https://jsonplaceholder.typicode.com URI
  Then I validate there are 10 items on the /users endpoint

  @APISimple
Scenario: Validar que un elemento este en la lista de la response
  Given I send a GET request to the https://jsonplaceholder.typicode.com URI
  Then I validate there is a value: Bret in the response at /users endpoint

  @APISimple
Scenario: Validar que un elemento interior de un objecto se encuentra en la lista hecha con la response
    Given I send a GET request to the https://jsonplaceholder.typicode.com URI
    Then I validate there is a value inside the object: Kattie Turnpike in the response at /users endpoint