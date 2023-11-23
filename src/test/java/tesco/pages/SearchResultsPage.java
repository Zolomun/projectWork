package tesco.pages;

import baseItems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//li[@class=\"product-list--list-item first\"]/div/div/div/div/div/h3/a/span")
    WebElement firstResult;

    @FindBy(xpath = "(//div[@class=\"product-details--wrapper\"]//button/span)[1]")
    WebElement firstResultAddToCartButton;

    @FindBy(xpath = "//div[@data-testid= \"basket-items-container\"]//div[@data-auto = \"mini-tile-title\"]//h4")
    WebElement productInBasketContainer;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public Boolean checkSearchResult(String product) {
        if (firstResult.getText().contains(product)) {
            return true;
        } else {
            throw new IllegalArgumentException("The name of the product in the search list doesn't contain your search item");
        }
    }

    public void addProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstResultAddToCartButton));
        firstResultAddToCartButton.click();
    }

    public Boolean checkBasketItem(String product) {
        wait.until(ExpectedConditions.elementToBeClickable(productInBasketContainer));
        if (productInBasketContainer.getText().contains(product)) {
            return true;
        } else {
            throw new IllegalArgumentException("The name of the product in the basket doesn't contain your search item");
        }
    }
}
