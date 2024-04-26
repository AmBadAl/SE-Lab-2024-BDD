Feature: Calculator Operations

  # Normal Scenarios for basic operations
  Scenario: add two numbers
    Given Two input values, 1 and 2
    When I add the two values
    Then I expect the result 3

  Scenario: multiply two numbers
    Given Two input values, 1 and 2
    When I multiply the two values
    Then I expect the result 2

  Scenario: divide two numbers
    Given Two input values, 2 and 1
    When I divide the two values
    Then I expect the result 2

  Scenario: power two numbers
    Given Two input values, 2 and 3
    When I power the two values
    Then I expect the result 8

  # Scenario Outline for variable operations
  Scenario Outline: perform arithmetic operations with different data
    Given Two input values, <first> and <second>
    And I have selected the operation <opt>
    When I perform the operation
    Then I expect the result <result>

    Examples:
      | first | second | opt | result |
      | 1     | 12     | +   | 13     |
      | -1    | 6      | +   | 5      |
      | 2     | 2      | +   | 4      |
      | 6     | 2      | *   | 12     |
      | -6     | 2      | *   | -12     |
      | 6     | 2      | /   | 3      |
      | -6     | 2      | /   | -3      |
      | 6     | 2      | ^   | 36     |
