package negativeAssertFutureStepDef;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features" , glue = {"negativeAssertFutureStepDef"})
public class TestRunner extends NegAssertFuture{
}
