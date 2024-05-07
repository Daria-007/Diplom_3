package pageObjests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public static WebDriver getWebDriver(boolean useYandexBrowser, String chromeDriverPath, String yandexDriverPath) {
        if (useYandexBrowser) {
            System.setProperty("webdriver.chrome.driver", yandexDriverPath);
        } else {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        }
        return new ChromeDriver();
    }
}
