import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTestConfigModules extends AbstractModule {

    @Provides
    ChromeOptions getChromeOptions() {
        return new ChromeOptions();
    }

    @Provides
    WebDriver getDriver(ChromeOptions chromeOptions) {
        String browserPropValue = System.getProperty("browser");
        if (browserPropValue != null && browserPropValue.equals("yandex")){
            System.setProperty("webdriver.chrome.driver", "./Users/daria/WebDriver/yandexdriver");
            return new ChromeDriver();
        }
        return new ChromeDriver(chromeOptions);
    }
}