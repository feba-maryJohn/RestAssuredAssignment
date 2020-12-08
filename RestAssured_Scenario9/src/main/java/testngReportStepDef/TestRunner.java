package testngReportStepDef;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features" , glue = {"testngReportStepDef"})
public class TestRunner extends ReportGenerate{
}
