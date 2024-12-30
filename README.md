# JavaSeleniumProject

* Test can be run in the terminal with following command
  * mvn test, mvn clean install or mvn test -Dcucumber=testRunner 
  * Feature file is tagged with various tags e.g. @smoke, @regression. By providing appropriate tag in the **TestRunner** class, we can run only tagged scenarios.

### RUNNING TESTS REMOTELY
* Project is integrated with LambdaTest. In order to run tests in LambdaTest, you have to do followings
  * Provide valid **user.name** and **AccessKey** in the **configuration.properties** file.
  * Turn **testEnvironment** in the **configuration.properties** file to **remote**.

