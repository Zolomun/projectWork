package steps;

import baseItems.BaseTest;
import browser.BrowserType;
import browser.DriverInitializer;
import browser.Settings;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import tesco.pages.*;

import java.time.Duration;

public class TescoSteps extends BaseTest {

    WebDriver driver;


    @Before
    public void openBrowser() {
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


    @When("I register with the following details {string} and {string} and {string} and {string} and {string}:")
    public void iRegisterWithTheFollowingUser(String email, String password, String firstName, String lastName, String primaryPhone) throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        RegistrationStepOnePage registrationStepOnePagePage = homePage.clickOnRegistrate();
        registrationStepOnePagePage.isLoaded();
        RegistrationStepTwoPage registrationStepTwoPage = registrationStepOnePagePage.registrationFirstStep(email, password);
        RegistrationStepThreePage registrationStepThreePage = registrationStepTwoPage.registrationSecondStep();
        registrationStepThreePage.registrationThirdStep(firstName, lastName, primaryPhone);


    }

    @Then("I can see the Sign out button")
    public void iCanSeeTheSignOutButton() {
        AfterRegHomePage afterRegHomePage = new AfterRegHomePage(driver);
        afterRegHomePage.checkSignOutButton();
    }


//    @After
//    public void closeBrowser(){
//        driver.quit();
//    }


}