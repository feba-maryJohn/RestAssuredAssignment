package responseAssertionStepDef;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features" , glue= {"responseAssertionStepDef"})
public class TestRunner extends ResponseAssert{
}
