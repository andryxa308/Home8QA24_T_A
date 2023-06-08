package tests;
import Utils.InvokedListener;
import Utils.TestListener;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
@Listeners({TestListener.class, InvokedListener.class})

public abstract class BaseTest {
    private final static String URL = "https://www.saucedemo.com/";
    protected final static String USERNAME = "standard_user";
    protected final static String PASSWORD = "secret_sauce";
    protected final static String FIRSTNAME = "tests";
    protected final static String LASTNAME = "tests";
    protected final static String POSTALCODE = "678687";
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ShoppingCartPage shoppingCartPage;
    protected CheckOutPage checkOutPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected ProductDetailsPage productDetailsPage;
    @Parameters({"browserName"})

    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browserName, ITestContext context) throws Exception {
        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {

        driver.quit();
    }
    @BeforeMethod(alwaysRun = true)
    public void navigate() {

        driver.get(URL);
    }
    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }
}