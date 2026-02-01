Feature: Test the inventory features
Background: Login with the valid credentials
Given User is already on login page
When User enters valid username and password
Then User is navigated to inventory page

@smoke
Scenario: Check if items are properly adding to the cart
When User click add to cart button
Then Item is added to the cart

Scenario: Check working of logout button
When User click on logout button
Then User is navigated to login page
