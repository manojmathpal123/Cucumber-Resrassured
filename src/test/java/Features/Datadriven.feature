@ignore
Feature: Verify the datadriven feature



  Scenario Outline: Validate the login functionality with outline.
    Given user has a login page with url.
    When user enter the credential with "<username>" and "<password>".
    Then Successfully login in the application.

    Examples:
    |username|password|
    |standard_user|secret_sauce|
    | locked_out_user|secret_sauce|
    |problem_user|secret_sauce|
    |performance_glitch_user|secret_sauce|

