
Feature: Verify the data with excel sheet.

  Scenario Outline: Validate the user navigate the home page.
    Given user navigate the home page with data.
    When user verify the data with sheetname "<sheetname>" and rownumber <RowNumber>.
    Then user click on login button.
    Then it will show the successfull message.
Examples:

    |sheetname|RowNumber|
    |demo|0|
    |demo|1|
    |demo|2|

