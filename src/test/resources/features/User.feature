Feature: User API

  @AddUser
  Scenario: Test Add User API
    Given Add User Payload
    When user calls "AddUserAPI" with "POST" http request
    Then the API call is successful with status code 200

  @GetUser
  Scenario: Test Get User API
    Given Get User Payload
    When user calls "UserAPI" with "GET" http request
    Then the API call is successful with status code 200

  @UpdateUser
  Scenario: Test Update User API
    Given Update User Payload
    When user calls "UserAPI" with "PUT" http request
    Then the API call is successful with status code 200

  @DeleteUser
  Scenario: Test Delete User API
    Given Delete User Payload
    When user calls "UserAPI" with "DELETE" http request
    Then the API call is successful with status code 200