import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjests.LoginPage;
import pageObjests.MainPage;
import pageObjests.RegistrationPage;


public class RegistrationTest {
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