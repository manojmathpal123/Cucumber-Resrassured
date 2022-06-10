@sanity
Feature: Verify the  Api CRUD Operation request

  Scenario Outline: Verify the post call with data
    Given post call with the "<url>" and payload.
    Then response is "<statuscode>"
    Examples:
      |url|statuscode|
      |/maps/api/place/add/json|200|


  Scenario Outline: Verify the put call with data
    Given put call with the "<url>" and payload.
    Then response is "<statuscode>"
    Examples:
      |url|statuscode|
      |/maps/api/place/update/json|200|



  Scenario Outline: Get all post from api.
    Given get call the "<url>"
    Then response is "<statuscode>"

    Examples:
      |url|statuscode|
      |/maps/api/place/get/json|200|

  Scenario Outline: Verify the delete call with data
    Given delete call with the "<url>".
    Then response is "<statuscode>"
    Examples:
      |url|statuscode|
      |/maps/api/place/delete/json|200|