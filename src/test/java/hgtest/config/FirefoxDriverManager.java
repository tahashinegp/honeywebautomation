package hgtest.config;

import hgtest.utils.HelperClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class FirefoxDriverManager{

    /*public WebDriver driver;
    File file;
    private GeckoDriverService gecService;
    @Override
    public void startService() {
        try {
            if (gecService == null) {
                String fileName = "geckodriver.exe";
                file = HelperClass.getFile(fileName);
                gecService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(file)
                        .usingAnyFreePort()
                        .build();
                gecService.start();
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void stopService() {
        if (null != gecService && gecService.isRunning())
            gecService.stop();

    }

    @Override
    public void createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("dom.popup_maximum", 0);
        capabilities.setCapability("marionette", true);
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS,true);
        driver= new FirefoxDriver();

       // capabilities.setCapability("useMarionette", true);
        //capabilities.setCapability(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "./geckodriver");

    }

*/
}
