package model;

import org.openqa.selenium.By;

public class ConstructorPage {
    public By getButtonLoginInLK() {
        return buttonLoginInLK;
    }
    //кнопка Войти в аккаунт
    private By buttonLoginInLK = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    public By getButtonLK() {
        return buttonLK;
    }

    //кнопка личный кабинет
    private By buttonLK = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");

    public By getButtonConstructor() {
        return buttonConstructor;
    }

    //кнопка Конструктор
    private By buttonConstructor = By.xpath(".//a[@class='AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo']");

    public By getLabelSite() {
        return labelSite;
    }

    //логотип
    private By labelSite = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']");

    public By getLabelMakeBurger() {
        return labelMakeBurger;
    }

    //заголовок Соберите бургер
    private By labelMakeBurger = By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10']");

    public By getButtonBuns() {
        return buttonBuns;
    }

    //кнопка Булки
    private By buttonBuns = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']");

    public By getLabelBuns() {
        return labelBuns;
    }

    //заголовок Булки
    private By labelBuns = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']");

    public By getButtonFillings() {
        return buttonFillings;
    }

    //кнопка Начинки
    private By buttonFillings = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']");

    public By getLabelFillings() {
        return labelFillings;
    }

    //заголовок Начинки
    private By labelFillings = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']");

    public By getButtonSauces() {
        return buttonSauces;
    }

    //кнопка Соусы
    private By buttonSauces = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']");

    public By getLabelSauces() {
        return labelSauces;
    }

    //заголовок Соусы
    private By labelSauces = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Соусы']");

    public By getButtonMakeOrder() {
        return buttonMakeOrder;
    }

    //кнопка Оформить заказ
    private By buttonMakeOrder = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Оформить заказ']");
}
