package model;

import org.openqa.selenium.By;

public class LoginPage {
    public By getLinkRegister() {
        return linkRegister;
    }

    //ссылка зарегистрироваться
    private By linkRegister = By.xpath(".//a[@class='Auth_link__1fOlj' and @href='/register']");

    public By getLinkLogin() {
        return linkLogin;
    }

    //ссылка Войти на странице Зарегистрироваться и Восстановить пароль
    private By linkLogin = By.xpath(".//a[@class='Auth_link__1fOlj' and @href='/login']");

    public By getLinkRecoverPass() {
        return linkRecoverPass;
    }

    //ссылка Восстановить пароль
    private By linkRecoverPass = By.xpath(".//a[@class='Auth_link__1fOlj' and @href='/forgot-password']");

    public By getInputEmail() {
        return inputEmail;
    }

    //поле email
    private By inputEmail = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @type='text']");

    public By getInputPassword() {
        return inputPassword;
    }

    //поле пароль
    private By inputPassword = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @type='password']");

    public By getButtonLogin() {
        return buttonLogin;
    }

    //кнопка Войти
    private By buttonLogin = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
}
