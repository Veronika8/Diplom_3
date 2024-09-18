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

    UpdateDataApi updateDataApi= new UpdateDataApi();
    String accessToken="";

    @Test
    public void checkLoginInButtonLoginInLK() {
        //создадим тест данные
        updateDataApi.sendPostRequestRegister(email,password,name);
        //получим токен для удаления данных
        accessToken = updateDataApi.sendPostRequestLogin(email,password);

        constructorClient.clickButtonLoginInLK(driver,constructorPage.getButtonLoginInLK(),loginPage.getButtonLogin());
        String buttonText = loginClient.setLoginForm(driver,loginPage.getInputEmail(),email,loginPage.getInputPassword(),
                password, loginPage.getButtonLogin(),constructorPage.getButtonMakeOrder());

        String buttonTextCheck="Оформить заказ";
        MatcherAssert.assertThat(buttonTextCheck,containsString(buttonText));
    }

    @Test
    public void checkLoginInButtonLk() {
        //создадим тест данные
        updateDataApi.sendPostRequestRegister(email,password,name);
        //получим токен для удаления данных
        accessToken = updateDataApi.sendPostRequestLogin(email,password);

        constructorClient.clickLKInButtonNoAuth(driver,constructorPage.getButtonLoginInLK(),loginPage.getButtonLogin());
        String buttonText = loginClient.setLoginForm(driver,loginPage.getInputEmail(),email,loginPage.getInputPassword(),
                password, loginPage.getButtonLogin(),constructorPage.getButtonMakeOrder());

        String buttonTextCheck="Оформить заказ";
        MatcherAssert.assertThat(buttonTextCheck,containsString(buttonText));
    }

    @Test
    public void checkLoginInRegPage() {
        //создадим тест данные
        updateDataApi.sendPostRequestRegister(email,password,name);
        //получим токен для удаления данных
        accessToken = updateDataApi.sendPostRequestLogin(email,password);

        constructorClient.clickLKInButtonNoAuth(driver,constructorPage.getButtonLoginInLK(),loginPage.getButtonLogin());
        loginClient.clickLinkRegister(driver,loginPage.getLinkRegister(),registerPage.getLinkLogin());
        registerClient.clickLinkLogin(driver,loginPage.getLinkLogin(),loginPage.getButtonLogin());
        String buttonText = loginClient.setLoginForm(driver,loginPage.getInputEmail(),email,loginPage.getInputPassword(),
                password, loginPage.getButtonLogin(),constructorPage.getButtonMakeOrder());

        String buttonTextCheck="Оформить заказ";
        MatcherAssert.assertThat(buttonTextCheck,containsString(buttonText));
    }

    @Test
    public void checkLoginInRecoverPassPage() {
        //создадим тест данные
        updateDataApi.sendPostRequestRegister(email,password,name);
        //получим токен для удаления данных
        accessToken = updateDataApi.sendPostRequestLogin(email,password);

        constructorClient.clickLKInButtonNoAuth(driver,constructorPage.getButtonLoginInLK(),loginPage.getButtonLogin());
        loginClient.clickLinkRecoverPass(driver,loginPage.getLinkRecoverPass(),loginPage.getLinkLogin());
        registerClient.clickLinkLogin(driver,loginPage.getLinkLogin(),loginPage.getButtonLogin());
        String buttonText = loginClient.setLoginForm(driver,loginPage.getInputEmail(),email,loginPage.getInputPassword(),
                password, loginPage.getButtonLogin(),constructorPage.getButtonMakeOrder());

        String buttonTextCheck="Оформить заказ";
        MatcherAssert.assertThat(buttonTextCheck,containsString(buttonText));
    }

    @After
    public void tearDown() {
        baseTest.tearDown(driver);
        updateDataApi.sendDeleteRequestUser(accessToken);
    }
}
