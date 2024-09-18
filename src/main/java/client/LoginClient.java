package client;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginClient {

    @Step("клик по ссылке Зарегистрироваться")
    public void clickLinkRegister(WebDriver driver,By linkRegister,By linkLogin){
        driver.findElement(linkRegister).click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(linkLogin));
    }

    @Step("клик по ссылке Восстановить пароль")
    public void clickLinkRecoverPass(WebDriver driver,By linkRecoverPass,By linkLogin){
        driver.findElement(linkRecoverPass).click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(linkLogin));
    }

    @Step("заполнить форму Вход")
    public String setLoginForm(WebDriver driver,By inputEmail,String email,By inputPassword,String password, By buttonLogin,
                               By buttonMakeOrder) {
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(buttonLogin).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonMakeOrder));
        return driver.findElement(buttonMakeOrder).getText();
    }
}
