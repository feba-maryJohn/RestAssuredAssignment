package annotationStepDef;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features" , glue ={"annotationStepDef"})
public class TestRunner extends ParameterProvider{
}
