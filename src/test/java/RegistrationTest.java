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


public class RegistrationTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/daria/WebDriver/yandexdriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Step("Test successful registration")
    @Test
    public void testSuccessfulRegistration() {
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openPage();
        mainPage.openPersonalArea();
        loginPage.openRegistration();
        registrationPage.inputName("Daria");
        registrationPage.inputEmail("email@example.com");
        registrationPage.inputPassword("validpassword");

        registrationPage.clickRegisterButton();
        loginPage.personalAreaIsDispayed();
        Assert.assertTrue("Регистрация прошла успешно", loginPage.personalAreaIsDispayed());
    }
    @Step("Test invalid password error")
    @Test
    public void testInvalidPasswordError() {
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openPage();
        mainPage.openPersonalArea();
        loginPage.openRegistration();

        registrationPage.inputName("Ваше имя");
        registrationPage.inputEmail("example@example.com");
        registrationPage.inputPassword("123");
        registrationPage.clickRegisterButton();

        String errorMessage = registrationPage.getErrorMessage();
        Assert.assertEquals("Ошибка при вводе некорректного пароля не отображается", "Некорректный пароль", errorMessage);
    }
}