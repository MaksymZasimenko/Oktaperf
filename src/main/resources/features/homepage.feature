Feature: Homepage

  Scenario: Sign in with user name and password positive scenario
    Given I navigate to Octoperf homepage
    Then I validate current page
    Then I should see sign in logo
    Then I enter "zasimenkomax@yahoo.com" in the "Email" input box
    Then I enter "Test123" in the "Password" input box
    Then I should see a "sign in" button
    Then I click on "sign in" button

  Scenario: Sign in with user name and password negative scenario
    Given I navigate to Octoperf homepage
    Then I validate current page
    Then I should see sign in logo
    Then I enter "zasimenkomax@yahoo.com" in the "Email" input box
    Then I enter "Test1234" in the "Password" input box
    Then I should see a "sign in" button
    Then I click on "sign in" button
    Then I should see log in failed message