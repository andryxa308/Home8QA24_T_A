package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTests extends BaseTest {

    @Test(groups = {"smoke"})
    public void positiveCheckoutTest() {
        String testItemName = "Sauce Labs Bike Light";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOutButton();
        checkOutPage.checkOut(FIRSTNAME, LASTNAME, POSTALCODE);
        Assert.assertTrue(checkoutOverviewPage.finishButtonIsDisplayed());
    }

    @Test(groups = {"regression"})
    public void checkProductTest() {
        String testItemName = "Sauce Labs Bike Light";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOutButton();
        checkOutPage.checkOut(FIRSTNAME, LASTNAME, POSTALCODE);
        String actualItemName = checkoutOverviewPage.getItemName();
        String expectedItemName = "Sauce Labs Bike Light";
        Assert.assertEquals(actualItemName, expectedItemName);
        String actualItemDescription = checkoutOverviewPage.getItemDescription();
        String expectedItemDescription = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. " +
                "Water-resistant with 3 lighting modes, 1 AAA battery included.";
        Assert.assertEquals(actualItemDescription, expectedItemDescription);
        String actualItemPrice = checkoutOverviewPage.getItemPrice();
        String expectedItemPrice = "$9.99";
        Assert.assertEquals(actualItemPrice, expectedItemPrice);
        String actualItemTotal = checkoutOverviewPage.getItemTotal();
        String expectedItemTotal = "Item total: $9.99";
        Assert.assertEquals(actualItemTotal, expectedItemTotal);
        String actualItemTax = checkoutOverviewPage.getItemTax();
        String expectedItemTax = "Tax: $0.80";
        Assert.assertEquals(actualItemTax, expectedItemTax);
        String actualTotalPrice = checkoutOverviewPage.getTotalPrice();
        String expectedTotalPrice = "Total: $10.79";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
    }

    @Test(groups = {"regression"})
    public void cancelButtonTest() {
        String testItemName = "Sauce Labs Bike Light";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckOutButton();
        checkOutPage.checkOut(FIRSTNAME, LASTNAME, POSTALCODE);
        checkoutOverviewPage.clickCancelButton();
        productsPage.getItemDescription(testItemName);
        String actualItemDescriptionNew = productsPage.getItemDescription(testItemName);
        String expectedItemDescriptionNew = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. " +
                "Water-resistant with 3 lighting modes, 1 AAA battery included.";
        Assert.assertEquals(actualItemDescriptionNew, expectedItemDescriptionNew);
    }
}
