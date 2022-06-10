@ignore
Feature: Login Action with data table


  Scenario: Successful Login with data table.
    Given login to Home Page
    When entering username and password in the application,
      |usrname|password|
      |standard_user|secret_sauce|
    Then Message showing Login Successfully in the application
    And Item select.
    And Add to cart icon.
    And checkout icon.
    Then Checkout the item which we selected.
    And Entering  all firstname,lastname and pincode in page.
     |firstname|lastname|pincode|
     |Manoj|Mathpal|201303|
     |Rohit|Mathpal|201304|
     |Yogesh|Mathpal|201305|
     |Disha|Mathpal|201306|
    And Continue button click.
    And Verify and validate the details of application.
    And Finish button click.
    And Validate order dispatch message in page.
    And Back home button click.
    And browser closing.