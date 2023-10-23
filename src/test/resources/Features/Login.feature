Feature: Login
  @Positive
  Scenario: Logging in with valid credentials
    Given I Open Browser
    And Open the login page of saucedemo
    And Located on saucedemo
    When I enter valid username
    And I enter valid password
    And Click Login
    Then Redirected to homepage

  @Negative
  Scenario: Logging in with null password
    Given I Open Browser
    And Open the login page of saucedemo
    And Located on saucedemo
    When I enter valid username
    And Click Login
    And I enter null password
    Then verify user failed login