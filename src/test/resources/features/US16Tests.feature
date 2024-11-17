Feature: Create an account in EcoMovil
  As a university student
  I want to create my account by registering
  To enter the application

  Scenario: Successful registration with valid data
    Given The user is on the registration page (frontend)
    When Enters his full name "María Pérez"
    And Enters a valid email "maria@example.com"
    And Creates a valid password "password123"
    And Confirms the password "password123"
    And Accepts the terms and conditions
    And Presses the "Register" button
    Then The system sends a POST request to "/api/auth/register" with the user data (backend)
    And The server responds with a 201 code and a "Registration successful" message
    And The confirmation message is displayed on the registration page (frontend)

  Scenario: Failed registration by existing email
    Given The user is on the registration page (frontend)
    When Enters an existing email "maria@example.com"
    And Fills out the other fields correctly
    And Presses the "Register" button
    Then The system sends a POST request to "/api/auth/register" (backend)
    And The server responds with a 409 code and a message "Email is already registered"
    And The error message is displayed on the registration page (frontend)

  Scenario: Password Validation
    Given The user is on the registration page (frontend)
    When He enters a password "123"
    And Fills out the other fields correctly
    And Presses the "Register" button
    Then The system displays an error message "Password must be at least 6 characters" (frontend)

    When He enters a password "password123"
    And Enters a password confirmation "password456"
    And Fills out the other fields correctly
    And Presses the "Register" button
    Then The system displays an error message "Passwords do not match" (frontend)