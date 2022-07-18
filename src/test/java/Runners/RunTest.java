package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Login and not @ignore",
        features = "src/test/resources/Features/Login.feature",
        glue = {"StepDef", "Hooks"}
)
public class RunTest extends AbstractTestNGCucumberTests {

}
