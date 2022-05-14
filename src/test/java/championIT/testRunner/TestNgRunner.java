package championIT.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class TestNgRunner {
	
	@CucumberOptions(

			features = { "Features" }, 
			glue = { "championIT.stepDef" }, 
			plugin = { "pretty" },
			tags= "@test1"
			)
	public class TestRunner extends AbstractTestNGCucumberTests{

	}


}
