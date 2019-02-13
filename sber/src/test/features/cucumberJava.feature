@all
Feature: Node Manipulation

Background:
    Given Open visjs.org

Scenario: Remove node by int value
    When I select node
    Then I delete it

Scenario: Move node on x,y pixels
    Then I move node on x,y