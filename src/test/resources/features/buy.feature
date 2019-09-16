Feature: Buy products

  @DeleteFromCart
  Scenario: Add product to cart from home page
    When the user goes to home page
    And the user adds iPhone product to cart
    Then an alert Success: You have added to your shopping cart! is displayed
    Then the product is displayed on cart page

  @CheckLogout
  Scenario: Checkout from shopping cart while the user is logged out
    Given there is a product on shopping cart
    When the user goes to cart page
    And the user checkouts
    Then the checkout options form is shown

  @CheckLogin
  Scenario: Checkout from shopping cart while the user is logged in
    Given there is a product on shopping cart
    When the user goes to cart page
    And the user checkouts
    Then the billing details form is shown

