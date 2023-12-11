Feature: Test Automation Rest API

  @api
  Scenario: Test Get List Data
    Given prepare valid url "GET_LIST_USER"
    And hit API to get list data
    Then verification status code must be 200
    Then verification data should not be null
    Then validate response JSON with JSONSchema "get_list_users_normal.json"

  #@api
  #Scenario: Test Get List Data Specific
   # Given prepare valid url "GET_LIST_USER_SPECIFIC"
    #And hit API to get list data
    #Then verification status code must be 200
    #Then verification data for specific user should not be null
    #Then validate response JSON with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Create a new User
    Given prepare valid url "CREATE_NEW_USER"
    And input bearer token
    And select RAW on menu body
    And select JSON
    And hit API to post create user
    Then verification status code must be 201
    Then validate response body to post new user
    Then validate response JSON with JSONSchema "post_create_new_user.json"

  @api
  Scenario: Delete User Data
    Given prepare valid url "CREATE_NEW_USER"
    And hit API to post create user
    Then verification status code must be 201
    Then validate response body to post new user
    And input bearer token
    And select RAW on menu body
    And select JSON
    And hit API to delete user
    Then verification status code must be 204

  @api
  Scenario: Update user data
    Given prepare valid url "CREATE_NEW_USER"
    And hit API to post create user
    Then verification status code must be 201
    Then validate response body to post new user
    And input bearer token
    And select RAW on menu body
    And select JSON
    And hit API to update data
    Then verification status code must be 200
    Then validate response body to update user

    #This is the negative test scenario
  @api
  Scenario: Wrong Endpoint Test Get List Data
    Given prepare valid url "GET_LIST_USERS"
    And hit API to get list data
    Then verification status code must be 200
    Then verification data should not be null
    Then validate response JSON with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: No Endpoint Create a new User
    Given prepare valid url ""
    And input bearer token
    And select RAW on menu body
    And select JSON
    And hit API to post create user
    Then verification status code must be 201
    Then validate response body to post new user
    Then validate response JSON with JSONSchema "post_create_new_user.json"

  @api
  Scenario: Wrong Status Code Delete User Data
    Given prepare valid url "CREATE_NEW_USER"
    And hit API to post create user
    Then verification status code must be 201
    Then validate response body to post new user
    And input bearer token
    And select RAW on menu body
    And select JSON
    And hit API to delete user
    Then verification status code must be 201

  @api
  Scenario: Wrong Status Code Update user data
    Given prepare valid url "CREATE_NEW_USER"
    And hit API to post create user
    Then verification status code must be 201
    Then validate response body to post new user
    And input bearer token
    And select RAW on menu body
    And select JSON
    And hit API to update data
    Then verification status code must be 201
    Then validate response body to update user