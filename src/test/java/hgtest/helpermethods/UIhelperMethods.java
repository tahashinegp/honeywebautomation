package hgtest.helpermethods;


import hgtest.utils.PageGenerator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class UIhelperMethods {
    //common elements for all page
    @FindAll({
            @FindBy(how=How.XPATH,xpath = "//nav[@class='css-177pf01']")
        }
    )

    List<WebElement> elements;
    @FindBy(how=How.XPATH,xpath = "")
    WebElement verifycommonElementText;
    public void clickMenu(String attr,String attrValue){

        PageGenerator.BasePage.cllickMenu(elements,attr,attrValue);

    }

    public String verifyText(String textForVerify,String attr,String attrValue){

        String elementText= PageGenerator.BasePage.verifyText(elements,attr,attrValue,textForVerify);
        return elementText;
    }

    public static void keyboadMouseEvent(WebDriver driver,boolean isKeyboardevent,boolean isMouseevent){
        Actions actions=new Actions(driver);
        Action  mouseorkeyboardaction;
        if(isKeyboardevent==true){
            actions.keyUp(Keys.ENTER).build().perform();
        }


    }
}
