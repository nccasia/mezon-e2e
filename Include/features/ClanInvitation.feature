@ClanInvitation
Feature: Clan Invitation
  As a user, I want to invite other users to join my clan so that we can play together

  Scenario Outline: Invite user to join clan
    Given I am logged in with "<email>" and "<password>"
    Then I should see the clan "<clanName>" in my clan list
    When I select the clan "<clanName>"
    And I should natigated to the clan "<clanName>" page
  	
		Examples:
	    | email             | password  | clanName             |
	    | e2euser1@ncc.asia | e2euser1A | CLAN01-1714712323687 |
