package hgtest.pages;


import hgtest.utils.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    public WebDriver driver;
    public WebElement element;

    @FindBy(how= How.XPATH,xpath = "//input[@class='css-jgpmay']")
    WebElement userNameTxt;
    @FindBy(how= How.XPATH,xpath = "//input[@class='css-h8v0k']")
    WebElement paswordTxt;
    @FindBy(how= How.XPATH,xpath = "//button[@class='css-1couuec']")
    WebElement signInbutton;
    @FindBy(how=How.XPATH,xpath = "//nav/a")
    WebElement verifylinkText;

    public LoginPage(){

    }
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void enterUserName(String userName){
        PageGenerator.BasePage.writeText(userNameTxt,userName);
    }
    public void enterPassword(String password){

        PageGenerator.BasePage.writeText(paswordTxt,password);
    }
    public void enterSignIn(){

        PageGenerator.BasePage.elementClick(signInbutton);
    }
    public String verifylinkText(){
        String linkText=PageGenerator.BasePage.readText(verifylinkText);
        return linkText;
    }
}
