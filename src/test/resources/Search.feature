Feature: Web Login

  Background:
    Given Browser "chrome" is invoked

  @login
  Scenario Outline: User should be able to search data from Amazon webpage
    Given a user is on Amazon search page
    And I search the amazon application with "<searchText>"
    And I filter with "<Brand>","<Resolution>" and "<Year>"
    And I sort the results
    Then I retrieve the results in report

    Examples:
      | searchText  | Brand | Resolution |  Year |
      | Sony TV     | Sony  | 4K         |  2022 |
#      | Sony TV    | Philips| 1080P      |  2018 |



