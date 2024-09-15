package model;

import org.openqa.selenium.By;

public class RegisterPage {

    public By getLinkRegister() {
        return linkRegister;
    }

    //ссылка зарегистрироваться
    private By linkRegister = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']");

    public By getInputName() {
        return inputName;
    }

    //поле Имя
    private By inputName = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");

    public By getInputEmail() {
        return inputEmail;
    }

    //поле email
    private By inputEmail = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");

    public By getInputPassword() {
        return inputPassword;
    }

    //поле пароль
    private By inputPassword = By.xpath("//*[@id='root']/div/main/div/form/fieldset[3]/div/div/input");

    public By getButtonRegister() {
        return buttonRegister;
    }

    //кнопка Зарегистрироваться
    private By buttonRegister = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Зарегистрироваться']");

    public By getLabelError() {
        return labelError;
    }

    //текст ошибки
    private By labelError = By.xpath(".//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");

    public By getLinkLogin() {
        return linkLogin;
    }

    //ссылка Войти
    private By linkLogin = By.xpath("//*[@id='root']/div/main/div/div/p/a");

}
