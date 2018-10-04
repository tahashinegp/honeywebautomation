package hgtest.config;

import org.openqa.selenium.WebDriver;


public interface BrowserInterface {

    void stopService();
    void quitDriver();
    default WebDriver getDriver() {
        WebDriver driver=null;
          if (null == driver) {
              startService();
              driver= createDriver();
          }
          return driver;
      }
    void  startService();
    WebDriver  createDriver();


}
