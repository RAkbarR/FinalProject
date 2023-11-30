Feature: Test Automation Rest API

  @api
  Scenario: Test Get List Data
    Given prepare valid url "GET_LIST_USER"
    And hit API to get list data
    Then verification status code must be 200
    Then verification data should not be null
    Then validate response JSON with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Test Create User
    Given prepare valid url "CREATE_NEW_USER"
    And hit API to post create user
    Then verification status code must be 201
