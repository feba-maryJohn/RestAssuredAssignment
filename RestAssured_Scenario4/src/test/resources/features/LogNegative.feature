
Feature: Validation of RestAssured Script for Negative Scenario

  Scenario: RestAssured Script for Negative Scenario and log it on console
    Given API for foreign exchange 
    When posted with correct Information
    Then validate positive response code received
