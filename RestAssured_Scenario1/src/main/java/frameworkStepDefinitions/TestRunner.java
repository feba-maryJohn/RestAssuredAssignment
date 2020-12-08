package frameworkStepDefinitions;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",glue = {"frameworkStepDefinitions"})
public class TestRunner extends ForeignExchange{
}
