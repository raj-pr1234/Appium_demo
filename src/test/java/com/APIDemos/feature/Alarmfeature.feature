@AlarmTest
Feature: user test the Alarm functionalities

  Background: user in home on  api demos
    When user tap on App
    Then user tap on Alarm

  Scenario: user verify the Alarm controller functions
    When user tap on alarm controller
    Then user verifies that buttons is clickable or not

  Scenario: user verify the Alarm service Functions
    When user tap on alarm service
    Then user verifies that service buttons is working or not
