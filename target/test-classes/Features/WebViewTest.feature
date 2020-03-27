#Author: mohitjangra07@gmail.com
@tag
Feature: I want to search Wikipedia

  Scenario Outline: Go to Wikipedia Homepage and search for <searchValue>
    Given I launched the Wikipedia Homepage
    When I enter <searchValue> in HomePage search box
    And I click the search button
    Then I land on the page with heading <searchValue>
    And I see the page title as <title>

    Examples: 
      | searchValue      | title                        |
      | Publicis Sapient | Publicis Sapient - Wikipedia |
      | Publicis         | Publicis - Wikipedia         |

  Scenario: Go to Publicis wikipage and verify the ISIN number
    Given I launched the Wikipedia Homepage
    When I enter "Publicis" in HomePage search box
    And I click the search button
    Then I verify the ISIN number as FR0000130577