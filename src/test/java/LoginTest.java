import io.qameta.allure.Step;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjests.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginTest extends BaseTest {
    private WebDriver driver;
    private static pageObjects.BurgerServiceUser burgerServiceUser;
    private static User testUser;
    @Before
    public void setUp() {
        driver = getWebDriver(false);
        driver.manage().window().maximize();
    }
    ChromeDriver getWebDriver(boolean useYandexBrowser){
        if (useYandexBrowser) {
            System.setProperty("webdriver.chrome.driver", "/Users/daria/WebDriver/yandexdriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "/Users/daria/WebDriver/bin/chromedriver-mac-x64/chromedriver");
        }
        return new ChromeDriver();
    }

    @BeforeClass
    public static void setUp2() {
        burgerServiceUser = new BurgerServiceUserImpl(REQUEST_SPECIFICATION, RESPONSE_SPECIFICATION);
        testUser = User.create("test103@yandex.ru", "password", "Username");
        burgerServiceUser.createUser(testUser)
                .statusCode(200)
                .body("success", equalTo(true));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    public void cleanUp() {
        if (testUser != null) {
            burgerServiceUser.deleteUser(testUser);
        }
    }
    @Step("Test login from personal area")
    @Test
    public void testLoginFromPersonalArea() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openPage();
        mainPage.openPersonalArea();
        loginPage.inputEmail("test103@yandex.ru");
        loginPage.inputPassword("password");
        loginPage.clickLoginButton();

        Assert.assertTrue("Login successful", mainPage.isBuildBurgerDisplayed());
    }
    @Step("Test login from main page")
    @Test
    public void testLoginFromMainPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openPage();
        mainPage.openLoginPage();
        loginPage.inputEmail("test103@yandex.ru");
        loginPage.inputPassword("password");
        loginPage.clickLoginButton();

        Assert.assertTrue("Login successful", mainPage.isBuildBurgerDisplayed());
    }
    @Step("Test login from registration form")
    @Test
    public void testLoginFromRegistrationForm() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.openPage();
        mainPage.openLoginPage();
        loginPage.openRegistration();
        registrationPage.openLoginPage();
        loginPage.inputEmail("test103@yandex.ru");
        loginPage.inputPassword("password");
        loginPage.clickLoginButton();

        Assert.assertTrue("Login successful", mainPage.isBuildBurgerDisplayed());
    }
    @Step("Test login from password recovery form")
    @Test
    public void testLoginFromPasswordRecoveryForm() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.openPage();
        mainPage.openLoginPage();
        loginPage.openPasswordRecoveryForm();
        registrationPage.openLoginPage();
        loginPage.inputEmail("test103@yandex.ru");
        loginPage.inputPassword("password");
        loginPage.clickLoginButton();

        Assert.assertTrue("Login successful", mainPage.isBuildBurgerDisplayed());
    }
}
