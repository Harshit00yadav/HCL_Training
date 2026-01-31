Feature: feature to test login functionality

Scenario Outline: check if login is successful for valid credentials
Given user is on login page
When user enter valid "<username>" and "<password>"
And click on login button
Then user is navigated to the inventory page

Examples:
| username | password |
| standard_user | secret_sauce |
| visual_user | secret_sauce |

Scenario Outline: check if login fails for locked out users
Given user is on login page
When user enter locked out "<username>" and "<password>"
And click on login button
Then user should see error message

Examples:
| username | password |
| locked_out_user | secret_sauce|
