
Feature: To test the response code from API

Scenario: Validate response for script and log it on console
    Given API for foreign exchange 
    When posted with correct Information
    Then validate response and log it on console
