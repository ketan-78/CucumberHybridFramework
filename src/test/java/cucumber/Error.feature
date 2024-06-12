
@tag
Feature: Error Message
  I want to use this template for my feature file

  @Error
  Scenario Outline: Negative Test
    Given I landed on the E-commerce pagee
    When I try to login with username <name> and password <password>
    Then "Incorrect email or password." message is displayed
    But Test failed
    
    Examples: 
      | name             | password |
      | ketan@gmaill.com | C_12345  |
    
