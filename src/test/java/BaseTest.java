import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public WebDriver setUp() {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.getWindowHandle();
        //перейти на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");
        return driver;
    }

    public void tearDown(WebDriver driver) {
        // Закрой браузер
        driver.quit();
    }
}
