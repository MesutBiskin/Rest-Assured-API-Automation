package API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

public class UserAPI {
    public void getUserInfo(String userName) {
        RestAssured.get("https://petstore.swagger.io/v2/user/" + userName).then().statusCode(200);
    }

    public void userCreate() throws JsonProcessingException {
        String jsonPayload = "{\n" +
                "      \"id\": 112233,\n" +
                "      \"username\": \"MstBskn\",\n" +
                "      \"firstName\": \"CanSeker1\",\n" +
                "      \"lastName\": \"Seker\",\n" +
                "      \"email\": \"can@hotmail.com\",\n" +
                "      \"password\": \"erm123456\",\n" +
                "      \"phone\": \"84556860845\",\n" +
                "      \"userStatus\": 1\n" +
                "    }\n";
        User user = new User();
        user.setId(123456);
        user.setUserName("MesutBis");
        user.setFirstName("Mesut");
        user.setLastName("Biskin");
        user.setEmail("mb@gmail.com");
        user.setPassword("123");
        user.setPhone("345");
        user.setUserStatus(1);

        Map<String, Object> headersBody = new HashMap<>();
        headersBody.put("Accept", "application/json");
//        headersBody.put("Content-Type","application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(user);

        System.out.println("JSON Body: " + jsonBody);

        RestAssured.given().headers(headersBody).body(user).contentType(ContentType.JSON).when().post("https://petstore.swagger.io/v2/user").then().log().all();
    }

    public void userUpdate(String userName) {
        String jsonPayload = "{\n" +
                "  \"id\": 6325263562,\n" +
                "  \"username\": \""+userName+"\",\n," +
                "  \"firstName\": \"mesut\",\n" +
                "  \"lastName\": \"biskin\",\n" +
                "  \"email\": \"mbiskin@gmail.com\",\n" +
                "  \"password\": \"s934934\",\n" +
                "  \"phone\": \"7834374837\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        User user = new User();
        user.setId(112233);
        user.setUserName(userName);
        user.setFirstName("CanSeker123");
        user.setLastName("Seker34");
        user.setEmail("can@hotmail.com");
        user.setPassword("erm123456");
        user.setPhone("84556860845");
        user.setUserStatus(1);

        Map<String, Object> headersBody = new HashMap<>();
        headersBody.put("accept", "application/json");
        headersBody.put("Content-Type", "application/json");

        RestAssured.given().headers(headersBody).body(user).contentType(ContentType.JSON).when().put("https://petstore.swagger.io/v2/user/" + userName).then().statusCode(200);
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
