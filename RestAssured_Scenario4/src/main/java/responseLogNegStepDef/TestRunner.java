package responseLogNegStepDef;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features" , glue = {"responseLogNegStepDef"})
public class TestRunner extends ResponseLogNegative{
}
