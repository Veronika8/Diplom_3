package model;

import org.openqa.selenium.By;

public class ProfilePage {

    public By getButtonProfile() {
        return buttonProfile;
    }

    //кнопка профиль
    private By buttonProfile = By.xpath(".//a[@class='Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9']");

    public By getButtonLogOut() {
        return buttonLogOut;
    }

    //кнопка выход
    private By buttonLogOut=By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

}
