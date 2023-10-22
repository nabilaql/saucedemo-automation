Feature: Login
  Scenario: Logging in with valid credentials
    Given I Open Browser
    And Open the login page of saucedemo
    And Located on saucedemo
    When I enter valid username
    And I enter valid password
    And Click Login
    Then Redirected to homepage