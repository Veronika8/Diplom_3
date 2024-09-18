import api.UpdateDataApi;
import client.ConstructorClient;
import client.LoginClient;
import model.ConstructorPage;
import model.LoginPage;
import model.ProfilePage;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;

public class ProfileStellerBurgersTest {
    private final String name="Testname";
    private final String email="testname123456@mail.ru";
    private final String password="1234567890";

    BaseTest baseTest=new BaseTest();
    WebDriver driver = baseTest.setUp();
    ConstructorClient constructorClient = new ConstructorClient();
    ConstructorPage constructorPage = new ConstructorPage();
    LoginPage loginPage =new LoginPage();
    LoginClient loginClient =new LoginClient();
    ProfilePage profilePage =new ProfilePage();

    UpdateDataApi updateDataApi= new UpdateDataApi();
    String accessToken="";

    @Test
    public void checkGoToProfile() {
        //создадим тест данные
        updateDataApi.sendPostRequestRegister(email,password,name);
        //получим токен для удаления данных
        accessToken = updateDataApi.sendPostRequestLogin(email,password);

        //зайдем в аккаунт
        constructorClient.clickButtonLoginInLK(driver,constructorPage.getButtonLoginInLK(),loginPage.getButtonLogin());
        loginClient.setLoginForm(driver,loginPage.getInputEmail(),email,loginPage.getInputPassword(),
                password, loginPage.getButtonLogin(),constructorPage.getButtonMakeOrder());

        String buttonProfileText = constructorClient.clickLKInButtonAuth(driver,constructorPage.getButtonLK(),profilePage.getButtonProfile());

        String buttonProfileTextCheck="Профиль";
        MatcherAssert.assertThat(buttonProfileTextCheck,containsString(buttonProfileText));
    }

    @After
    public void tearDown() {
        baseTest.tearDown(driver);
        updateDataApi.sendDeleteRequestUser(accessToken);
    }
}
