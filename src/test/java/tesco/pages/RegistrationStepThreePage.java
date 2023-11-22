package tesco.pages;

import baseItems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationStepThreePage extends BasePage {

    @FindBy(xpath = "//h1")
    WebElement afterRegHomePage;

    @FindBy(xpath = "//input[@id = \"firstName\"]")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id = \"lastName\"]")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id = \"primaryPhone\"]")
    WebElement primaryPhoneInput;

    @FindBy(xpath = "//label[contains(text(), \"Elolvastam\")]")
    WebElement consentButton;

    @FindBy(xpath = "//span[text()=\"Igen, regisztrálok\"]")
    WebElement finishRegistration;


    public RegistrationStepThreePage(WebDriver driver) {
        super(driver);
    }


    public AfterRegHomePage registrationThirdStep(String firstName, String lastName, String primaryPhone) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        primaryPhoneInput.sendKeys(primaryPhone);
        consentButton.click();
        finishRegistration.click();
        isLoaded(afterRegHomePage);
        return new AfterRegHomePage(driver);
    }
}
