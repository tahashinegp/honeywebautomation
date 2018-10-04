package hgtest.utils;

import hgtest.config.BrowserInterface;
import hgtest.config.BrowserManagerFactory;
import hgtest.config.BrowserType;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class HelperClass   {
    private static File file;
    private static WebDriver driver;
    static BrowserInterface browserInterface;
    //static String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    //static String appConfigPath = rootPath + "utils.properties";
    static Properties p;
    static String  honeUrl;



    public static WebDriver initializeDriver(){
        browserInterface= BrowserManagerFactory.getBrowser(BrowserType.CHROME);
        driver=browserInterface.getDriver();
        honeUrl=getUrl();
        driver.get(honeUrl);
        return driver;
    }


    public void quitDriver(){
        browserInterface.quitDriver();
    }

    public static File getFile(String fileName) {
       ClassLoader classLoader = HelperClass.class.getClassLoader();
       URL url=classLoader.getResource(fileName);
       //file=url.getFile();
       file= new File(url.getFile());
       return file;
    }

    public static Properties getProperties() throws IOException {
        p=new Properties();
        getFile("utils.properties");
        p.load(new FileReader(file));
        return p;
    }
    public static String getUrl(){
        String url = null;
        try {
            p = getProperties();
            url = p.getProperty("Url");

        }
        catch(Exception e){
            System.out.println(e);
        }
        return url;
    }

}
