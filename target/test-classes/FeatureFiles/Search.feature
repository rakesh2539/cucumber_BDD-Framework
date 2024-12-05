Feature: Search Fuctionlaity

  Scenario: Validate Search Functionality  using valid text
    Given user Launch the brwoser and navigate to application url
    When user Enter the valid text in search box
    And user click on the search button
    Then user verify the Autosuggistions are appearing or not
    And user click on the required related suggistion
    And user verify the page is navigating to corrsponding search page or not
