package hgtest.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hgtest.config.BrowserManagerFactory;
import hgtest.config.BrowserType;
import hgtest.pages.LoginPage;
import hgtest.utils.HelperClass;
import hgtest.utils.PageGenerator;
import org.openqa.selenium.WebDriver;

public class BackgroundStepDef {
    WebDriver driver;
    LoginPage loginPage;
    String afterSignIn;
    //HelperClass helper;

    @Given("^User navigate to the login page$")
    public void userNavigateToTheLoginPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver=HelperClass.initializeDriver();
        loginPage=new LoginPage();
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
    }

    @And("^User will see Account menu$")
    public void userWillSeeAccountMenu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        afterSignIn=loginPage.verifylinkText();
    }


}
