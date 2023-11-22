package tesco.pages;

import baseItems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationStepOnePage extends BasePage {

    @FindBy(xpath = "//h1[text()=\"Regisztráció - első lépés\"]")
    WebElement registrationFirstStep;

    @FindBy(xpath = "//h1[text()=\"Regisztráció - második lépés\"]")
    WebElement registrationSecondStep;

    @FindBy(xpath = "//input[@id=\"email\"]")
    WebElement emailField;

    @FindBy(xpath = "//input[@id=\"password\"]")
    WebElement passwordField;

    @FindBy(xpath = "//input[@id=\"confirm-password\"]")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//span[text() = \"Következő\"]")
    WebElement nextButton;


    public RegistrationStepOnePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return super.isLoaded(registrationFirstStep);
    }

    public RegistrationStepTwoPage registrationFirstStep(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        nextButton.click();
        isLoaded(registrationSecondStep);
        return new RegistrationStepTwoPage(driver);
    }
}
