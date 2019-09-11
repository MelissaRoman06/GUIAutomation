Feature: Buy products

  @AddToCart
  Scenario: Add product to cart from home page
    When the user goes to home page
    And the user adds MacBook product to cart
    Then a success alert is shown
    And the product is shown on shopping cart page

  Scenario: Add product to cart from home page
    When the user goes to home page
    And the user looks for "MacBook" product
    And the user adds the product to shopping cart
    Then a Success: You have added the product to your shopping cart! alert is shown
    And the product is shown on shopping cart page

  Scenario: Checkout from shopping cart
    Given there is a product on shopping cart
    When the user goes to shopping cart page
    And the user checkouts
    Then billing details form is shown
