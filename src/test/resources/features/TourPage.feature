Feature: Coldplay Tour Page Validation

  Scenario: Verify Tour Dates Are Displayed
    Given I navigate to coldplay home page
    When I click on tour page
    Then I should see a list of upcoming tour dates

  Scenario: Verify all the tours are sold out
    Given I navigate to coldplay home page
    When I click on tour page
    Then I should see all the concerts are sold out