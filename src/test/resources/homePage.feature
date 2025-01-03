Feature: Navigation and Interaction Tests

  Background:
    Given they are on Home page

 @smoke
  Scenario Outline: Home page title can be seen
    When they click on "<link>"
    Then they can see "<header>" as expected
    Examples:
      | link             | header               |
      | Dropdown         | Dropdown List        |
      | Checkboxes       | Checkboxes           |
      | Context Menu     | Context Menu         |
      | Frames           | Frames               |
      | Hovers           | Hovers               |
      | Multiple Windows | Opening a new window |
      | Drag and Drop    | Drag and Drop        |

  @test
  Scenario: correct Checkbox is clicked in the Checkboxes page
    When they click on "Checkboxes"
    Then first checkbox is clicked

  @regression
  Scenario: user able to click on alert in the Context menu
    When they click on "Context Menu"
    And they can see Alert
    Then they can click on the Alert

  @regression
  Scenario: user cam click on correct option in the Dropdown page
    When they click on "Dropdown"
    Then they can select correct option

  @regression
  Scenario: user can move to one to another Frame
    When they click on "Frames"
    Then they can see correct text in the Frame
    And the can move back to main frame

  @regression
  Scenario: user can see correct text on the Hover page
    When they click on "Hovers"
    Then they can see "0" as "user1"

  @regression
  Scenario: user can see the correct windows
    When they click on "Multiple Windows"
    Then they click on the Main window to move to child window
    And they can return return back to main window

  @regression
  Scenario: user can drag and drop image
    When they click on "Drag and Drop"
    And they drag and drop image "a" to image "b"
    Then they can see images correctly moved
