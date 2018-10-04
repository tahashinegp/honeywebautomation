package hgtest.config;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class BrowserManagerFactory {
    WebDriver driver;


    public static BrowserInterface getBrowser(BrowserType browser){
        BrowserInterface browserType=null;
        switch(browser){
            case CHROME:
                browserType = new ChromedriverManager();
                break;
            case FIREFOX:
                browserType= (BrowserInterface)new FirefoxDriverManager();
                break;
           default:
               System.out.println("Illegal browser");


        }
        return browserType;
    }


}


