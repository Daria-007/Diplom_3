package pageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String PERSONAL_AREA = ".//p[@class= 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный Кабинет']";
    public static final String CONCTRUCTOR = ".//p[@class= 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Конструктор']";
    public static final String STELLAR_BURGER_BUTTON = "#root > div > header > nav > div > a > svg";
    public static final String BUNS = ".//span[@class = 'text text_type_main-default' and text() = 'Булки']";
    public static final String CAUSE = ".//span[@class = 'text text_type_main-default' and text() = 'Соусы']";
    public static final String FILLINGS = ".//span[@class = 'text text_type_main-default' and text() = 'Начинки']";
    public static final String UNLOGIN_BUTTON = ".//button[@class = 'Account_button__14Yp3 text text_type_main-medium text_color_inactive']";
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openPage() {
        driver.get(PAGE_URL);
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
    public void unLogin() {
        driver.findElement(By.xpath(UNLOGIN_BUTTON)).click();
    }
}
