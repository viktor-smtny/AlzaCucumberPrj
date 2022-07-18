@Login
Feature: Login

  @validLogin
  Scenario: Valid Login
    Given I am on homepage

    When I click on "HomePage-CookiesPopUp_DenyAllButton"
    And I click on "HomePage-LoginButton"
    And I wait for 1 seconds
    And I fill in valid credentials
    And I click on "LoginPage-SubmitButton"
    And I wait for 3 seconds
    Then I am logged in

  @invalidLogin
  Scenario: Invalid username login
    Given I am on homepage

    When I click on "HomePage-CookiesPopUp_DenyAllButton"
    And I click on "HomePage-LoginButton"
    And I wait for 1 seconds
    And I fill in invalid user
    And I click on "LoginPage-SubmitButton"
    And I wait for 5 seconds
    Then I am not logged in

  @invalidLogin
   Scenario: Invalid password login
     Given I am on homepage

     When I click on "HomePage-CookiesPopUp_DenyAllButton"
     And I click on "HomePage-LoginButton"
     And I wait for 1 seconds
     And I fill in invalid password
     And I click on "LoginPage-SubmitButton"
     And I wait for 5 seconds
     Then I am not logged in

    @forgottenPassword @ignore
    Scenario: Forgotten password link
      Given I am on homepage

      When I click on "HomePage-CookiesPopUp_DenyAllButton"
      And I click on "HomePage-LoginButton"
      And I wait for 1 seconds
      And I click on "LoginPage-ForgottenPasswordLink"
      Then I see text "Zapomenuté heslo" in element "ForgottenPasswordPage-Title"
      And I see element "ForgottenPasswordPage-EmailField" on page

    @registrationPageLink @ignore
    Scenario: New Registration Link
      Given I am on homepage

      When I click on "HomePage-CookiesPopUp_DenyAllButton"
      And I click on "HomePage-LoginButton"
      And I wait for 1 seconds
      And I click on "LoginPage-NewRegistrationLink"
      Then I am on page "RegistrationPage"