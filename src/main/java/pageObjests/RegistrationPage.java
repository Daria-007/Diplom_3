package pageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    public static final String INPUT_PASSWORD = ".//div[@class = 'input pr-6 pl-6 input_type_password input_size_default']";
    public static final String REGISTER_BUTTON = ".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']";
    public static final String INPUT_NAME = ".//fieldset[1]//input[@class = 'text input__textfield text_type_main-default']";
    public static final String INPUT_EMAIL = ".//fieldset[2]//input[@class = 'text input__textfield text_type_main-default']";
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputName(String name) {
        WebElement inputName = driver.findElement(By.xpath(INPUT_NAME));
        inputName.clear();
        inputName.sendKeys(name);
    }
    public void inputEmail(String email) {
        WebElement inputEmail = driver.findElement(By.xpath(INPUT_EMAIL));
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }
    public void inputPassword(String password) {
        WebElement inputPassword = driver.findElement(By.xpath(INPUT_PASSWORD));
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }
        public void clickRegisterButton() {
            driver.findElement(By.xpath(REGISTER_BUTTON)).click();
        }
}
