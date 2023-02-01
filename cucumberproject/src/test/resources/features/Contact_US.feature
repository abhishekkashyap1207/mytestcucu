Feature: WebDriver University - contact us Page
  Scenario: validate Sucessful Submit Msg
    Given I access the webdriver contact us page
    When Ienter fairst name
    And i enter last name
    And i enter Email
    And i enter discrebtion
    And i click on submitbutton
    Then I should be presented sucessful msg

  Scenario: Validate Error Message
    Given I access the webdriver contact us page
    When Ienter fairst name
    And i enter last name
    And i enterinvalid Email Id
    And i enter discrebtion
    And i click on submitbutton
    Then I should be presented Error Message