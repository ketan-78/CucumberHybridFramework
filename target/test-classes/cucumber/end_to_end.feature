@tag
Feature: Purchase the order from E-commerce website 
  I want to use this template for my feature file

	Background:
	Given I landed on the E-commerce page
	
  @EndToEnd
  Scenario Outline: Positive test of purchasing the order
    Given I logged in with username <name> and password <password>
    When I add product <ProductName1> and <ProductName2> to cart
    And checkout <ProductName1> and <ProductName2> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

    Examples: 
      | name 						 | password  |	ProductName1 	|  ProductName2 	 |
      | ketan@gmaill.com |  Cc_12345 |	IPHONE 13 PRO	|	 ADIDAS ORIGINAL |

