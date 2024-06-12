package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber can't run(Feature file) its own, it either needs testNG or Junit, Other than this cucumber
//can provide all other	implementations,framework etc
@CucumberOptions(features="src/test/java/cucumber",glue="Selenium.StepDefination",monochrome=true,
tags="@EndToEnd",plugin= {"html:target/cucumber.html"})
//monochrome: is used to get results in readable format otherwise it is encrypted
//features: is to select the cucumber files
//glue: to run are step definitions
//plug-in: to get the reports
//@tag:it act as a group	
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
