Feature: SQM2122T06-14, SQM2122T06-15, SQM2122T06-16
  Description: As a user I want to sort and add items to my cart

Background:
  Given the saucedemo.com is opened
  And a valid user logs in


  Scenario: A user wants to sort products Alphabetically
    When a user sorts products from A to Z
    Then objects should be sorted from A to Z

  Scenario:A user wants to sort products Backwards Alphabetically
    When a user sorts products from Z to A
    Then objects should be sorted from Z to A

  Scenario:A user wants to sort products with prices from High to Low
    When a user sorts products from Price High to Low
    Then objects should be sorted from High To Low Price

  Scenario:A user wants to sort products with prices from Low to High
    When a user sorts products from Price Low to High
    Then objects should be sorted from Low to High Price

  Scenario:A user wants to add an item to their cart
    When a user adds an item to the cart
    Then the item is added to the cart

  Scenario:A user wants to remove an item from their cart
    Given a user adds an item to the cart
    When a user removes an item from the cart
    Then  the item is removed from the cart

  Scenario: A user wants to see their cart
    When a user clicks the cart
    Then the cart page is shown
