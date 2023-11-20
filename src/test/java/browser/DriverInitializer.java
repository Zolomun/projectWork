package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverInitializer {


        public static WebDriver initDriver(BrowserType browserType) {
            switch(browserType) {
                case CHROME_SELENIUM_MGR:
                    return new ChromeDriver();
                default:
                    throw new IllegalArgumentException("Incorrect browser type!");
            }
        }
    }
