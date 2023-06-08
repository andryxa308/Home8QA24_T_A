package tests;
import Utils.Retry;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test(groups = {"smoke"},retryAnalyzer = Retry.class)
    public void positiveLoginPage() {
        loginPage.setUsernameValue("standard_user");
        loginPage.setPasswordValue("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isShoppingCartLinkDisplayed());
    }
    @Test(groups = {"smoke"}, dataProvider = "negativeLoginTestData")
    public void negativeLoginPage(String username, String password, String expectedErrorMessage) {
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isErrormessageIsDisplayed(),expectedErrorMessage);

    }
    @DataProvider
    public Object[][] negativeLoginTestData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }


}
