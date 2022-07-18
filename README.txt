How to run:
Prerequisities:
    - installed maven
Steps:
    - open terminal in project folder
    - terminal paste cmd: "mvn test"

Setup:
- tags to run are set up in "src/test/java/Runners/RunTest.java" in CucumberOptions(tags)
- chromedriver location in case of update needed "src/test/Drivers"

- "Registration" and "Forgotten Password" scenarios are set to be ignored (not all steps fully implemented)
    -> if @ignore tag is deleted tests will fail in order to show FAILED_TEST reporting and screenshot taken in location
       "src/test/Reports/Screenshots"


