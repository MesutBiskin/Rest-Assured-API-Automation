package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

public class UserAPI {
    public void getUserInfo(String userName) {
        RestAssured.get("https://petstore.swagger.io/v2/user/" + userName).then().statusCode(200);
    }

    public void userCreate() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", 112233);
        requestBody.put("userName", "MstBskn");
        requestBody.put("firstName", "Can");
        requestBody.put("lastName", "Seker");
        requestBody.put("email", "cn@hotmail.com");
        requestBody.put("password", "123");
        requestBody.put("phone", "7384638746");
        requestBody.put("userStatus", 1);

        Map<String, Object> headersBody = new HashMap<>();
        headersBody.put("Accept", "application/json");
//        headersBody.put("Content-Type","application/json");

        RestAssured.given().headers(headersBody).body(requestBody).contentType(ContentType.JSON).when().post("https://petstore.swagger.io/v2/user").then().log().all();
    }

    public void userUpdate(String userName) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", 112233);
        requestBody.put("userName", userName);
        requestBody.put("firstName", "Can12");
        requestBody.put("lastName", "Seker12");
        requestBody.put("email", "cn@hotmail.com");
        requestBody.put("password", "123");
        requestBody.put("phone", "7384638746");
        requestBody.put("userStatus", 1);

        Map<String, Object> headersBody = new HashMap<>();
        headersBody.put("accept", "application/json");
        headersBody.put("Content-Type", "application/json");

        RestAssured.given().headers(headersBody).body(requestBody).contentType(ContentType.JSON).when().put("https://petstore.swagger.io/v2/user/" + userName).then().statusCode(200);
    }

    public void userDelete(String userName) {
        Map<String, Object> headersBody = new HashMap<>();
        headersBody.put("accept", "application/json");

        RestAssured.given().headers(headersBody).contentType(ContentType.JSON).when().delete("https://petstore.swagger.io/v2/user/" + userName).then().statusCode(200);
    }

    public void userLogin() {
        Map<String, Object> headersBody = new HashMap<>();
        headersBody.put("accept", "application/json");

        RestAssured.given().headers(headersBody).contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/login/").then().statusCode(200);

    }
}
