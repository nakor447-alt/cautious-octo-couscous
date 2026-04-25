package org.example;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PatchRequestTest extends BaseTest {

    @Test(priority = 1, description = "PATCH запрос - проверка кода ответа")
    public void testPatchStatusCode() {
        given()
                .contentType("application/json")
                .body("{\"field\": \"new value\"}")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200);
    }

    @Test(priority = 2, description = "PATCH запрос - проверка поля url")
    public void testPatchUrl() {
        given()
                .contentType("application/json")
                .body("{\"field\": \"new value\"}")
                .when()
                .patch("/patch")
                .then()
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test(priority = 3, description = "PATCH запрос - проверка данных")
    public void testPatchData() {
        given()
                .contentType("application/json")
                .body("{\"field\": \"new value\"}")
                .when()
                .patch("/patch")
                .then()
                .body("data.field", equalTo("new value"));
    }

    @Test(priority = 4, description = "PATCH запрос - проверка json поля")
    public void testPatchJson() {
        given()
                .contentType("application/json")
                .body("{\"field\": \"new value\"}")
                .when()
                .patch("/patch")
                .then()
                .body("json.field", equalTo("new value"));
    }

    @Test(priority = 5, description = "PATCH запрос - проверка headers")
    public void testPatchHeaders() {
        given()
                .contentType("application/json")
                .body("{\"field\": \"new value\"}")
                .when()
                .patch("/patch")
                .then()
                .body("headers", notNullValue())
                .body("headers.host", equalTo("postman-echo.com"));
    }

    @Test(priority = 6, description = "PATCH запрос - полная проверка")
    public void testPatchFullResponse() {
        Response response = given()
                .contentType("application/json")
                .body("{\"field\": \"new value\"}")
                .when()
                .patch("/patch")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("json.field"),
                "new value");

        printResponse(response);
    }
}