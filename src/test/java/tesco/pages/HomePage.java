package tesco.pages;

import baseItems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[contains(@class, 'cookies-notification__button')]")
    WebElement acceptCookieButton;

    @FindBy(xpath = "//span[text() = \"Regisztráció\"]")
    WebElement registrationButton;

    @FindBy(xpath = "//span[contains(text(), \"Bejelentkezés\")]")
    WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAcceptCookies() {
        acceptCookieButton.click();
    }

    public RegistrationStepOnePage clickOnRegistrate() {
        registrationButton.click();
        return new RegistrationStepOnePage(driver);
    }

    public void clickOnLogIn() {
        loginButton.click();
    }

}
