package hgtest.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.testng.*;
import cucumber.runtime.*;
import cucumber.runtime.Runtime;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.model.CucumberFeature;
import gherkin.formatter.Formatter;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@CucumberOptions(
        monochrome = true,
        tags = "@Candidate",
        features = "classpath:features/",
        glue = "hgtest.stepdefinitions" ,
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
        }
)
public class FeatureRunner extends CustomCucumberAbstractTestng{

    /*private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void setUpClass() {
        System.out.println("Cucumber Test Class Before");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @Test(testName = "Feature test",description = "Honeygram cucumber feature")
    public void feature(CucumberFeatureWrapper featureWrapper){
        System.out.println("Cucumber Test Class Inside Test");
        System.out.println(featureWrapper.getCucumberFeature());
        //testNGCucumberRunner.runCucumber(featureWrapper.getCucumberFeature());
        testNGCucumberRunner.runCukes();

    }

    @DataProvider(name="search data")
    public Object[][] getScenariodata() {
        System.out.println("Data Provider test Class");
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }*/


}
