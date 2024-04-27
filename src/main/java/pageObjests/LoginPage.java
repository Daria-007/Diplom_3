package pageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public static final String EMAIL_INPUT = ".//input[@class = 'text input__textfield text_type_main-default' and @type = 'text']";
    public static final String PASSWORD_INPUT = ".//input[@class = 'text input__textfield text_type_main-default' and @type = 'password']";
    public static final String LOGIN_BUTTON = ".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']";
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void inputEmail(String email) {
        WebElement inputEmail = driver.findElement(By.xpath(EMAIL_INPUT));
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }
    public void inputPassword(String password) {
        WebElement inputPassword = driver.findElement(By.xpath(PASSWORD_INPUT));
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }
}
