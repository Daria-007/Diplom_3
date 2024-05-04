import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjests.LoginPage;
import pageObjests.MainPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static pageObjests.LoginPage.ENTRANCY_TEXT;
import static pageObjests.MainPage.UNLOGIN_BUTTON;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    @Before
    public void setUp() {
        driver = getWebDriver(false); // Используйте getWebDriver для получения экземпляра ChromeDriver
        mainPage = new MainPage(driver);
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
    @After
    public void tearDown() {
        driver.quit();
    }
    @Step("Test personal area navigation")
    @Test
    public void testPersonalAreaNavigation() {
        LoginPage loginPage = new LoginPage(driver);
        mainPage.openPage();
        mainPage.openPersonalArea();
       Assert.assertTrue("Open successful", loginPage.personalAreaIsDispayed());
    }
    @Step("Test constructor navigation")
    @Test
    public void testConstructorNavigation() {
        mainPage.openPage();
        mainPage.openPersonalArea();
        mainPage.openConstructor();
       Assert.assertTrue("Open successful", mainPage.isBuildBurgerDisplayed());
    }
    @Step("Test Stellar Burgers navigation")
    @Test
    public void testStellarBurgersNavigation() {
        mainPage.openPage();
        mainPage.openPersonalArea();
        mainPage.clickStellarBurger();
        Assert.assertTrue("Open successful", mainPage.isBuildBurgerDisplayed());
    }
    @Step("Test logout")
    @Test
    public void testLogout() {
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openPage();
        mainPage.openPersonalArea();
        loginPage.inputEmail("ermolaeva.daria@bk.ru");
        loginPage.inputPassword("Ermolaeva-007");
        loginPage.clickLoginButton();
        Assert.assertTrue("Login successful", mainPage.isBuildBurgerDisplayed());

        mainPage.openPersonalArea();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UNLOGIN_BUTTON)));
        mainPage.unLogin();
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ENTRANCY_TEXT)));
        Assert.assertTrue("Unlogin successful", loginPage.personalAreaIsDispayed());
    }
    @Step("Test sections navigation")
    @Test
    public void testSectionsNavigation() {
        mainPage.openPage();
        mainPage.openConstructor();
        mainPage.clickSauce();
        Assert.assertTrue("Navigation successful", mainPage.isSauceTextDisplayed());

        mainPage.clickBuns();
        Assert.assertTrue("Navigation successful", mainPage.isBunsTextDisplayed());

        mainPage.clickFillings();
        Assert.assertTrue("Navigation successful", mainPage.isFillingsTextDisplayed());
    }
}
