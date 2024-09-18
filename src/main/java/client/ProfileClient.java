package client;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfileClient {

    @Step("клик по кнопке Выход")
    public String clickButtonLogOut(WebDriver driver,By buttonLogOut,By buttonLogin) {
        driver.findElement(buttonLogOut).click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        return driver.findElement(buttonLogin).getText();
    }
}
