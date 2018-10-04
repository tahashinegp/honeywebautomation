package hgtest.config;

import hgtest.utils.HelperClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class ChromedriverManager implements BrowserInterface {
    private static WebDriver driver;
    private ChromeDriverService chService;
    File file;

    @Override
    //start service for chromebrowser without instantiate chorme driver server
    public void startService() {
        if(null==chService){
            try{
                //Get file from resources folder
                String fileName="chromedriver.exe";
                file=HelperClass.getFile(fileName);
                chService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(file)
                        .usingAnyFreePort()
                        .build();
                chService.start();
            }


            catch(Exception e){
                System.out.println(e);
            }
        }

    }

    @Override
    public void stopService() {
        if (null != chService && chService.isRunning())
            chService.stop();
    }

    @Override
    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    //create driver
    @Override
    public WebDriver createDriver(){
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("test-type");
        caps.setCapability("chrome.binary", "<Path to binary>");
        caps.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
        driver=new ChromeDriver(chService,caps);
        return driver;
    }



}
