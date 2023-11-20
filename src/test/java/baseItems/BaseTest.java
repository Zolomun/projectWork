package baseItems;

import browser.BrowserType;
import browser.DriverInitializer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;


public class BaseTest {

    public static WebDriver driver;


    @BeforeAll
    public static void beforeAll(){
        driver = DriverInitializer.initDriver(BrowserType.CHROME_SELENIUM_MGR);
    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }

}
