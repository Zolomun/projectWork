package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverInitializer {


    public static WebDriver initDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME_SELENIUM_MGR:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-blink-features=AutomationControlled");
                options.addArguments("--incognito");
                options.addArguments("--disable-gpu");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--allow-running-insecure-content");
                options.addArguments("--start-maximized");
                options.addArguments("--no-sandbox");
                options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36");
                options.addArguments("--headless");
                return new ChromeDriver(options);
            default:
                throw new IllegalArgumentException("Incorrect browser type!");
        }
    }
}
