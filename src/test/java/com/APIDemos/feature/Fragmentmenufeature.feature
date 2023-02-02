@FragmentResultsTest
Feature: User Test the menu functionality of Fragment

  Background: user in home of api demos
    Given user tap on app
    When user tap on Fragment

  Scenario Outline: user verify the get corky button
    When user tap on the result
    Then user tap on get result
    And user tap on get corky
    Then user verify that results text with <results_text>

    Examples: 
      |      results_text  |
      | "(okay -1) Corky!" |
