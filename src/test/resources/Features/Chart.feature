Feature: Chart Functionality
  @Positive
  Scenario: Add Product to the cart
    Given I Open Browser
    And Open the login page of saucedemo
    And Located on saucedemo
    When I enter valid username
    And I enter valid password
    And Click Login
    And add product to cart
    Then see product added to cart