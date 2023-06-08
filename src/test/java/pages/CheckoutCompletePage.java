package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage(WebDriver driver) {

        super(driver);
    }
    private By backHomeButtonLocator = By.id("back-to-products");

    public boolean backHomeButtonIsDisplayed() {

        return driver.findElement(backHomeButtonLocator).isDisplayed();
    }
}
