Feature:

  Background:
    Given they are on Home page

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

  Scenario: correct Checkbox is clicked in the Checkboxes page
    When they click on "Checkboxes"
    Then first checkbox is clicked

  Scenario: user able to click on alert in the Context menu
    When they click on "Context Menu"
    And they can see Alert
    Then they can click on the Alert

  Scenario: user cam click on correct option in the Dropdown page
    When they click on "Dropdown"
    Then they can select correct option

  Scenario: user can move to one to another Frame
    When they click on "Frames"
    Then they can see correct text in the Frame
    And the can move back to main frame

  Scenario: user can see correct text on the Hover page
    When they click on "Hovers"
    Then they can see "0" as "user1"

  Scenario: user can see the correct windows
    When they click on "Multiple Windows"
    Then they click on the Main window to move to child window
    And they can return return back to main window


