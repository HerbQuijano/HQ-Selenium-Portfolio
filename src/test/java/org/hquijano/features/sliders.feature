Feature: Slider functionality

  @smoke
  Scenario: Set slider to a specific percentage
    Given I am on the sliders page
    When I set the slider to 75 percent
    Then the slider value should be "75"
