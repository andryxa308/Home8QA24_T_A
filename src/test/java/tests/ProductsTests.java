package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ProductsTests extends BaseTest {
    @Test(groups = {"regression"})
    public void productInfoTest() {
        String testItemName = "Sauce Labs Bike Light";
        loginPage.login(USERNAME, PASSWORD);
        String actualItemPrice = productsPage.getItemPrice(testItemName);
        String expectedItemPrice = "$9.99";
        Assert.assertEquals(actualItemPrice, expectedItemPrice);
        String actualItemDescription = productsPage.getItemDescription(testItemName);
        String expectedItemDescription = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. " +
                "Water-resistant with 3 lighting modes, 1 AAA battery included.";
        Assert.assertEquals(actualItemDescription, expectedItemDescription);
    }
    @Test(groups = {"smoke"})
    public void addToCartButtonTest() {
        String testItemName = "Sauce Labs Bike Light";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        Assert.assertTrue(productsPage.removeButtonIsDisplayed());
    }
    @Test(groups = {"regression"})
    public void removeButtonTest() {
        String testItemName = "Sauce Labs Bike Light";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickRemoveButton(testItemName);
        Assert.assertTrue(productsPage.addToCartButtonIsDisplayed());
    }
    @Test(groups = {"regression"})
    public void openItemTest() {
        String testItemName = "Sauce Labs Bike Light";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItem(testItemName);
        Assert.assertTrue(productDetailsPage.addToCartButtonIsDisplayed());

    }
}

