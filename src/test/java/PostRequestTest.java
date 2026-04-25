package org.example;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostRequestTest extends BaseTest {

    @Test(priority = 1, description = "POST запрос - проверка кода ответа")
    public void testPostStatusCode() {
        given()
                .contentType("application/json")
                .body("{\"name\": \"Test\", \"value\": \"123\"}")
                .when()
                .post("/post")
                .then()
                .statusCode(200);
    }

    @Test(priority = 2, description = "POST запрос - проверка поля url")
    public void testPostUrl() {
        given()
                .contentType("application/json")
                .body("{\"name\": \"Test\", \"value\": \"123\"}")
                .when()
                .post("/post")
                .then()
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test(priority = 3, description = "POST запрос - проверка отправленных данных")
    public void testPostData() {
        given()
                .contentType("application/json")
                .body("{\"name\": \"Test\", \"value\": \"123\"}")
                .when()
                .post("/post")
                .then()
                .body("data.name", equalTo("Test"))
                .body("data.value", equalTo("123"));
    }

    @Test(priority = 4, description = "POST запрос - проверка json поля")
    public void testPostJson() {
        given()
                .contentType("application/json")
                .body("{\"name\": \"Test\", \"value\": \"123\"}")
                .when()
                .post("/post")
                .then()
                .body("json.name", equalTo("Test"))
                .body("json.value", equalTo("123"));
    }

    @Test(priority = 5, description = "POST запрос - проверка headers")
    public void testPostHeaders() {
        given()
                .contentType("application/json")
                .body("{\"name\": \"Test\", \"value\": \"123\"}")
                .when()
                .post("/post")
                .then()
                .body("headers", notNullValue())
                .body("headers.host", equalTo("postman-echo.com"));
    }

    @Test(priority = 6, description = "POST запрос - полная проверка")
    public void testPostFullResponse() {
        String requestBody = "{\"name\": \"Test\", \"value\": \"123\"}";

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("url"),
                "https://postman-echo.com/post");
        Assert.assertEquals(response.jsonPath().getString("data.name"), "Test");
        Assert.assertEquals(response.jsonPath().getString("data.value"), "123");

        printResponse(response);
    }
}