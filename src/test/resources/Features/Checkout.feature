Feature: Product Checkout functionality
  @Positive
  Scenario Outline: User succesfully Checkout product
    Given I Open Browser
    And Open the login page of saucedemo
    And Located on saucedemo
    When I enter valid username
    And I enter valid password
    And Click Login
    When Click product
    And Click shoping cart
    And Click checkout
    And Input firstname
    And Input lastname
    And Input postal code
    And Click continue
    And Click finish
    Then verify success checkout result