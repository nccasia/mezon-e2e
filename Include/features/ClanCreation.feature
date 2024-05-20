
@ClanCreation
Feature: Clan Creation
  As a user, I want to create a clan so that I switch between my clans and manage them.

  Scenario Outline: Create a clan
    Given I am logged in with "<email>" and "<password>"
    When I create a clan with name "<clanName>"
    Then I should see the clan "<clanName>" in my clan list
    And I should natigated to the clan "<clanName>" page

    Examples:
      | email             | password   | clanName    |
      | e2euser1@ncc.asia | e2euser1A@ | CLAN01-1715934989296 |
