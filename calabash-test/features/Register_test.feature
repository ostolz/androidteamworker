Feature: Register feature

  Scenario: As a valid user I can log into my app
    When I see "TeamPlanBuch"
    Then I press "Register"
    Then I see "RegisterScreen"
	
    Then I enter text "username" into field with id "reg_username"
    Then I enter text "vorname" into field with id "vorname"
    Then I enter text "nachname" into field with id "nachname"
    Then I enter text "strasse" into field with id "strasse"
    Then I enter text "78166" into field with id "plz"
    Then I enter text "Donaueschingen" into field with id "wohnort"
    Then I enter text "mail" into field with id "dr.alk.prost@hopfen.de"
    Then I enter text "password" into field with id "reg_password"
    Then I enter text "password" into field with id "password_confirm"
	
    Then I press "Submit"
    Then I see "LoginScreen"