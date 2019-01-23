package hgtest.utils;

import cucumber.api.Scenario;
import hgtest.config.BrowserInterface;
import hgtest.config.BrowserManagerFactory;
import hgtest.config.BrowserType;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
@Component
public class HelperClass   {
    private static File file;
    private static WebDriver driver;
    @Autowired
    BrowserInterface browserInterface;
    @Autowired
    private ApplicationContext applicationContext;
    //static String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    //static String appConfigPath = rootPath + "utils.properties";
    static Properties p;
    static String  honeUrl;
    public HelperClass(){

    }
    //public HelperClass(SharedContext sharedContext){
        //this.sharedContext=sharedContext;
    //}

    @Before
    public WebDriver initializeDriver(){
        browserInterface= BrowserManagerFactory.getBrowser(BrowserType.CHROME);
        driver=browserInterface.getDriver();
        honeUrl=getUrl();
        driver.get(honeUrl);
        return driver;
    }


    @After
    public  void quitDriver(){
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

    @Bean
    public ScenarioContext getScenarioContext() {
        return (ScenarioContext) applicationContext.getBean(ScenarioContext.class);
    }

    @Before
    public void before(Scenario scenario) {
        ConfigurableListableBeanFactory beanFactory = ((GenericApplicationContext)                              applicationContext).getBeanFactory();
        beanFactory.registerScope("scenario", new ScenarioScope());

        ScenarioContext context = applicationContext.getBean(ScenarioContext.class);
        context.setScenario(scenario);
    }

    @After
    public boolean after(Scenario scenario) {
        if (scenario.isFailed()) {
            return false;
        }
        return true;
    }
}
