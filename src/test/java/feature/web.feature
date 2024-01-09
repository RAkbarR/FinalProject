Feature: Test Automation Web Selenium

  #Positive Login Test
  @web
  Scenario: Test Web Login
    Given User is on login page
    And User input username "Admin"
    And User Input Password "admin123"
    And User press button Login
    Then user can see validation on side nav

  #Negative Login Test
  @web
  Scenario: Negative Test Web Login
    Given User is on login page
    And User input username "min"
    And User Input Password "admin123"
    And User press button Login
    Then user can see info text err "Invalid credentials"

  #positive admin search by username
  @web
  Scenario: Test Search Admin Username
    Given User is on login page
    And User input username "Admin"
    And User Input Password "admin123"
    And User press button Login
    Then user can see validation on side nav
    And user click admin toogle menu
    And user input admin username "Admin"
    And user press search button
    Then user will see admin records

     #negative admin search by username (wrong username)
  @web
  Scenario: Negative Test Search Admin Username
    Given User is on login page
    And User input username "Admin"
    And User Input Password "admin123"
    And User press button Login
    Then user can see validation on side nav
    And user click admin toogle menu
    And user input admin username "Adi"
    And user press search button
    Then user will see no records

    #admin update name
  @web
  Scenario: Test Update Admin Name
    Given User is on login page
    And User input username "Admin"
    And User Input Password "admin123"
    And User press button Login
    Then user can see validation on side nav
    And user click admin toogle menu
    And user click icon update admin
    And user change admin name "Peter Mac Anderson"
    Then user click submit admin update

     #negative admin update name
  @web
  Scenario: Negative Test Update Admin Name
    Given User is on login page
    And User input username "Admin"
    And User Input Password "admin123"
    And User press button Login
    Then user can see validation on side nav
    And user click admin toogle menu
    And user click icon update admin
    And user change admin name ""
    Then user click submit admin update