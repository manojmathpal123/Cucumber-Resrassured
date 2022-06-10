@Prod
Feature: Login Action with parameter

  Background:
    Given User is on Home Page

  Scenario: Successful Login with Valid Credentials and parameter 1.

    When User enters "standard_user" and "secret_sauce"
    Then Message displayed Login Successfully
    And Select the item.
    And click on Add to cart icon.
    And Click on checkout icon.
    Then Checkout the item.
    And Enter the "Rohit","Joshi" and "201303".
    And Click on Continue.
    And Validate the details.
    And Click on Finish button.
    And Verify the order dispatch message.
    And Click on Back home button.
    And close the browser.

  Scenario: Successful Login with Valid Credentials and parameter 2.

    When User enters "standard_user" and "secret_sauce1"
    Then Message displayed Login Successfully
    And Select the item.
    And click on Add to cart icon.
    And Click on checkout icon.
    Then Checkout the item.
    And Enter the "Rohit","Joshi" and "201303".
    And Click on Continue.
    And Validate the details.
    And Click on Finish button.
    And Verify the order dispatch message.
    And Click on Back home button.
    And close the browser.









