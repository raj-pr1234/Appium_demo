@ChronoMeterTest
Feature: verify the chronometer functionalties

  Background: user in home page
    When user checks that views is displayed
    Then user click on views
    When user click on chronometer

  Scenario: check the chronometer start and stop
    Then user start the meter and save the reading and stop the meter
    And user checks that meter is stoped or not

  Scenario: user verify the reset functionality
    When user click on reset button
    And user get the meter value
    Then user verify the meter value

  Scenario: user verify the formating functionality working
    When user click on set format btn
    Then user click on start button
    And user click on stop button and save the meter data
    Then verify the the meter data format

  Scenario Outline: user verify clear format functionality working
    When user tap on the set format button
    And user tap on reset button
    Then user get the meter format and verify with <formated_value>
    When user click on clear format button
    And user click on reset button for clearing format
    Then user get the meter format and verify with clear data <clear_formated_value>

    Examples: 
      | formated_value           | clear_formated_value |
      | "Formatted time (00:00)" | "00:00"              |
