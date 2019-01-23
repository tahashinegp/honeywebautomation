package hgtest.utils;

import cucumber.api.Scenario;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@Component
@Scope(scopeName = "scenario")
public class ScenarioContext {

    private Scenario scenario;

    public Scenario getScenario(){

        return scenario;
    }
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
    public String shareMe;
}
