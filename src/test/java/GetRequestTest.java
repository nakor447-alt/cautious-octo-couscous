package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequestTest extends BaseTest {

    @Test(priority = 1, description = "GET запрос - проверка кода ответа")
    public void testGetStatusCode() {
        given()
                .when()
                .get("/get")
                .then()
                .statusCode(200);
    }

    @Test(priority = 2, description = "GET запрос - проверка поля url")
    public void testGetUrl() {
        given()
                .when()
                .get("/get")
                .then()
                .body("url", equalTo("https://postman-echo.com/get"));
    }

    @Test(priority = 3, description = "GET запрос - проверка наличия headers")
    public void testGetHeaders() {
        given()
                .when()
                .get("/get")
                .then()
                .body("headers", notNullValue())
                .body("headers.host", equalTo("postman-echo.com"));
    }

    @Test(priority = 4, description = "GET запрос - проверка поля args")
    public void testGetArgs() {
        given()
                .when()
                .get("/get")
                .then()
                .body("args", notNullValue());
    }

    @Test(priority = 5, description = "GET запрос - полная проверка тела ответа")
    public void testGetFullResponse() {
        Response response = given()
                .when()
                .get("/get")
                .then()
                .extract().response();

        // Проверяем код ответа
        Assert.assertEquals(response.getStatusCode(), 200);

        // Получаем JSON как объект
        String url = response.jsonPath().getString("url");
        String host = response.jsonPath().getString("headers.host");

        // Проверяем значения
        Assert.assertEquals(url, "https://postman-echo.com/get");
        Assert.assertEquals(host, "postman-echo.com");

        // Печатаем для проверки
        printResponse(response);
    }
}