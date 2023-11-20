package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverInitializer {


        public static WebDriver initDriver(BrowserType browserType) {
            switch(browserType) {
                case CHROME_SELENIUM_MGR:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-blink-features=AutomationControlled");
                    options.addArguments("--incognito");
                    return new ChromeDriver(options);
                default:
                    throw new IllegalArgumentException("Incorrect browser type!");
            }
        }
    }
