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

public class ConstructorStellerBurgersTest {
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

    UpdateDataApi updateDataApi= new UpdateDataApi();
    String accessToken="";

    @Test
    public void checkGoInConctructorButtonConctructor() {
        //создадим тест данные
        updateDataApi.sendPostRequestRegister(email,password,name);
        //получим токен для удаления данных
        accessToken = updateDataApi.sendPostRequestLogin(email,password);

        //зайдем в аккаунт
        constructorClient.clickButtonLoginInLK(driver,constructorPage.getButtonLoginInLK(),loginPage.getButtonLogin());
        loginClient.setLoginForm(driver,loginPage.getInputEmail(),email,loginPage.getInputPassword(),
                password, loginPage.getButtonLogin(),constructorPage.getButtonMakeOrder());
        constructorClient.clickLKInButtonAuth(driver,constructorPage.getButtonLK(),profilePage.getButtonProfile());

        String buttonText = constructorClient.clickButtonConstructor(driver,constructorPage.getButtonConstructor(),
                constructorPage.getLabelMakeBurger());

        String buttonTextCheck="Соберите бургер";
        MatcherAssert.assertThat(buttonTextCheck,containsString(buttonText));
    }

    @Test
    public void checkGoInConctructorLabel() {
        //создадим тест данные
        updateDataApi.sendPostRequestRegister(email,password,name);
        //получим токен для удаления данных
        accessToken = updateDataApi.sendPostRequestLogin(email,password);

        //зайдем в аккаунт
        constructorClient.clickButtonLoginInLK(driver,constructorPage.getButtonLoginInLK(),loginPage.getButtonLogin());
        loginClient.setLoginForm(driver,loginPage.getInputEmail(),email,loginPage.getInputPassword(),
                password, loginPage.getButtonLogin(),constructorPage.getButtonMakeOrder());
        constructorClient.clickLKInButtonAuth(driver,constructorPage.getButtonLK(),profilePage.getButtonProfile());

        String buttonText = constructorClient.clickLabelSite(driver,constructorPage.getLabelSite(),
                constructorPage.getLabelMakeBurger());

        String buttonTextCheck="Соберите бургер";
        MatcherAssert.assertThat(buttonTextCheck,containsString(buttonText));
    }

    @Test
    public void checkGoToSectionBuns() {
        constructorClient.clickButtonIngridient(driver,constructorPage.getButtonFillings(),
                constructorPage.getLabelFillings());

        String buttonText = constructorClient.clickButtonIngridient(driver,constructorPage.getButtonBuns(),
                constructorPage.getLabelBuns());

        String buttonTextCheck="Булки";
        MatcherAssert.assertThat(buttonTextCheck,containsString(buttonText));
    }

    @Test
    public void checkGoToSectionSauces() {
        String buttonText = constructorClient.clickButtonIngridient(driver,constructorPage.getButtonSauces(),
                constructorPage.getLabelSauces());

        String buttonTextCheck="Соусы";
        MatcherAssert.assertThat(buttonTextCheck,containsString(buttonText));
    }

    @Test
    public void checkGoToSectionFillings() {
        String buttonText = constructorClient.clickButtonIngridient(driver,constructorPage.getButtonFillings(),
                constructorPage.getLabelFillings());

        String buttonTextCheck="Начинки";
        MatcherAssert.assertThat(buttonTextCheck,containsString(buttonText));
    }

    @After
    public void tearDown() {
        baseTest.tearDown(driver);
        updateDataApi.sendDeleteRequestUser(accessToken);
    }
}
