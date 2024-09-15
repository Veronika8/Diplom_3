package model;

import org.openqa.selenium.By;

public class LoginPage {
    public By getLinkRegister() {
        return linkRegister;
    }

    //ссылка зарегистрироваться
    private By linkRegister = By.xpath("//*[@id='root']/div/main/div/div/p[1]/a");

    public By getLinkLogin() {
        return linkLogin;
    }

    //ссылка Войти на странице Зарегистрироваться и Восстановить пароль
    private By linkLogin = By.xpath("//*[@id='root']/div/main/div/div/p/a");

    public By getLinkRecoverPass() {
        return linkRecoverPass;
    }

    //ссылка Восстановить пароль
    private By linkRecoverPass = By.xpath("//*[@id='root']/div/main/div/div/p[2]/a");

    public By getInputEmail() {
        return inputEmail;
    }

    //поле email
    private By inputEmail = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");

    public By getInputPassword() {
        return inputPassword;
    }

    //поле пароль
    private By inputPassword = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");

    public By getButtonLogin() {
        return buttonLogin;
    }

    //кнопка Войти
    private By buttonLogin = By.xpath("//*[@id='root']/div/main/div/form/button");
}
