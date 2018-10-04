package hgtest.runner;

import cucumber.api.testng.CucumberExceptionWrapper;
import cucumber.api.testng.CucumberFeatureWrapperImpl;
import cucumber.api.testng.FeatureResultListener;
import cucumber.api.testng.TestNgReporter;
import cucumber.runtime.*;
import cucumber.runtime.Runtime;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.model.CucumberFeature;
import gherkin.formatter.Formatter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomCucumberRunner {
    private Runtime runtime;
    private RuntimeOptions runtimeOptions;
    private ResourceLoader resourceLoader;
    private FeatureResultListener resultListener;
    private ClassLoader classLoader;

    public CustomCucumberRunner(Class clazz) {
        this.classLoader = clazz.getClassLoader();
        this.resourceLoader = new MultiLoader(this.classLoader);
        RuntimeOptionsFactory runtimeOptionsFactory = new RuntimeOptionsFactory(clazz);
        this.runtimeOptions = runtimeOptionsFactory.create();
        new TestNgReporter(System.out);
        ClassFinder classFinder = new ResourceLoaderClassFinder(this.resourceLoader, this.classLoader);
        this.resultListener = new FeatureResultListener(this.runtimeOptions.reporter(this.classLoader), this.runtimeOptions.isStrict());
        this.runtime = new Runtime(this.resourceLoader, classFinder, this.classLoader, this.runtimeOptions);
    }

    public void runCukes() {
        Iterator var1 = this.getFeatures().iterator();

        while(var1.hasNext()) {
            CucumberFeature cucumberFeature = (CucumberFeature)var1.next();
            cucumberFeature.run(this.runtimeOptions.formatter(this.classLoader), this.resultListener, this.runtime);
        }

        this.finish();
        if (!this.resultListener.isPassed()) {
            throw new CucumberException(this.resultListener.getFirstError());
        }
    }

    public void runCucumber(CucumberFeature cucumberFeature) {
        this.resultListener.startFeature();
        cucumberFeature.run(this.runtimeOptions.formatter(this.classLoader), this.resultListener, this.runtime);
        if (!this.resultListener.isPassed()) {
            throw new CucumberException(this.resultListener.getFirstError());
        }
    }

    public void finish() {
        Formatter formatter = this.runtimeOptions.formatter(this.classLoader);
        formatter.done();
        formatter.close();
        this.runtime.printSummary();
    }

    public List<CucumberFeature> getFeatures() {
        return this.runtimeOptions.cucumberFeatures(this.resourceLoader);
    }

    public Object[][] provideFeatures() {
        try {
            List<CucumberFeature> features = this.getFeatures();
            List<Object[]> featuresList = new ArrayList(features.size());
            Iterator var3 = features.iterator();

            while(var3.hasNext()) {
                CucumberFeature feature = (CucumberFeature)var3.next();
                featuresList.add(new Object[]{new CucumberFeatureWrapperImpl(feature)});
            }

            return (Object[][])featuresList.toArray(new Object[0][]);
        } catch (CucumberException var5) {
            return new Object[][]{{new CucumberExceptionWrapper(var5)}};
        }
    }
}
