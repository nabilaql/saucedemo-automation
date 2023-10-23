Feature: Logout
  @Positive
  Scenario Outline: Ensure user succesfully logout
    Given I Open Browser
    And Open the login page of saucedemo
    And Located on saucedemo
    When I enter valid username
    And I enter valid password
    And Click Login
    And Click menu button
    And Click logout
    Then verify logout successfully