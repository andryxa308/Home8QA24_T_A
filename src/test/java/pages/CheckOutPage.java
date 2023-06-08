package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {

        super(driver);
    }

    private By firstNameInputLocator = By.id("first-name");
    private By lastNameInputLocator = By.id("last-name");
    private By postalCodeInputLocator = By.id("postal-code");
    private By continueButtonLocator = By.id("continue");
    private By canselButtonLocator = By.id("cancel");


    public boolean firstNameInputIsDisplayed() {

        return driver.findElement(firstNameInputLocator).isDisplayed();
    }

    public void setFirstNameValue(String firstName) {

        driver.findElement(firstNameInputLocator).sendKeys(firstName);
    }

    public void setLastNameValue(String lastName) {

        driver.findElement(lastNameInputLocator).sendKeys(lastName);
    }

    public void setPostalCodeValue(String postalCode) {
        driver.findElement(postalCodeInputLocator).sendKeys(postalCode);
    }

    public void checkOut(String firstname, String lastName, String postalCode) {
        this.setFirstNameValue(firstname);
        this.setLastNameValue(lastName);
        this.setPostalCodeValue(postalCode);
        this.clickContinueButton();
    }

    public void clickContinueButton() {

        driver.findElement(continueButtonLocator).click();
    }

    public void clickCancelButton() {

        driver.findElement(canselButtonLocator).click();
    }
}
