import api.UpdateDataApi;
import client.ConstructorClient;
import client.LoginClient;
import client.RegisterClient;
import model.ConstructorPage;
import model.LoginPage;
import model.RegisterPage;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;

public class LoginStellerBurgersTest {

    private final String name="Testname";
    private final String email="testname123456@mail.ru";
    private final String password="1234567890";

    BaseTest baseTest=new BaseTest();
    WebDriver driver = baseTest.setUp();
    ConstructorClient constructorClient = new ConstructorClient();
    ConstructorPage constructorPage = new ConstructorPage();
    LoginPage loginPage =new LoginPage();
    LoginClient loginClient =new LoginClient();
    RegisterPage registerPage =new RegisterPage();
    RegisterClient registerClient =new RegisterClient();

    @Test
    public void checkLoginInButtonLoginInLK() {
        //создадим тест данные
        UpdateDataApi updateDataApi= new UpdateDataApi();
        String accessToken = updateDataApi.sendPostRequestRegister(email,password,name);

        constructorClient.clickButtonLoginInLK(driver,constructorPage.getButtonLoginInLK(),loginPage.getButtonLogin());
        String buttonText = loginClient.setLoginForm(driver,loginPage.getInputEmail(),email,loginPage.getInputPassword(),
                password, loginPage.getButtonLogin(),constructorPage.getButtonMakeOrder());

        String buttonTextCheck="Оформить заказ";
        MatcherAssert.assertThat(buttonTextCheck,containsString(buttonText));

        //удалим тест данные
        updateDataApi.sendDeleteRequestUser(accessToken);
    }

    @Test
    public void checkLoginInButtonLk() {
        //создадим тест данные
        UpdateDataApi updateDataApi= new UpdateDataApi();
        String accessToken = updateDataApi.sendPostRequestRegister(email,password,name);

        constructorClient.clickLKInButtonNoAuth(driver,constructorPage.getButtonLoginInLK(),loginPage.getButtonLogin());
        String buttonText = loginClient.setLoginForm(driver,loginPage.getInputEmail(),email,loginPage.getInputPassword(),
                password, loginPage.getButtonLogin(),constructorPage.getButtonMakeOrder());

        String buttonTextCheck="Оформить заказ";
        MatcherAssert.assertThat(buttonTextCheck,containsString(buttonText));

        //удалим тест данные
        updateDataApi.sendDeleteRequestUser(accessToken);
    }

    @Test
    public void checkLoginInRegPage() {
        //создадим тест данные
        UpdateDataApi updateDataApi= new UpdateDataApi();
        String accessToken = updateDataApi.sendPostRequestRegister(email,password,name);

        constructorClient.clickLKInButtonNoAuth(driver,constructorPage.getButtonLoginInLK(),loginPage.getButtonLogin());
        loginClient.clickLinkRegister(driver,loginPage.getLinkRegister(),registerPage.getLinkLogin());
        registerClient.clickLinkLogin(driver,loginPage.getLinkRegister(),loginPage.getButtonLogin());
        String buttonText = loginClient.setLoginForm(driver,loginPage.getInputEmail(),email,loginPage.getInputPassword(),
                password, loginPage.getButtonLogin(),constructorPage.getButtonMakeOrder());

        String buttonTextCheck="Оформить заказ";
        MatcherAssert.assertThat(buttonTextCheck,containsString(buttonText));

        //удалим тест данные
        updateDataApi.sendDeleteRequestUser(accessToken);
    }

    @Test
    public void checkLoginInRecoverPassPage() {
        //создадим тест данные
        UpdateDataApi updateDataApi= new UpdateDataApi();
        String accessToken = updateDataApi.sendPostRequestRegister(email,password,name);

        constructorClient.clickLKInButtonNoAuth(driver,constructorPage.getButtonLoginInLK(),loginPage.getButtonLogin());
        loginClient.clickLinkRecoverPass(driver,loginPage.getLinkRecoverPass(),loginPage.getLinkLogin());
        registerClient.clickLinkLogin(driver,loginPage.getLinkRegister(),loginPage.getButtonLogin());
        String buttonText = loginClient.setLoginForm(driver,loginPage.getInputEmail(),email,loginPage.getInputPassword(),
                password, loginPage.getButtonLogin(),constructorPage.getButtonMakeOrder());

        String buttonTextCheck="Оформить заказ";
        MatcherAssert.assertThat(buttonTextCheck,containsString(buttonText));

        //удалим тест данные
        updateDataApi.sendDeleteRequestUser(accessToken);
    }

    @After
    public void tearDown() {
        baseTest.tearDown(driver);
    }
}
