package hgtest.runner;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public abstract class CustomCucumberAbstractTestng {
    private CustomCucumberRunner testNGCucumberRunner;

    public CustomCucumberAbstractTestng() {
    }

    @BeforeClass(
            alwaysRun = true
    )
    public void setUpClass() throws Exception {
        this.testNGCucumberRunner = new CustomCucumberRunner(this.getClass());
    }

    @Test(
            groups = {"cucumber"},
            description = "Runs Cucumber Feature",
            dataProvider = "features"
    )
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        this.testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return this.testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(
            alwaysRun = true
    )
    public void tearDownClass() throws Exception {
        this.testNGCucumberRunner.finish();
    }
}
