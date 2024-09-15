package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UpdateDataApi {
    @Step("Send to post /api/auth/login")
    public String sendPostRequestLogin(String email,String password) {
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body("{\"email\": \""+email+"\",\"password\": \""+password+"\"}")
                        .when()
                        .post("https://stellarburgers.nomoreparties.site/api/auth/login");
        String accessToken=response.then().extract().body().path("accessToken");
        return accessToken.replace("Bearer ","");
    }
    @Step("Send to post /api/auth/register")
    public String sendPostRequestRegister(String email,String password,String name){
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body("{\"email\": \""+email+"\",\"password\": \""+password+"\",\"name\": \""+name+"\"}")
                        .when()
                        .post("https://stellarburgers.nomoreparties.site/api/auth/register");
        String accessToken=response.then().extract().body().path("accessToken");
        return accessToken.replace("Bearer ","");
    }
    @Step("Send to delete /api/auth/user")
    public void sendDeleteRequestUser(String accessToken) {
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .auth().oauth2(accessToken)
                        .when()
                        .delete("https://stellarburgers.nomoreparties.site/api/auth/user");
    }
}
