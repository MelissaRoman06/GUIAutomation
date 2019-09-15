Feature: Buy products

  @CheckLogin
  Scenario: Add product to cart from home page
    When the user goes to home page
    And the user adds MacBook product to cart
    Then a success alert is shown
    And the product is shown on cart page

  @CheckLogin
  Scenario: Checkout from shopping cart
    Given there is a product on shopping cart
    When the user goes to cart page
    And the user checkouts
    Then the checkout options form is shown

  Scenario: Checkout from shopping cart
    Given there is a product on shopping cart
    When the user goes to cart page
    And the user checkouts
    Then the billing details form is shown

