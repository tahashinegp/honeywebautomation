package hgtest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PageGenerator {

    public static WebDriver driver;

    //Constructor
    public PageGenerator(WebDriver driver){
        this.driver = driver;
    }
    @Bean
    public static<TPage> TPage GetInstance(Class<TPage> pageObject,WebDriver driver){
        try {
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(driver,  pageObject);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Inner class to handle webelement dynamically or generically
    public static class BasePage{
        static public WebElement element;
        public BasePage(WebDriver driver) {
            driver=PageGenerator.driver;
        }
        //If we need we can use custom wait in BasePage and all page classes
        WebDriverWait wait = new WebDriverWait(driver,20);

        //click method using By or Elements
        public static <T> void elementClick(T elementAttr){
            if(elementAttr.getClass().getName().contains("By")){

                driver.findElement((By) elementAttr).click();
            }
            else{

                ((WebElement) elementAttr).click();
            }

        }

        //enter text using by or elements
        public static <T> void writeText (T elementAttr, String text) {
            if(elementAttr.getClass().getName().contains("By")) {
                driver.findElement((By) elementAttr).sendKeys(text);
            } else {
                ((WebElement) elementAttr).sendKeys(text);
            }
        }

        //Read Text by using JAVA Generics (You can use both By or Webelement)
        public static <T> String readText (T elementAttr) {
            if(elementAttr.getClass().getName().contains("By")) {
                return driver.findElement((By) elementAttr).getText();
            } else {
                return ((WebElement) elementAttr).getText();
            }
        }

        //Close popup if exists
        public static void handlePopup (By by) throws InterruptedException {
            List<WebElement> popup = driver.findElements(by);
            if(!popup.isEmpty()){
                popup.get(0).click();
                Thread.sleep(200);
            }
        }

        //click menu
        public static  void cllickMenu(List<WebElement> menuList,String attr, String attrVlue){
            int size= menuList.size();
            String clickedLinktext=null;
            for(int i=0;i<size; i++){
                if(menuList.get(i).getAttribute(attr).contains(attrVlue)){
                    menuList.get(i).click();

                }

            }

        }
        //verify text

        public static String verifyText(List<WebElement> elements, String attr, String attrValue, String textForVerify) {
            int size= elements.size();
            String clickedLinktext=null;
            for(int i=0;i<size; i++){
                if(elements.get(i).getAttribute(attr).contains(attrValue)){
                    elements.get(i).click();

                }

            }
            return clickedLinktext;
        }


    }

}
