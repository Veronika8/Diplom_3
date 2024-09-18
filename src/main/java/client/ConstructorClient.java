package client;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorClient {

    @Step("Клик по кнопке Личный кабинет неавторизованным пользователем")
    public String clickLKInButtonNoAuth(WebDriver driver,By buttonLK, By buttonLogin){
        driver.findElement(buttonLK).click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        return driver.findElement(buttonLogin).getText();
    }

    @Step("Клик по кнопке Личный кабинет авторизованным пользователем")
    public String clickLKInButtonAuth(WebDriver driver,By buttonLK, By buttonProfile){
        driver.findElement(buttonLK).click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonProfile));
        return driver.findElement(buttonProfile).getText();
    }

    @Step("клик по кнопке Конструктор")
    public String clickButtonConstructor(WebDriver driver,By buttonConstructor, By labelMakeBurger) {
        driver.findElement(buttonConstructor).click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(labelMakeBurger));
        return driver.findElement(labelMakeBurger).getText();
    }

    @Step("клик по логотипу StellerBurgers")
    public String clickLabelSite(WebDriver driver,By labelSite, By labelMakeBurger){
        driver.findElement(labelSite).click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(labelMakeBurger));
        return driver.findElement(labelMakeBurger).getText();
    }

    @Step("клик по кнопке Булки/Начинки/Соусы")
    public String clickButtonIngridient(WebDriver driver,By button,By label) {
        driver.findElement(button).click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(label));
        return driver.findElement(label).getText();
    }

    @Step("клик по кнопке Войти в аккаунт")
    public  void clickButtonLoginInLK(WebDriver driver,By buttonLoginInLK,By buttonLogin) {
        driver.findElement(buttonLoginInLK).click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
    }
}
