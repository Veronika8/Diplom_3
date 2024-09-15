import api.UpdateDataApi;
import client.ConstructorClient;
import client.LoginClient;
import client.ProfileClient;
import model.ConstructorPage;
import model.LoginPage;
import model.ProfilePage;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;

public class LogOutStellerBurgersTest {
    private final String name="Testname";
    private final String email="testname123456@mail.ru";
    private final String password="1234567890";

    BaseTest baseTest=new BaseTest();
    WebDriver driver = baseTest.setUp();
    ConstructorClient constructorClient = new ConstructorClient();
    ConstructorPage constructorPage = new ConstructorPage();
    LoginPage loginPage = new LoginPage();
    LoginClient loginClient = new LoginClient();
    ProfilePage profilePage = new ProfilePage();
    ProfileClient profileClient = new ProfileClient();

    @Test
    public void checkLogOut() {
        //создадим тест данные
        UpdateDataApi updateDataApi= new UpdateDataApi();
        updateDataApi.sendPostRequestRegister(email,password,name);

        //зайдем в аккаунт
        constructorClient.clickButtonLoginInLK(driver,constructorPage.getButtonLoginInLK(),loginPage.getButtonLogin());
        loginClient.setLoginForm(driver,loginPage.getInputEmail(),email,loginPage.getInputPassword(),
                password, loginPage.getButtonLogin(),constructorPage.getButtonMakeOrder());
        constructorClient.clickLKInButtonAuth(driver,constructorPage.getButtonLK(),profilePage.getButtonProfile());

        String buttonText=profileClient.clickButtonLogOut(driver,profilePage.getButtonLogOut(),loginPage.getButtonLogin());

        String buttonTextCheck="Войти";
        MatcherAssert.assertThat(buttonTextCheck,containsString(buttonText));

        //удалим тест данные
        String accessToken = updateDataApi.sendPostRequestLogin(email,password);
        updateDataApi.sendDeleteRequestUser(accessToken);
    }

    @After
    public void tearDown() {
        baseTest.tearDown(driver);
    }
}