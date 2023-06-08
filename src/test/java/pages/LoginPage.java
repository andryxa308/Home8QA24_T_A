package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    public void setUsernameValue(String username) {

        driver.findElement(usernameInput).sendKeys(username);
    }

    public void setPasswordValue(String password) {

        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {

        driver.findElement(loginButton).click();
    }

    public void login(String userName, String password) {
        this.setUsernameValue(userName);
        this.setPasswordValue(password);
        this.clickLoginButton();
    }

    public boolean isErrormessageIsDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();

    }

}