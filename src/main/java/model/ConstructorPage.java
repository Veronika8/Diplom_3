package model;

import org.openqa.selenium.By;

public class ConstructorPage {
    public By getButtonLoginInLK() {
        return buttonLoginInLK;
    }
    //кнопка Войти в аккаунт
    private By buttonLoginInLK = By.xpath("//*[@id='root']/div/main/section[2]/div/button");

    public By getButtonLK() {
        return buttonLK;
    }

    //кнопка личный кабинет
    private By buttonLK = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");

    public By getButtonConstructor() {
        return buttonConstructor;
    }

    //кнопка Конструктор
    private By buttonConstructor = By.xpath("//*[@id='root']/div/header/nav/ul/li[1]/a");

    public By getLabelSite() {
        return labelSite;
    }

    //логотип
    private By labelSite = By.xpath("//*[@id='root']/div/header/nav/div/a");
    //кнопка профиль
    private By buttonProfile = By.xpath(".//a[@class='Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9']");

    public By getLabelMakeBurger() {
        return labelMakeBurger;
    }

    //заголовос Соберите бургер
    private By labelMakeBurger = By.xpath("//*[@id='root']/div/main/section[1]/h1");

    public By getButtonBuns() {
        return buttonBuns;
    }

    //кнопка Булки
    private By buttonBuns = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[1]/span");

    public By getLabelBuns() {
        return labelBuns;
    }

    //заголовок Булки
    private By labelBuns = By.xpath("//*[@id='root']/div/main/section[1]/div[2]/h2[1]");

    public By getButtonFillings() {
        return buttonFillings;
    }

    //кнопка Начинки
    private By buttonFillings = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[3]/span");

    public By getLabelFillings() {
        return labelFillings;
    }

    //заголовок Начинки
    private By labelFillings = By.xpath("//*[@id='root']/div/main/section[1]/div[2]/h2[3]");

    public By getButtonSauces() {
        return buttonSauces;
    }

    //кнопка Соусы
    private By buttonSauces = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[2]/span");

    public By getLabelSauces() {
        return labelSauces;
    }

    //заголовок Соусы
    private By labelSauces = By.xpath("//*[@id='root']/div/main/section[1]/div[2]/h2[2]");

    public By getButtonMakeOrder() {
        return buttonMakeOrder;
    }

    //кнопка Оформить заказ
    private By buttonMakeOrder = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Оформить заказ']");
}
