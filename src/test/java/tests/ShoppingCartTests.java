package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ShoppingCartTests extends BaseTest {

    @Test(groups = {"regression"})
    public void shoppingCartTest() {
        String testItemName = "Sauce Labs Bike Light";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        String actualItemName = shoppingCartPage.getItemName();
        String expectedItemName = "Sauce Labs Bike Light";
        Assert.assertEquals(actualItemName, expectedItemName);
        String actualItemDescription = shoppingCartPage.getItemDescription();
        String expectedItemDescription = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. " +
                "Water-resistant with 3 lighting modes, 1 AAA battery included.";
        Assert.assertEquals(actualItemDescription, expectedItemDescription);
        String actualItemPrice = shoppingCartPage.getItemPrice();
        String expectedItemPrice = "$9.99";
        Assert.assertEquals(actualItemPrice, expectedItemPrice);
    }
    @Test(groups = {"smoke"})
    public void shoppingCartContinueShoppingButtonTest() {
        String testItemName = "Sauce Labs Bike Light";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickContinueShoppingButton();
        productsPage.getItemDescription(testItemName);
        String actualItemDescriptionNew = productsPage.getItemDescription(testItemName);
        String expectedItemDescriptionNew = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. " +
                "Water-resistant with 3 lighting modes, 1 AAA battery included.";
        Assert.assertEquals(actualItemDescriptionNew, expectedItemDescriptionNew);
    }
    @Test(groups = {"smoke"})
    public void shoppingCartCheckOutButtonTest() {
        String testItemName = "Sauce Labs Bike Light";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOutButton();
        Assert.assertTrue(checkOutPage.firstNameInputIsDisplayed());
    }
}