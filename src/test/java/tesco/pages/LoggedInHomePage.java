package tesco.pages;

import baseItems.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedInHomePage extends BasePage {

    @FindBy(xpath = "//input[@id=\"search-input\"]")
    WebElement searchBar;

    @FindBy(xpath = "//h1[contains(text(), \"Találatok\")]")
    WebElement searchPage;

    @FindBy(xpath = "//div[contains(@class, \"greeting\")]//span[2]")
    WebElement userGreeting;


    public LoggedInHomePage(WebDriver driver) {
        super(driver);
    }


    public String checkGreetingText() {
        String userGreetingText = userGreeting.getText();
        return userGreetingText;
    }

    public SearchResultsPage searchItem(String product) {
        searchBar.sendKeys(product, Keys.ENTER);
        isLoaded(searchPage);
        return new SearchResultsPage(driver);
    }
}
