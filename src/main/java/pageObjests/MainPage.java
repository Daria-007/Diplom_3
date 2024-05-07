package pageObjests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public static final String PERSONAL_AREA = ".//p[@class= 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный Кабинет']";
    public static final String CONSTRUCTOR = ".//p[@class= 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Конструктор']";
    public static final String STELLAR_BURGER_BUTTON = ".//div[(@class = 'AppHeader_header__logo__2D0X2')]";
    public static final String BUNS = ".//span[@class = 'text text_type_main-default' and text() = 'Булки']";
    public static final String SAUCE = ".//span[@class = 'text text_type_main-default' and text() = 'Соусы']";
    public static final String FILLINGS = ".//span[@class = 'text text_type_main-default' and text() = 'Начинки']";
    public static final String UNLOGIN_BUTTON = ".//button[@class = 'Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text() = 'Выход']";
    public static final String BUILD_BURGER_TEXT = ".//h1[@class = 'text text_type_main-large mb-5 mt-10']";
    public static final String LOGIN_BUTTON = ".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']";
    public static final String BUNS_TEXT = ".//h2[@class = 'text text_type_main-medium mb-6 mt-10' and text() = 'Булки']";
    public static final String SAUCE_TEXT = ".//h2[@class = 'text text_type_main-medium mb-6 mt-10' and text() = 'Соусы']";
    public static final String FILLINGS_TEXT = ".//h2[@class = 'text text_type_main-medium mb-6 mt-10' and text() = 'Начинки']";

    public void openPage() {
        driver.get(PAGE_URL);
    }
    public void openLoginPage() {
        click(LOGIN_BUTTON);
    }
    public void openPersonalArea() {
        click(PERSONAL_AREA);
    }
    public void openConstructor() {
        click(CONSTRUCTOR);
    }
    public void clickStellarBurger() {
        click(STELLAR_BURGER_BUTTON);
    }
    public void clickBuns() {
        click(BUNS);
    }
    public void clickSauce() {
        click(SAUCE);
    }
    public void clickFillings() {
        click(FILLINGS);
    }
    public void unLogin() {
        click(UNLOGIN_BUTTON);
    }
    public boolean isBunsTextDisplayed() {
        return isElementDisplayed(BUNS_TEXT);
    }
    public boolean isSauceTextDisplayed() {
        return isElementDisplayed(SAUCE_TEXT);
    }
    public boolean isFillingsTextDisplayed() {
        return isElementDisplayed(FILLINGS_TEXT);
    }
    public boolean isBuildBurgerDisplayed() {
        return isElementDisplayed(BUILD_BURGER_TEXT);
    }
    private void click(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }
    private boolean isElementDisplayed(String xpath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
