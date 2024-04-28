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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testPersonalAreaNavigation() {
        LoginPage loginPage = new LoginPage(driver);
        mainPage.openPage();
        mainPage.openPersonalArea();
       Assert.assertTrue("Open successful", loginPage.personalAreaIsDispayed());
    }
    @Test
    public void testConstructorNavigation() {
        mainPage.openPage();
        mainPage.openPersonalArea();
        mainPage.openConstructor();
       Assert.assertTrue("Open successful", mainPage.BuilsBurgerDispayed());
    }
    @Test
    public void testStellarBurgersNavigation() {
        mainPage.openPage();
        mainPage.openPersonalArea();
        mainPage.clickStellarBurger();
        Assert.assertTrue("Open successful", mainPage.BuilsBurgerDispayed());
    }
    @Test
    public void testLogout() {
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openPage();
        mainPage.openPersonalArea();
        loginPage.inputEmail("ermolaeva.daria@bk.ru");
        loginPage.inputPassword("Ermolaeva-007");
        loginPage.clickLoginButton();
        Assert.assertTrue("Login successful", mainPage.BuilsBurgerDispayed());

        mainPage.openPersonalArea();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UNLOGIN_BUTTON)));

        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ENTRANCY_TEXT)));
        mainPage.unLogin();
        Assert.assertTrue("Unlogin successful", loginPage.personalAreaIsDispayed());
    }
    @Test
    public void testSectionsNavigation() {
        mainPage.openPage();
        mainPage.openConstructor();
        mainPage.clickCause();
        Assert.assertTrue("Navigation successful", mainPage.sauseTextIsDisplayed());

        mainPage.clickBuns();
        Assert.assertTrue("Navigation successful", mainPage.bunsTextIsDisplayed());

        mainPage.clickFilling();
        Assert.assertTrue("Navigation successful", mainPage.fillingsTextIsDisplayed());
    }
}
