package tesco.pages;

import baseItems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//input[@id =  \"email\"]")
    WebElement emailField;

    @FindBy(xpath = "//input[@id =  \"password\"]")
    WebElement passwordField;

    @FindBy(xpath = "//span[contains(text(), \"Bejelentkezés\")]")
    WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, \"greeting\")]//span[2]")
    WebElement userGreeting;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoggedInHomePage doLogin(String emailAddress, String password) {
        emailField.sendKeys(emailAddress);
        passwordField.sendKeys(password);
        loginButton.click();
        isLoaded(userGreeting);
        return new LoggedInHomePage(driver);
    }
}
