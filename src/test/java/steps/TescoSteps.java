package steps;

import baseItems.BaseTest;
import browser.BrowserType;
import browser.DriverInitializer;
import browser.Settings;
import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import tesco.pages.*;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TescoSteps extends BaseTest {

    WebDriver driver;

    @Before
    public void openBrowser() {
        driver = DriverInitializer.initDriver(BrowserType.CHROME_SELENIUM_MGR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
    public void iRegisterWithTheFollowingUser(String email, String password, String firstName, String lastName, String primaryPhone) {
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

    @When("I search and add a product to my cart: {string}")
    public void addProductToMyCart(String product) throws IOException {
        LoggedInHomePage loggedInHomePage = new LoggedInHomePage(driver);
        loggedInHomePage.searchItem(product);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        Assertions.assertTrue(searchResultsPage.checkSearchResult(product), product);
        searchResultsPage.addProductToCart();

        List<String> tags = new ArrayList<String>();
        tags.add("desktop");
        LayoutReport report = Galen.checkLayout(driver, "/specs/tescoProducts.gspec", tags);
        createReport(report);
    }

    public void createReport(LayoutReport report) throws IOException {
        GalenTestInfo testInfo = GalenTestInfo.fromString("Tesco products page");
        testInfo.getReport().layout(report, "Tesco products page layout test");

        List<GalenTestInfo> testInfoList = new ArrayList<GalenTestInfo>();

        testInfoList.add(testInfo);

        new HtmlReportBuilder().build(testInfoList, "galen/test-report/");
    }

    @Then("{string} is visible in my cart")
    public void theProductIsVisibleInMCart(String product) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        Assertions.assertTrue(searchResultsPage.checkBasketItem(product), product);
    }

    @Given("I log in with the following details {string} and {string} and {string}:")
    public String iLogInAsAUser(String emailAddress, String password, String firstName) {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLogIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(emailAddress, password);
        return firstName;
    }

    @Then("I can see welcome message with {string}")
    public void iCanSeeWelcomeMessage(String firstName) {
        LoggedInHomePage loggedInHomePage = new LoggedInHomePage(driver);
        Assertions.assertEquals(firstName, loggedInHomePage.checkGreetingText());
    }

    @And("I can see welcome message with <firstName>")
    public void iCanSeeWelcomeMessageWithFirstName() {

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}