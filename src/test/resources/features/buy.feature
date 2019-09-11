Feature: Buy products
  Scenario: Add to cart from home page
    When the user goes to home page
    And the user adds an available product to cart
    Then a success message is shown
    And the product is shown on shopping cart page

  Scenario: Checkout from shopping cart
    Given there is a product on shopping cart
    When the user goes to shopping cart page
    And the user presses checkout button
    Then billing details form is shown
