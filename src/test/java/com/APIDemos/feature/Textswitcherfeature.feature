@TextSwitcherTest
Feature: Verify the functionalites of TextSwitcherPage

  Background: user in homePage
    When user verify the view tap
    And user tap on views
    Then user tap on textswitcher tap

  Scenario: user verify the textswitcher functions
    When user tap on next
    Then User get the incremented tap meter
