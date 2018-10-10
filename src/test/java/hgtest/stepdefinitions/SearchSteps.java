package hgtest.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import hgtest.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class SearchSteps {
    WebDriver driver;
    LoginPage loginPage;
    String afterSignIn;

    @Given("^User will enter text \"([^\"]*)\"$")
    public void enterSearchText(String text){

    }

    @And("^User will see press enter or click search button$")
    public void userWillSeePressEnterOrClickSearchButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^User will see the list of honey$")
    public void userWillSeeTheListOfHoney() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^User will enter invalid text$")
    public void userWillEnterInvalidText() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^User will press enter or click serach icon$")
    public void userWillPressEnterOrClickSerachIcon() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^User will see the message invalid search$")
    public void userWillSeeTheMessageInvalidSearch() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
