
Feature: Validate Product under BestBuy
  
  
  Scenario: Verify a product can be added, updated , retrived and deleted successfully
    Given Add product payload is provided	
    When User calls Add product API using POST call
    Then Verify Product with id pdtid is added
    And Verify url is proper

 	