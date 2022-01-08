Feature: SQM2122T06-20, SQM2122T06-21, SQM2122T06-22
  Description: As a user I want to view my cart

  Background:
    Given the saucedemo.com is opened
    And a valid user logs in
    And a user adds an item to the cart
    And a user clicks the cart

  Scenario: A user wants to continue shopping
    When a user clicks continue shopping
    Then the inventory page is shown

  Scenario: A user wants to remove an item from their cart
    When a user tries to remove an item
    Then the item is removed from the cart page

  Scenario: A user wants to continue with their order
    When a user clicks checkout
    Then the checkout page is shown

