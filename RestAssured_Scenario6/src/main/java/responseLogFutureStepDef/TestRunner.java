package responseLogFutureStepDef;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features" ,glue = {"responseLogFutureStepDef"})
public class TestRunner extends ResponseLogFuture{
}
