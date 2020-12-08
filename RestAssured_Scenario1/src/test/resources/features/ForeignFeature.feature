
Feature: To test the response code from API

Scenario: Check for response code
    Given API for foreign exchange 
    When posted with correct Information
    Then validate positive response code received

  