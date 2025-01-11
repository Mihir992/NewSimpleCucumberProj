@placeOrder
Feature: Place order feature Test

  @test-2
  Scenario Outline: User should be able to successfully place order as  a user
    Given User go to the Home page
    When User enters valid username and password and clicks login button
    And User click on the add to cart button
    And User go to the shipping cart page
    And User click on checkout button
    And User selects <country> as the country
    And User click on place order button to place the order
    Then Verify that the order place "<msg>" is displayed
    Examples:
      | country   | msg                     |
      | "India"   | THANKYOU FOR THE ORDER. |
