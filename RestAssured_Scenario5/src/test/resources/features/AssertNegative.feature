
Feature: Validation of RestAssured Script for Negative Scenario

  Scenario: Validate response status code for Negative Scenario using Assertion
    Given API for foreign exchange 
    When posted with correct Information
    Then validate response status code received
