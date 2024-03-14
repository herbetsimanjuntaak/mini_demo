Feature: Test Automation API

  @api
  Scenario: Test get list data normal
    Given prepare url for "GET_LIST_USERS"
    And hit get API get list user
    Then validation status code is equals 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users_normal.json"


