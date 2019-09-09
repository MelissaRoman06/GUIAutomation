Feature: Buy products
  Scenario: Add to cart from home page
    Given the user goes to home page
    When adds MacBook to cart
    Then success message is shown

  Scenario: Checkout from shopping cart
    Given the user goes to shopping cart page
    When the user presses checkout button
    Then billing details form is shown