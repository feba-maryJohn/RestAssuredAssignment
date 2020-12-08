
Feature: RestAssured Script Response Negative Scenario for Future Date

Scenario: Validate response code for negative scenario on passing future date using Assertion
    Given API for foreign exchange 
    When posted with future date Information
    Then validate response status code received
