
Feature: RestAssured Script Response Logging for Future Date 

  Scenario: Validate response code on passing future date 
    Given API for foreign exchange 
    When posted with correct Information
    Then validate positive response code received
