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

public class RegisterStellerBurgersTest {

    private final String name="Testname";
    private final String email="testname123456@mail.ru";
    private final String password="1234567890";
    private final String passwordError="123";

    BaseTest baseTest=new BaseTest();
    WebDriver driver = baseTest.setUp();
    RegisterPage registerPage = new RegisterPage();
    ConstructorPage constructorPage = new ConstructorPage();
    LoginPage loginPage = new LoginPage();
    LoginClient loginClient =new LoginClient();
    RegisterClient registerClient = new RegisterClient();
    ConstructorClient constructorClient = new ConstructorClient();

    UpdateDataApi updateDataApi= new UpdateDataApi();
    String accessToken="";

    @Test
    public void checkSuccessfulRegister() {
        String text = constructorClient.clickLKInButtonNoAuth(driver,constructorPage.getButtonLoginInLK(),loginPage.getButtonLogin());
        String textcheck="Войти";
        MatcherAssert.assertThat(text,containsString(textcheck));

        loginClient.clickLinkRegister(driver,loginPage.getLinkRegister(),registerPage.getLinkLogin());
        String buttonLoginText = registerClient.setRegisterForm(driver,false,registerPage.getInputName(),name,
                registerPage.getInputEmail(),email, registerPage.getInputPassword(),password,
                registerPage.getButtonRegister(),registerPage.getLabelError(), loginPage.getButtonLogin());

        String buttonLoginTextCheck="Зарегистрироваться";
        MatcherAssert.assertThat(buttonLoginTextCheck,containsString(buttonLoginText));

        //получим токен для удаления данных
        accessToken = updateDataApi.sendPostRequestLogin(email,password);
    }

    @Test
    public void checkInvalidRegister() {
        constructorClient.clickLKInButtonNoAuth(driver,constructorPage.getButtonLoginInLK(),loginPage.getButtonLogin());
        loginClient.clickLinkRegister(driver,registerPage.getLinkRegister(),registerPage.getLinkLogin());
        String buttonLoginText = registerClient.setRegisterForm(driver,true,registerPage.getInputName(),name,
                registerPage.getInputEmail(),email, registerPage.getInputPassword(),passwordError,
                registerPage.getButtonRegister(),registerPage.getLabelError(), loginPage.getButtonLogin());

        String buttonErrorTextCheck="Некорректный пароль";
        MatcherAssert.assertThat(buttonErrorTextCheck,containsString(buttonLoginText));
    }

    @After
    public void tearDown() {
        baseTest.tearDown(driver);
        updateDataApi.sendDeleteRequestUser(accessToken);
    }
}
