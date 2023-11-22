package tesco.pages;

import baseItems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfterRegHomePage extends BasePage {

    @FindBy(xpath = "//span[text() = \"Kijelentkezés\"]")
    WebElement signOutButton;


    public AfterRegHomePage(WebDriver driver) {
        super(driver);
    }

    public void checkSignOutButton() {
        signOutButton.isDisplayed();
    }

}
