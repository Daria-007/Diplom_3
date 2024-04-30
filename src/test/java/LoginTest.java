import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjests.LoginPage;
import pageObjests.MainPage;
import pageObjests.RegistrationPage;

import javax.inject.Inject;


public class LoginTest {
    @Inject
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
    @Step("Test login from personal area")
    @Test
    public void testLoginFromPersonalArea() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openPage();
        mainPage.openPersonalArea();
        loginPage.inputEmail("ermolaeva.daria@bk.ru");
        loginPage.inputPassword("Ermolaeva-007");
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
        loginPage.inputEmail("ermolaeva.daria@bk.ru");
        loginPage.inputPassword("Ermolaeva-007");
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
        loginPage.inputEmail("ermolaeva.daria@bk.ru");
        loginPage.inputPassword("Ermolaeva-007");
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
        loginPage.inputEmail("ermolaeva.daria@bk.ru");
        loginPage.inputPassword("Ermolaeva-007");
        loginPage.clickLoginButton();

        Assert.assertTrue("Login successful", mainPage.isBuildBurgerDisplayed());
    }
}
