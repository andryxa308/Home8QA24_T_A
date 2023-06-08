package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductsPage extends BasePage {
    private By shoppingCartLink = By.cssSelector("a.shopping_cart_link");
    private By itemsLocator = By.cssSelector(".inventory_item");

    private By itemNameLocator = By.cssSelector(".inventory_item_name");
    private By addToCartButtonLocator = By.cssSelector("button[id |= 'add-to-cart']");
    private By itemPriceLocator = By.cssSelector(".inventory_item_price");
    private By itemDescriptionLocator = By.cssSelector(".inventory_item_desc");
    private By removeButtonLocator = By.cssSelector("button[id |= 'remove']");

    public ProductsPage(WebDriver driver) {

        super(driver);
    }

    public boolean isShoppingCartLinkDisplayed() {

        return driver.findElement(shoppingCartLink).isDisplayed();
    }

    public boolean removeButtonIsDisplayed() {

        return driver.findElement(removeButtonLocator).isDisplayed();
    }

    public boolean addToCartButtonIsDisplayed() {

        return driver.findElement(addToCartButtonLocator).isDisplayed();
    }

    public void clickAddToCartButton(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        itemContainer.findElement(addToCartButtonLocator).click();
    }

    public void clickRemoveButton(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        itemContainer.findElement(removeButtonLocator).click();
    }

    public void openItem(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        itemContainer.findElement(itemNameLocator).click();
    }

    public String getItemPrice(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        return itemContainer.findElement(itemPriceLocator).getText();
    }

    public String getItemDescription(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        return itemContainer.findElement(itemDescriptionLocator).getText();
    }

    public void clickShoppingCartLink() {

        driver.findElement(shoppingCartLink).click();
    }

    private WebElement getItemContainerByName(String itemName) {
        List<WebElement> allItems = driver.findElements(itemsLocator);
        for (WebElement item : allItems) {
            if (item.findElement(itemNameLocator).getText().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
}