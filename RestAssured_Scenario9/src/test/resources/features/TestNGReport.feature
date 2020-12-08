
Feature: Generation of TestNG Report

  Scenario: Generate TestNG Report for mutiple records
    Given API for foreign exchange 
    When posted with parameterized values
    Then validate multiple records and display report
