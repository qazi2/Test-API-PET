package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        // specifies the path to the feature file to run
        features = "src/test/java/feature",
        // Location of step defination and it's part of cucumber options
        glue = {"Stepdefinations"},
        // report output
        plugin = { "pretty" ,"html:target/Test_report/report.html"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}


