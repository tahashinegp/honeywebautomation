package hgtest.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hgtest.pages.LoginPage;
import hgtest.utils.AppConfig;
import hgtest.utils.HelperClass;
import hgtest.utils.PageGenerator;
import hgtest.utils.ScenarioContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = { AppConfig.class })
public class BackgroundStepDef  {
    WebDriver driver;
    String afterSignIn;
    WebElement element;
    @Autowired
    HelperClass helperClass;
    @Autowired
    //private ApplicationContext applicationContext;
    LoginPage loginPage;
    ScenarioContext scenarioContext;

    public ScenarioContext getScenarioContext() {
        scenarioContext=  helperClass.getScenarioContext();
        return scenarioContext;
    }


    @Given("^User navigate to the login page$")
    public void userNavigateToTheLoginPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver=helperClass.initializeDriver();
        loginPage= PageGenerator.GetInstance(LoginPage.class,driver);
    }

    @When("^User submit username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userSubmitUsernameAndPassword(String username, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      loginPage.enterUserName(username);
      loginPage.enterPassword(password);
    }

    @Then("^User will click Sign In button$")
    public void userWillClickSignInButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enterSignIn();
        Thread.sleep(3000);
        if (loginPage.loginErrorelement.isDisplayed()==true){
            helperClass.quitDriver();
            System.out.println("Log In Failed");
        }


    }

    @And("^User will see Account menu$")
    public void userWillSeeAccountMenu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        afterSignIn=loginPage.verifylinkText();

    }


}
