package tesco.pages;

import baseItems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//h1[text()=\"Regisztráció - első lépés\"]")
    WebElement registrationFirstStep;

    @FindBy(xpath = "//input[@id=\"email\"]")
    WebElement emailField;

    @FindBy(xpath = "//input[@id=\"password\"]")
    WebElement passwordField;


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded(){
        return super.isLoaded(registrationFirstStep);
    }

    public boolean emailVisible(){
        return super.isLoaded(emailField);
    }

    public boolean passwordVisible(){
        return super.isLoaded(passwordField);
    }
}
