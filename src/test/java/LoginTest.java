import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjests.LoginPage;
import pageObjests.MainPage;
import pageObjests.RegistrationPage;

public class LoginTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testLoginFromPersonalArea() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openPage();
        mainPage.openPersonalArea();
        loginPage.inputEmail("ermolaeva.daria@bk.ru");
        loginPage.inputPassword("Ermolaeva-007");
        loginPage.clickLoginButton();

        Assert.assertTrue("Login successful", mainPage.BuilsBurgerDispayed());
    }
    @Test
    public void testLoginFromMainPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openPage();
        mainPage.openLoginPage();
        loginPage.inputEmail("ermolaeva.daria@bk.ru");
        loginPage.inputPassword("Ermolaeva-007");
        loginPage.clickLoginButton();

        Assert.assertTrue("Login successful", mainPage.BuilsBurgerDispayed());
    }
    @Test
    public void testLoginFromRegistrationForm() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.openPage();
        mainPage.openLoginPage();
        loginPage.openRegistration();
        registrationPage.openLoginPage();
        loginPage.inputEmail("ermolaeva.daria@bk.ru");
        loginPage.inputPassword("Ermolaeva-007");
        loginPage.clickLoginButton();

        Assert.assertTrue("Login successful", mainPage.BuilsBurgerDispayed());
    }
    @Test
    public void testLoginFromPasswordRecoveryForm() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        mainPage.openPage();
        mainPage.openLoginPage();
        loginPage.openPasswordRecoveryForm();
        registrationPage.openLoginPage();
        loginPage.inputEmail("ermolaeva.daria@bk.ru");
        loginPage.inputPassword("Ermolaeva-007");
        loginPage.clickLoginButton();

        Assert.assertTrue("Login successful", mainPage.BuilsBurgerDispayed());
    }
}
