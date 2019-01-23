package hgtest.pages;

import hgtest.helpermethods.UIhelperMethods;
import hgtest.utils.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchPage {

    WebDriver driver;
    @FindBy(how= How.XPATH,xpath = "//input[@class='css-1q7hb7w']")
    WebElement serachTxt;
    @FindAll({
            @FindBy(how=How.XPATH,xpath = "//div[@class='image-gallery-image']/img']")
    }
    )
    List<WebElement> elementList;

    // Search Page constructor
     public  SearchPage(){}
     public SearchPage(WebDriver driver){
        driver=this.driver;
     }
     //enter text in serach text box
     public void enterSearchtext(String enterText){
         PageGenerator.BasePage.writeText(serachTxt,enterText);
     }

     //press enter
      public void pressEnter(){
          UIhelperMethods.keyboadMouseEvent(driver,true,false);
      }

}
