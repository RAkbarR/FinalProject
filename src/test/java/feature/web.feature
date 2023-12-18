Feature: Test Automation API

  @web
  Scenario: Test Web Login
    Given User is on login page
    And User input username "Admin"
    And User Input Password "admin123"
    And User press button Login
    Then user can see validation on side nav