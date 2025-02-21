@registration
Feature: Let's shop registration feature Test

  @test-1
  Scenario Outline: User should not be able to register with invalid data
    Given User go to the letsshop Home page
    And User navigate to the Registration page
    And User set "<firstName>" and "<lastName>"
    And User set <dynamicEmail> as email
    And User set "<phoneNumber>" as phoneNumber
    And User set "<password>" as password and confirm password again
    And User checked the checkbox
    And User click on the Register button
    Then Verify error message "<msg>" is displayed
    Examples:
      |firstName| lastName | phoneNumber| dynamicEmail |  password    | msg                |
      | Test    | John     | 8000920567 | ""           |  Pass@1234   | *Email is required |

  @test-2
  Scenario Outline: User should be able to register a new account successfully with valid data
    Given User go to the letsshop Home page
    And User navigate to the Registration page
    And User set "<firstName>" and "<lastName>"
    And User set "<dynamicEmail>" as email
    And User set "<phoneNumber>" as phoneNumber
    And User set "<password>" as password and confirm password again
    And User checked the checkbox
    And User click on the Register button
    Then Verify registration success "<msg>" is displayed
    Examples:
      | firstName | lastName | phoneNumber| dynamicEmail       | password    | msg                          |
      | Test      | John     | 8000920567 | test@example.com   | Pass@1234  | Account Created Successfully |
