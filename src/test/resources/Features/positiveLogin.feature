Feature: validate the sum of values 

  Scenario: verify the sum of all multiple values
    Given user provided with valid url
    When user provides required label value1
    And user provides required label value2
    And user provides required label value3
    And user provides required label value4
    And user provides required label value5
    Then verify total count of the values with the expected value
