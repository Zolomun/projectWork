package steps;

import baseItems.BaseTest;
import browser.BrowserType;
import browser.DriverInitializer;
import browser.Settings;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import tesco.pages.HomePage;
import tesco.pages.RegistrationPage;

import java.time.Duration;

public class TescoSteps extends BaseTest {

    WebDriver driver;
   // HomePage homePage;
    RegistrationPage registrationPage;


    @Before
    public void openBrowser() {
       //beforeAll();
        driver = DriverInitializer.initDriver(BrowserType.CHROME_SELENIUM_MGR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Given("I open TescoOnline")
    public void iOpenTescoOnline() {
        driver.get(Settings.TESCO_URL);


    }

    @When("I accept cookies")
    public void iAcceptCookies() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnAcceptCookies();
    }

    @When("I click on Registration button")
    public void iClickOnRegistrate(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnRegistrate();
    }

    @Then("I am directed to Registration page")
    public void checkRegistrationPage(){
        registrationPage.isLoaded();
    }

    @And("Email address field is visible")
    public void emailVisible(){
        registrationPage.emailVisible();
    }

    @And("Password field is visible")
    public void passwordVisible(){
        registrationPage.passwordVisible();
    }

    @After
    public void closeBrowser(){
        //afterAll();
        driver.quit();
    }

}