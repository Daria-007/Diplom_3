package pageObjests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;


public class MainPage {
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String PERSONAL_AREA = ".//p[@class= 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный Кабинет']";
    public static final String CONCTRUCTOR = ".//p[@class= 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Конструктор']";
    public static final String STELLAR_BURGER_BUTTON = "#root > div > header > nav > div > a > svg";
    public static final String BUNS = ".//span[@class = 'text text_type_main-default' and text() = 'Булки']";
    public static final String CAUSE = ".//span[@class = 'text text_type_main-default' and text() = 'Соусы']";
    public static final String FILLINGS = ".//span[@class = 'text text_type_main-default' and text() = 'Начинки']";
    public static final String UNLOGIN_BUTTON = ".//button[@class = 'Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text() = 'Выход']";
    public static final String BUILD_BURGER_TEXT = ".//h1[@class = 'text text_type_main-large mb-5 mt-10']";
    public static final String LOGIN_BUTTON = ".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']";
    public static final String BUNS_TEXT = ".//h2[@class = 'text text_type_main-medium mb-6 mt-10' and text() = 'Булки']";
    public static final String SAUSE_TEXT = ".//h2[@class = 'text text_type_main-medium mb-6 mt-10' and text() = 'Соусы']";
    public static final String FILLINGS_TEXT = ".//h2[@class = 'text text_type_main-medium mb-6 mt-10' and text() = 'Начинки']";
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openPage() {
        driver.get(PAGE_URL);
    }
    public void openLoginPage(){
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }
    public void openPersonalArea() {
        driver.findElement(By.xpath(PERSONAL_AREA)).click();
    }
    public void openConstructor() {
        driver.findElement(By.xpath(CONCTRUCTOR)).click();
    }
    public void clickStellarBurger() {
        driver.findElement(By.cssSelector(STELLAR_BURGER_BUTTON)).click();
    }
    public void clickBuns() {
        driver.findElement(By.xpath(BUNS)).click();
    }
    public void clickCause() {
        driver.findElement(By.xpath(CAUSE)).click();
    }
    public void clickFilling() {
        driver.findElement(By.xpath(FILLINGS)).click();
    }
    public void unLogin()  {
        driver.findElement(By.xpath(UNLOGIN_BUTTON)).click();
    }
    public boolean bunsTextIsDisplayed() {

        return driver.findElement(By.xpath(BUNS_TEXT)).isDisplayed();
    }
    public boolean sauseTextIsDisplayed() {

        return driver.findElement(By.xpath(SAUSE_TEXT)).isDisplayed();
    }
    public boolean fillingsTextIsDisplayed() {

        return driver.findElement(By.xpath(FILLINGS_TEXT)).isDisplayed();
    }
    public boolean BuilsBurgerDispayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUILD_BURGER_TEXT))).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
