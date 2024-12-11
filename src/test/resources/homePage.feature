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
