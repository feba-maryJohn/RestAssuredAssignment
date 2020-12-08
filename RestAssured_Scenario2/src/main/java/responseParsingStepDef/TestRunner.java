package responseParsingStepDef;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features" ,glue = {"responseParsingStepDef"})
public class TestRunner extends ResponseParse{
}
