package tesco.pages;

import baseItems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;


public class RegistrationStepTwoPage extends BasePage {

    @FindBy(xpath = "//h1[text()=\"Regisztráció - harmadik lépés\"]")
    WebElement registrationThirdStep;

    @FindBy(xpath = "//select[@id = \"county\"]")
    WebElement countySelect;

    @FindBy(xpath = "//option[text() = \"Hajdú-Bihar\"]")
    WebElement countyActual;

    @FindBy(xpath = "//select[@id = \"municipality\"]")
    WebElement municipalitySelect;

    @FindBy(xpath = "//option[text() = \"Debrecen\"]")
    WebElement municipalityActual;

    @FindBy(xpath = "//select[@id = \"postcode\"]")
    WebElement postcodeSelect;

    @FindBy(xpath = "//option[text() = \"4034\"]")
    WebElement postcodeActual;

    @FindBy(xpath = "//select[@id = \"street\"]")
    WebElement streetSelect;

    @FindBy(xpath = "//option[text() = \"Árva utca\"]")
    WebElement streetActual;

    @FindBy(xpath = "//select[@id = \"housenumber\"]")
    WebElement houseNumberSelect;

    @FindBy(xpath = "//option[text() = \"1\"]")
    WebElement houseNumberActual;

    @FindBy(xpath = "//input[@id = \"nickname\"]")
    WebElement addNickname;

    @FindBy(xpath = "//span[text() = \"Következő\"]")
    WebElement nextButton;


    public RegistrationStepTwoPage(WebDriver driver) {
        super(driver);
    }


    public RegistrationStepThreePage registrationSecondStep() {
        if (isLoaded(addNickname)) {
            countySelect.click();
            countyActual.click();
            municipalitySelect.click();
            municipalityActual.click();
            postcodeSelect.click();
            postcodeActual.click();
            streetSelect.click();
            streetActual.click();
            houseNumberSelect.click();
            houseNumberActual.click();
            wait.until(ExpectedConditions.elementToBeClickable(addNickname));
            addNickname.sendKeys("home");
            nextButton.click();
        }
        isLoaded(registrationThirdStep);
        return new RegistrationStepThreePage(driver);
    }
}
