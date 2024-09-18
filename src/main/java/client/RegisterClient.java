package client;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterClient {

    @Step("заполнить форму регистрации")
    public String setRegisterForm(WebDriver driver,boolean error,By inputName, String name, By inputEmail,String email,By inputPassword,
                                String password,By buttonRegister, By labelError, By buttonLogin) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(buttonRegister).click();
        String result;
        if(error) {
            new WebDriverWait(driver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.visibilityOfElementLocated(labelError));
            result= driver.findElement(labelError).getText();
        }
        else {
            new WebDriverWait(driver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
            result = driver.findElement(buttonLogin).getText();
        }
        return result;
    }

    @Step("клик по ссылке Войти")
    public void clickLinkLogin(WebDriver driver,By linkLogin, By buttonLogin){
        driver.findElement(linkLogin).click();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
    }
}
