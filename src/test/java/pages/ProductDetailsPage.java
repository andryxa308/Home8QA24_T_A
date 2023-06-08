package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {

        super(driver);
    }

    private By addToCartButtonLocator = By.cssSelector("button[id |= 'add-to-cart'");

    public boolean addToCartButtonIsDisplayed() {

        return driver.findElement(addToCartButtonLocator).isDisplayed();
    }
}