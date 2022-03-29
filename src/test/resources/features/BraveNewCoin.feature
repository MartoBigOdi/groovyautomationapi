#@BraveNewCoin
Feature:  BraveNewCoin API scenarios: POST GetToken

Rule: When I send a POST request to the endpoint, I receive a token I can use to make further authenticated calls.
  #Puedo enviar respuesta sin "Client Id"? consultar, sino se pasa como defecto.
  @BraveNewCoin
Scenario: As a user, I can retrieve a Token when making a valid POST request.
  Given I have a valid API Key for the https://bravenewcoin.p.rapidapi.com URI
  When I send a POST request with the TokenRequestBody payload to the /oauth/token endpoint
  Then I can validate I receive a valid token in the response


#Scenario: As a user, when i use an invalid API Key, I get an HTTP Code Status 403.
 # Given I have an invalid API Key for the https://bravenewcoin.p.rapidapi.com URI
 # When I send a POST request with the TokenRequestBody payload to the /oauth/token endpoint
 # Then I receive an HTTP Code Status 403

#Scenario: As a user, when I send the POST request without "grant_type", I get an HTTP Code Status 407.
 # Given I have an invalid API Key for the https://bravenewcoin.p.rapidapi.com URI
 # When I send a POST request without "grant_type" in it's body
 # Then I receive an HTTP Code Status 407
