Feature: Filter Product Z to A
  @Positive
  Scenario Outline: succesfully filter product Z to A
    Given I Open Browser
    And Open the login page of saucedemo
    And Located on saucedemo
    When I enter valid username
    And I enter valid password
    And Click Login
    When Click filter menu
    And Click Name(Z to A)
    Then verify success filtering

