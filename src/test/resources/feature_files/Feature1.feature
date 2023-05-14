@Regression
Feature: Search product
  Rule: Search from store

    @smoke
    Scenario Outline: Search product from store
      Given I_am on the Store Page
      When I search "<Product>"
      Then I can see the "<Product>"

      Examples:
        |product|
        |Anchor Bracelet|
        |Basic Blue Jeans|

  Rule: Search from Section (Men/Women)
    Scenario Outline: Search product from section
      Given I am on the "<Section>"
      |Men|
      When I search "<Product>"
      Then I can see the "<Product>"

      Examples:
      |product|
      |Anchor Bracelet|
      |Basic Blue Jeans|
