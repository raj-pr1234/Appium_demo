@SmsSendTest
Feature: Test the Sms functionality on OS Api

  Background: User on Api demos home page
    When user tap on os Api
    Then user tap on sms messaging button

  Scenario Outline: Verify the sms functionality to send the sms successfully
    When user enable the checkbox
    Then user select the name of recipient <recipient_name>
    And user fill the sms content with <sms_content>
    And user send the sms
    Then user verify the status of message <status>

    Examples: 
      | recipient_name | sms_content | status          |
      | "Null"         | "Raj Kumar" | "Message sent!" |

  Scenario Outline: Verify the sms functionality that sms is not send
    When user enable the checkbox
    Then user enter the invalid recipient name as <recipient>
    And user enter the sms content like as <content>
    Then user tap on submit button
    Then user check the status with <invalid_status>

    Examples: 
      | recipient | content     |  invalid_status    |
      | "Raj"     | "Hey babes" | "Error: Null PDU." |
