
Feature: Pom Login Action with parameter


  Scenario Outline: Successful Pom Login with Valid Credentials.
    Given Pom User is on login Page
    When user verify the data with sheetname "<sheetname>" and rownumber <RowNumber>.
    Then displayed message Login Successfully
    Then close browsing window.

    Examples:
      |sheetname|RowNumber|
      |demo|0|
      |demo|1|

  Scenario Outline: Successful Pom Login with Valid Credentials.
    Given Pom User is on login Page
    When user verify the data with sheetname "<sheetname>" and rownumber <RowNumber>.
    Then displayed message Login Successfully
    Then close browsing window.

    Examples:
      |sheetname|RowNumber|
      |demo|0|
      |demo|1|