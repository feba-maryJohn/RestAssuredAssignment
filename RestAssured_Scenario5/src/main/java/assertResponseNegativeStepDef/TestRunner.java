package assertResponseNegativeStepDef;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features" , glue = {"assertResponseNegativeStepDef"})
public class TestRunner extends ResponseAssertNegative{
}
